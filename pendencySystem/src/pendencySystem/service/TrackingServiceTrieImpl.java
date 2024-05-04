package pendencySystem.service;

import java.util.List;

import pendencySystem.data.TrackingServiceStrategy;
import pendencySystem.data.Trie;
import pendencySystem.data.Trie.TrieNode;

public class TrackingServiceTrieImpl implements TrackingService {

	private final Integer tagsLimit = 10;
	private final static Trie trieBasedRepository = new Trie();

	@Override
	public synchronized void startTracking(Integer entityId, List<String> hierarchicalTags) {
		if (hierarchicalTags.size() > tagsLimit) {
			throw new RuntimeException("Cannot consider more than 10 tags for tracking");
		}
		EntityRepository.createEntity(entityId, hierarchicalTags);
		TrieNode node = trieBasedRepository.getRoot();
		for (String tag : hierarchicalTags) {
			node = node.getChildren().computeIfAbsent(tag, k -> new TrieNode());
			node.setCount(node.getCount() + 1);
		}
		TrackingInfoRepository.startTracking(entityId);
	}

	@Override
	public synchronized void stopTracking(Integer entityId) {
		List<String> hierarchicalTags = EntityRepository.retrieveEntity(entityId).getTags();
		if (hierarchicalTags != null) {
			TrieNode node = trieBasedRepository.getRoot();
			for (String tag : hierarchicalTags) {
				node = node.getChildren().get(tag);
				node.setCount(node.getCount() - 1);
			}
		}		
		TrackingInfoRepository.stopTracking(entityId);
	}

	@Override
	public Integer getCount(List<String> tags) {
		TrieNode node = trieBasedRepository.getRoot();
		for (String tag : tags) {
			node = node.getChildren().get(tag);
			if (node == null) {
				return 0;
			}
		}
		return node.getCount();
	}

	@Override
	public String getStrategy() {
		return TrackingServiceStrategy.TrieBased.name();		
	}

}

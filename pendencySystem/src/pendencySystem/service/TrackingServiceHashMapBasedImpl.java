package pendencySystem.service;

import java.util.List;

import pendencySystem.data.TrackingServiceStrategy;
import pendencySystem.domain.Entity;

public class TrackingServiceHashMapBasedImpl implements TrackingService {

	private final Integer tagsLimit = 10;

	@Override
	public void startTracking(Integer entityId, List<String> tags) {
		if (tags.size() > tagsLimit) {
			throw new RuntimeException("Cannot consider more than 10 tags for tracking");
		}
		EntityRepository.createEntity(entityId, tags);
		final StringBuilder tagName = new StringBuilder();
		tags.stream().forEach(tag -> {
			tagName.append(tag);
			TagRepository.addTag(tagName.toString());
		});
		TrackingInfoRepository.startTracking(entityId);
	}

	@Override
	public void stopTracking(Integer entityId) {
		final Entity entity = EntityRepository.retrieveEntity(entityId);
		final List<String> tags = entity.getTags();
		final StringBuilder tagName = new StringBuilder();
		tags.stream().forEach(tag -> {
			tagName.append(tag);
			TagRepository.decrementCount(tagName.toString());
		});
		TrackingInfoRepository.stopTracking(entityId);
	}

	@Override
	public Integer getCount(List<String> tags) {
		final StringBuilder tagName = new StringBuilder();
		tags.stream().forEach(tag -> {
			tagName.append(tag);
		});
		return TagRepository.getCount(tagName.toString());
	}

	@Override
	public String getStrategy() {
		return TrackingServiceStrategy.HashMapBased.name();
	}

}

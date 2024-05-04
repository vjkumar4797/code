package pendencySystem.service;

import java.util.HashMap;
import java.util.Map;


public class TagRepository {

	private static Map<String, Integer> tagRepository;

	public static void initialize() {
		tagRepository = new HashMap<>();
	}

	public synchronized static void addTag(String tagName) {
		Integer count = tagRepository.get(tagName);
		if (count == null) {
			count = 0;
		}
		count++;
		tagRepository.put(tagName, count);
	}

	public synchronized static void deleteTag(String tagName) {
		tagRepository.remove(tagName);
	}

	public synchronized static void decrementCount(String tagName) {
		Integer count = tagRepository.get(tagName);
		if (count != null && count > 0) {
			count--;
			tagRepository.put(tagName, count);
		}
	}

	public static Integer getCount(String tagName) {
		Integer count = tagRepository.get(tagName);
		if (count == null) {
			count = 0;
		}
		return count;
	}
}

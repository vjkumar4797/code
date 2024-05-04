package pendencySystem.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pendencySystem.domain.Entity;

public class EntityRepository {

	private static Map<Integer, Entity> entityRepository;

	public static void initialize() {
		entityRepository = new HashMap<>();
	}

	public static void createEntity(Integer id, List<String> tags) {
		final Entity entity = new Entity(id, tags);
		entityRepository.put(id, entity);
	}

	public static Entity retrieveEntity(Integer id) {
		return entityRepository.get(id);
	}

	public static void removeEntity(Integer id) {
		entityRepository.remove(id);
	}
}

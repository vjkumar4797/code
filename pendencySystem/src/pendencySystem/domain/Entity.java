package pendencySystem.domain;

import java.util.List;

public class Entity {

	private Integer id;
	private List<String> tags;

	public Entity(Integer id, List<String> tags) {
		this.id = id;
		this.tags = tags;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<String> getTags() {
		return tags;
	}

	public void setTags(List<String> tags) {
		this.tags = tags;
	}

}

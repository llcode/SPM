package domain;

import java.util.Set;

public class Author {

	private Integer aid;
	private String name;
	private String description;

	private Set<Poem> poems;

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Poem> getPoems() {
		return poems;
	}

	public void setPoems(Set<Poem> poems) {
		this.poems = poems;
	}

}

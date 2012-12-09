package domain;

import java.util.Set;

public class Favorite {

	private Integer fid;
	private String name;

	private UserCount owner;

	private Set<Poem> poemLists;

	public Integer getFid() {
		return fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public UserCount getOwner() {
		return owner;
	}

	public void setOwner(UserCount owner) {
		this.owner = owner;
	}

	public Set<Poem> getPoemLists() {
		return poemLists;
	}

	public void setPoemLists(Set<Poem> poemLists) {
		this.poemLists = poemLists;
	}

	// This method is used in FavoriteAction to check whether a poem is in poem list
	// Because the Set contains method would check every property of poem including references.
	// So they are impossible to be equal. ^-^
	public boolean hasPoem(Poem poem) {
		for (Poem p : poemLists) {
			if (p.getPid() == poem.getPid()) {
				return true;
			}
		}
		return false;
	}
}

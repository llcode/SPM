package domain;

import java.util.Set;

public class UserCount {

	private Integer userid;
	private String name;
	private String email;
	private String password;

	private Set<Favorite> favorites;
	private Set<MyNewPoem> newPoemInfos;

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(Set<Favorite> favorites) {
		this.favorites = favorites;
	}

	public Set<MyNewPoem> getNewPoemInfos() {
		return newPoemInfos;
	}

	public void setNewPoemInfos(Set<MyNewPoem> newPoemInfos) {
		this.newPoemInfos = newPoemInfos;
	}

}

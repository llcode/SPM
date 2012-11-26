package domain;

import java.util.Set;

public class Album {
	private Integer albumid; // 主键 相册编号
	private UserCount owner; // 相册所有者
	private String name; // 相册名
	private String description; // 相册描述
	private Integer power; // 权限 1公开 0隐私
	private String cover; // 封面
	private String status; // 状态 1正常 0删除
	private Set<Photo> photos;

	public Set<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(Set<Photo> photos) {
		this.photos = photos;
	}

	public Integer getAlbumid() {
		return albumid;
	}

	public void setAlbumid(Integer albumid) {
		this.albumid = albumid;
	}

	public UserCount getOwner() {
		return owner;
	}

	public void setOwner(UserCount user) {
		this.owner = user;
	}

	// public Set<Photo> getPhotos() {
	// return photos;
	// }
	// public void setPhotos(Set<Photo> photos) {
	// this.photos = photos;
	// }
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

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}

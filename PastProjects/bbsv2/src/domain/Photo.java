package domain;

import java.util.Date;
import java.util.Set;

public class Photo {
	private Integer photoid;
	private String title;
	private String description;
	private String picurl;					//ͼƬ·��
	private String picliteurl;				//����ͼ·��
	private Date uploadtime;			//�ϴ�ʱ��
	private Album album;			//�������
	private Set<Reply> replys;
	
	
	public Set<Reply> getReplys() {
		return replys;
	}

	public void setReplys(Set<Reply> replys) {
		this.replys = replys;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}

	public Integer getPhotoid() {
		return photoid;
	}

	public void setPhotoid(Integer photoid) {
		this.photoid = photoid;
	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPicurl() {
		return picurl;
	}

	public void setPicurl(String picurl) {
		this.picurl = picurl;
	}

	public String getPicliteurl() {
		return picliteurl;
	}

	public void setPicliteurl(String picliteurl) {
		this.picliteurl = picliteurl;
	}

	public Date getUploadtime() {
		return uploadtime;
	}

	public void setUploadtime(Date uploadtime) {
		this.uploadtime = uploadtime;
	}

}

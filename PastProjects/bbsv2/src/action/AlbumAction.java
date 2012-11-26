package action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;

import dao.AlbumDao;
import domain.Album;
import domain.UserCount;

public class AlbumAction {

	private AlbumDao albumDao;

	private UserCount userCount;
	private List<Album> pubAlbums;
	private List<Album> myAlbums;

	public UserCount getUserCount() {
		return userCount;
	}

	public void setUserCount(UserCount userCount) {
		this.userCount = userCount;
	}

	public List<Album> getPubAlbums() {
		return pubAlbums;
	}

	public void setPubAlbums(List<Album> pubAlbums) {
		this.pubAlbums = pubAlbums;
	}

	public List<Album> getMyAlbums() {
		return myAlbums;
	}

	public void setMyAlbums(List<Album> myAlbums) {
		this.myAlbums = myAlbums;
	}

	public void setAlbumDao(AlbumDao albumDao) {
		this.albumDao = albumDao;
	}

	
	public String goAlbumIndex() {
		pubAlbums = albumDao.queryAlbums();
		userCount = (UserCount) ActionContext.getContext().getSession()
				.get("userInSession");
		// 测试用数据:模拟登录
		userCount = new UserCount();
		userCount.setUserid(43);
		if (userCount != null) {
			myAlbums = albumDao.queryAlbumsByUser(userCount);
			// 从公共移除私有
			// pubAlbums.removeAll(myAlbums);
			for (int i = 0; i < pubAlbums.size(); i++) {
				for (int j = 0; j < myAlbums.size(); j++) {
					if (pubAlbums.get(i).getAlbumid() == myAlbums.get(j)
							.getAlbumid()) {
						pubAlbums.remove(i--);
						break;
					}
				}
			}
		}
		return "index";
	}
}

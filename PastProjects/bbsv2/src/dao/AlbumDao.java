package dao;

import java.util.List;

import domain.Album;
import domain.UserCount;

public interface AlbumDao {

	public List<Album> queryAlbums();

	public List<Album> queryAlbumsByUser(UserCount userCount);

}

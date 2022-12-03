package com.changgou.dao;

import com.changgou.album.pojo.Album;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AlbumDao {
    void add(Album album);

    List<Album> search(Album album);

    List<Album> findPage(Integer page, Integer size);

    List<Album> searchPage(Album album);
}

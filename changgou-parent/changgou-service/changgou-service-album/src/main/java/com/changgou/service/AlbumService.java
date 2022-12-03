package com.changgou.service;

import com.changgou.album.pojo.Album;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AlbumService {
    void add(Album album);

    List<Album> search(Album album);

    PageInfo<Album> findPage(Integer page, Integer size);

    PageInfo<Album> searchPage(Integer page, Integer size, Album album);
}

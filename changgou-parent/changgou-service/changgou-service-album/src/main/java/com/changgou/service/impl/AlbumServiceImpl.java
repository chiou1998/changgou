package com.changgou.service.impl;

import com.changgou.album.pojo.Album;
import com.changgou.dao.AlbumDao;
import com.changgou.goods.pojo.Brand;
import com.changgou.service.AlbumService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumDao albumdao;
    @Override
    public void add(Album album) {
        albumdao.add(album);
    }

    @Override
    public List<Album> search(Album album) {
        List<Album> list = albumdao.search(album);
        return list;
    }

    @Override
    public PageInfo<Album> findPage(Integer page, Integer size) {
        if (page==null) {
            page=1;
        }
        if (size==null) {
            size=10;
        }
        PageHelper.startPage(page,size);
        List<Album> page1= albumdao.findPage(page,size);
        PageInfo<Album> pageInfo = new PageInfo<Album>(page1);
        return pageInfo;
    }

    @Override
    public PageInfo<Album> searchPage(Integer page, Integer size,Album album) {
        if (page==null) {
            page=1;
        }
        if (size==null) {
            size=10;
        }
        PageHelper.startPage(page,size);
        List<Album> page1= albumdao.searchPage(album);
        PageInfo<Album> pageInfo = new PageInfo<Album>(page1);
        return pageInfo;
    }
}

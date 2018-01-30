package com.ecas.common.base.service.impl;

import com.ecas.common.base.dao.BaseDao;
import com.ecas.common.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author devon
 * @version V1.0
 * @Description: TODO
 * @date 18-1-31 上午12:49
 */
public class BaseServiceImpl<D extends BaseDao,T> implements BaseService<T> {

    @Autowired
    private D dao;

    @Override
    public void save(T t) {
       // dao.save(t);
    }

    @Override
    public void saveBatch(List<T> list) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void removeBatch(List<Long> idList) {

    }

    @Override
    public void removeByParam(T t) {

    }

    @Override
    public void modify(T t) {

    }

    @Override
    public void modifyBatch(List<T> list) {

    }

    @Override
    public T getById(Long id) {
        return null;
    }

    @Override
    public List<T> find(T t) {
        return null;
    }

    @Override
    public List<T> getByIds(List<Long> ids) {
        return null;
    }

    @Override
    public List<T> page(T t, Integer size, Integer offset) {
        return null;
    }

    @Override
    public Integer countParam(T t) {
        return null;
    }
}

package com.ecas.common.base.service.impl;



import com.ecas.common.base.dao.BaseDao;
import com.ecas.common.base.model.BaseEntiy;
import com.ecas.common.base.service.BaseService;

import java.util.List;

/**
 * @author devon
 * @version V1.0
 * @Description: TODO
 * @date 18-1-31 上午12:49
 */
public   class BaseServiceImpl<D extends BaseDao<T>,T> implements BaseService<T> {


    public D dao;

    @Override
    public void save(T t) {
       dao.inser(t);
    }

    @Override
    public void saveBatch(List<T> list) {
        dao.insertBatch(list);
    }

    @Override
    public void removeById(Long id) {
        dao.deleteById(id);
    }

    @Override
    public void removeBatch(List<Long> idList) {
       dao.deleteBatch(idList);
    }

    @Override
    public void removeByParam(T t) {
        dao.deleteByParam(t);
    }

    @Override
    public void modify(T t) {
        dao.update(t);
    }

    @Override
    public void modifyBatch(List<T> list) {
       dao.updateBatch(list);
    }

    @Override
    public T getById(Long id) {
        return dao.selectById(id);
    }

    @Override
    public List<T> find(T t) {
        return dao.selectList(t);
    }

    @Override
    public List<T> getByIds(List<Long> ids) {
        return dao.selectByIds(ids);
    }

    @Override
    public List<T> page(T t, Integer size, Integer offset) {
        return dao.selectPage(t,size,offset);
    }

    @Override
    public Integer countParam(T t) {
        return dao.countParam(t);
    }
}

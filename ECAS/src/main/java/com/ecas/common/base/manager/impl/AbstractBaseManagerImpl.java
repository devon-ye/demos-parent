package com.ecas.common.base.manager.impl;

import com.ecas.common.base.dao.BaseDao;
import com.ecas.common.base.manager.BaseManager;
import com.ecas.common.base.model.BaseEntiy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author devon
 * @version V1.0
 * @Description: 通用业务处理实现和第三方RPC接口调用实现
 * @date 2/3/18 11:13 PM
 */
public class AbstractBaseManagerImpl<D extends BaseDao<E>, E extends BaseEntiy,T> implements BaseManager<T> {

    @Autowired
    protected D dao;

    @Override
    public int save(T t) {
        BaseEntiy entiy = new BaseEntiy();
//        BaseEntiy ent = BeanUtils.
//        dao.inser(entiy);
    }

    @Override
    public int saveBatch(List<T> list) {

    }

    @Override
    public int removeById(Long id) {

    }

    @Override
    public int removeBatch(List<Long> idList) {

    }

    @Override
    public int removeByParam(T t) {

    }

    @Override
    public int modify(T t) {

    }

    @Override
    public int modifyBatch(List<T> list) {

    }

    @Override
    public T getById(Long id) {
        return null;
    }

    @Override
    public List<T> listByObject(T t) {
        return null;
    }

    @Override
    public List<T> listByIds(List<Long> ids) {
        return null;
    }

    @Override
    public List<T> listPage(T t, Integer size, Integer offset) {
        return null;
    }

    @Override
    public int countParam(T t) {
        return 0;
    }
}

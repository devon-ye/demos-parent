package com.ecas.common.base.service.impl;




import com.ecas.common.base.manager.BaseManager;
import com.ecas.common.base.service.BaseService;

import java.util.List;

/**
 * @author devon
 * @version V1.0
 * @Description: TODO
 * @date 18-1-31 上午12:49
 */
public  class BaseServiceImpl<M extends BaseManager<T>,T> implements BaseService<T> {


    public M manager;

    @Override
    public int save(T t) {
      return manager.save(t);
    }

    @Override
    public int saveBatch(List<T> list) {
        return manager.saveBatch(list);
    }

    @Override
    public int removeById(Long id) {
        return manager.removeById(id);
    }

    @Override
    public int removeBatch(List<Long> idList) {
        return manager.removeBatch(idList);
    }

    @Override
    public int removeByParam(T t) {
        return manager.removeByParam(t);
    }

    @Override
    public int modify(T t) {
        return manager.modify(t);
    }

    @Override
    public int modifyBatch(List<T> list) {
        return manager.modifyBatch(list);
    }

    @Override
    public T getById(Long id) {
        return manager.getById(id);
    }

    @Override
    public List<T> listByObject(T t) {
        return manager.listByObject(t);
    }

    @Override
    public List<T> listByIds(List<Long> ids) {
        return manager.listByIds(ids);
    }

    @Override
    public List<T> listPage(T t, Integer size, Integer offset) {
        return manager.listPage(t,size,offset);
    }

    @Override
    public int countParam(T t) {
        return manager.countParam(t);
    }
}

package com.ecas.common.base.manager.impl;

import com.ecas.common.base.dao.BaseDao;
import com.ecas.common.base.manager.BaseManager;
import com.ecas.common.base.model.BaseEntiy;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.swing.text.html.parser.Entity;
import java.util.List;

/**
 * @author devon
 * @version V1.0
 * @Description: 通用业务处理实现和第三方RPC接口调用实现
 * @date 2/3/18 11:13 PM
 */
public abstract  class AbstractBaseManagerImpl<D extends BaseDao<E>, E extends BaseEntiy,T> implements BaseManager<T> {

    @Autowired
    protected D dao;

    @Override
    public int save(T t) {
       E entiy = transferToEntity(t);
      return dao.inser(entiy);
    }

    @Override
    public int saveBatch(List<T> list) {
         return  dao.insertBatch(transferToEntiyList(list));
    }

    @Override
    public int removeById(Long id) {
         return dao.deleteById(id);
    }

    @Override
    public int removeBatch(List<Long> idList) {
        return dao.deleteBatch(idList);
    }

    @Override
    public int removeByParam(T t) {
            return dao.deleteByParam(transferToEntity(t));
    }

    @Override
    public int modify(T t) {
            return dao.update(transferToEntity(t));
    }

    @Override
    public int modifyBatch(List<T> list) {
            return dao.updateBatch(transferToEntiyList(list));
    }

    @Override
    public T getById(Long id) {
        E entiy = dao.selectById(id);
        return transferToDTO(entiy);
    }

    @Override
    public List<T> listByObject(T t) {
        return transferToDTOList(dao.selectList(transferToEntity(t)));
    }

    @Override
    public List<T> listByIds(List<Long> ids) {
        return transferToDTOList(dao.selectByIds(ids));
    }

    @Override
    public List<T> listPage(T t, Integer size, Integer offset) {
        return transferToDTOList(dao.selectPage(transferToEntity(t),size,offset));
    }

    @Override
    public int countParam(T t) {
        return dao.countParam(transferToEntity(t));
    }

    protected abstract E transferToEntity(T dto);
    protected abstract List<E> transferToEntiyList(List<T> dtoList);
    protected abstract T transferToDTO(E entiy);
    protected abstract List<T> transferToDTOList(List<E> entiyList);
}

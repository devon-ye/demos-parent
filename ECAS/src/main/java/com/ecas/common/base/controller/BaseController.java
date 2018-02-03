package com.ecas.common.base.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecas.common.base.service.BaseService;

import java.util.List;

/**
 * @author devon
 * @version V1.0
 * @Description: TODO
 * @date ${date} ${time}
 */
public class BaseController <S extends BaseService<T>,T> extends HttpController {

    @Autowired
    private S service;

    /**
     * 单条记录存储
     * @param t
     */
   protected void save(T t){
     service.save(t);
   }

    /**
     * 批量存储
     * @param list
     */
   protected void saveBatch(List<T> list){
       service.saveBatch(list);
   }

    /**
     * 根据ＩＤ删除
     * @param id
     */
   protected void removeById(Long id){
       service.removeById(id);
   }

    /**
     * 根据集合删除
     * @param idList
     */
   protected void removeBatch(List<Long> idList){
        service.removeBatch(idList);
   }

    /**
     * 根据参数删除
     * @param t
     */
   protected void removeByParam(T t){
        service.removeByParam(t);
   }

    /**
     *修改单条记录
     * @param t
     */
   protected void modify(T t){
     service.modify(t);
   }

    /**
     *批量修改记录
     * @param list
     */
   protected void modifyBatch(List<T> list){
        service.modifyBatch(list);
    }


    /**
     *根据Ｉｄ查询
     */
   protected T getById(Long id){
        return  service.getById(id);
    }

    /**
     *根据对象查询集合
     * @param t
     * @return
     */
   protected List<T>  listByObject(T t){
        return  service.listByObject(t);
   }

    /**
     *根据ＩＤ集合查询对象集合
     * @param ids
     * @return
     */
   protected List<T> listByIds(List<Long> ids){
        return  service.listByIds(ids);
   }

    /**
     *分页查询
     * @param t
     * @param size
     * @param offset
     * @return
     */
    protected List<T> listPage(T t, Integer size, Integer offset){
            return service.listPage(t,size,offset);
    }

    /**
     *根据参数统计
     * @param t
     * @return
     */
    protected Integer countParam(T t){
        return service.countParam(t);
    }



}

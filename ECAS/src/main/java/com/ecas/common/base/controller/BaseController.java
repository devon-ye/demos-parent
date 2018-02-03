package com.ecas.common.base.controller;

import org.springframework.beans.factory.annotation.Autowired;

import com.ecas.common.base.service.BaseService;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

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

   }

    /**
     * 根据ＩＤ删除
     * @param id
     */
   protected void removeById(Long id){

   }

    /**
     * 根据集合删除
     * @param idList
     */
   protected void removeBatch(List<Long> idList){

   }

    /**
     * 根据参数删除
     * @param t
     */
   protected void removeByParam(T t){

   }

    /**
     *修改单条记录
     * @param t
     */
   protected void modify(T t){

   }

    /**
     *批量修改记录
     * @param list
     */
   protected void modifyBatch(List<T> list){

    }


    /**
     *根据Ｉｄ查询
     */
   protected T getById(Long id){

    }

    /**
     *根据对象查询集合
     * @param t
     * @return
     */
   protected List<T>  listByObject(T t){

   }

    /**
     *根据ＩＤ集合查询对象集合
     * @param ids
     * @return
     */
   protected List<T> listByIds(List<Long> ids){

   }

    /**
     *分页查询
     * @param t
     * @param size
     * @param offset
     * @return
     */
    protected List<T> listPage(T t, Integer size, Integer offset){

    }

    /**
     *根据参数统计
     * @param t
     * @return
     */
    protected Integer countParam(T t){

    }



}

package com.ecas.common.base.controller;

import com.ecas.common.base.model.ModelResult;
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
     responseMessage(ModelResult.CODE_200,ModelResult.SUCCESS);
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
   protected void getById(Long id){
          service.getById(id);
    }

    /**
     *根据对象查询集合
     * @param t
     * @return
     */
   protected void   listByObject(T t){
         service.listByObject(t);
   }

    /**
     *根据ＩＤ集合查询对象集合
     * @param ids
     * @return
     */
   protected void listByIds(List<Long> ids){
          service.listByIds(ids);
   }

    /**
     *分页查询
     * @param t
     * @param size
     * @param offset
     * @return
     */
    protected void listPage(T t, Integer size, Integer offset){
             service.listPage(t,size,offset);
    }

    /**
     *根据参数统计
     * @param t
     * @return
     */
    protected void countParam(T t){
         service.countParam(t);
    }



}

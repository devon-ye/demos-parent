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
     int result = service.save(t);
     responseMessage(result == 1 ? ModelResult.CODE_200:ModelResult.CODE_500,result == 1?ModelResult.SUCCESS:ModelResult.FAIL);
   }

    /**
     * 批量存储
     * @param list
     */
   protected void saveBatch(List<T> list){
     int result =   service.saveBatch(list);
       responseMessage(result == 1 ? ModelResult.CODE_200:ModelResult.CODE_500,result == 1?ModelResult.SUCCESS:ModelResult.FAIL);

   }

    /**
     * 根据ＩＤ删除
     * @param id
     */
   protected void removeById(Long id){
       int result = service.removeById(id);
       responseMessage(result == 1 ? ModelResult.CODE_200:ModelResult.CODE_500,result == 1?ModelResult.SUCCESS:ModelResult.FAIL);

   }

    /**
     * 根据集合删除
     * @param idList
     */
   protected void removeBatch(List<Long> idList){
       int result = service.removeBatch(idList);
       responseMessage(result == 1 ? ModelResult.CODE_200:ModelResult.CODE_500,result == 1?ModelResult.SUCCESS:ModelResult.FAIL);

   }

    /**
     * 根据参数删除
     * @param t
     */
   protected void removeByParam(T t){
       int result =  service.removeByParam(t);
       responseMessage(result == 1 ? ModelResult.CODE_200:ModelResult.CODE_500,result == 1?ModelResult.SUCCESS:ModelResult.FAIL);

   }

    /**
     *修改单条记录
     * @param t
     */
   protected void modify(T t){
    int result=     service.modify(t);
       responseMessage(result == 1 ? ModelResult.CODE_200:ModelResult.CODE_500,result == 1?ModelResult.SUCCESS:ModelResult.FAIL);

   }

    /**
     *批量修改记录
     * @param list
     */
   protected void modifyBatch(List<T> list){
        int result = service.modifyBatch(list);
       responseMessage(result == 1 ? ModelResult.CODE_200:ModelResult.CODE_500,result == 1?ModelResult.SUCCESS:ModelResult.FAIL);
   }


    /**
     *根据Ｉｄ查询
     */
   protected void getById(Long id){
        T result =   service.getById(id);
       resonseEntiy(result);

   }

    /**
     *根据对象查询集合
     * @param t
     * @return
     */
   protected void   listByObject(T t){
        List<T> list = service.listByObject(t);
        resonseList(list);
   }

    /**
     *根据ＩＤ集合查询对象集合
     * @param ids
     * @return
     */
   protected void listByIds(List<Long> ids){
       List<T> list = service.listByIds(ids);
       resonseList(list);
   }

    /**
     *分页查询
     * @param t
     * @param size
     * @param offset
     * @return
     */
    protected void listPage(T t, Integer size, Integer offset){

        //TODO check size and offset
        List<T> list =    service.listPage(t,size,offset);
        resonseList(list);
    }

    /**
     *根据参数统计
     * @param t
     * @return
     */
    protected void countParam(T t){
        int count = service.countParam(t);
    }



}

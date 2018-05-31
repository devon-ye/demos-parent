package com.ecas.common.base.manager;

import java.util.List;

/**
 * @author devon
 * @version V1.0
 * @Description: 通用业务处理及第三方RPC接口的封装接口
 * @date 2/3/18 11:12 PM
 */
public interface BaseManager<T> {
    /**
     * 单条记录存储
     * @param t
     */
    int save(T t);

    /**
     * 批量存储
     * @param list
     */
    int saveBatch(List<T> list);

    /**
     * 根据ＩＤ删除
     * @param id
     */
    int removeById(Long id);

    /**
     * 根据集合删除
     * @param idList
     */
    int removeBatch(List<Long> idList);

    /**
     * 根据参数删除
     * @param t
     */
    int removeByParam(T t);

    /**
     *修改单条记录
     * @param t
     */
    int modify(T t);

    /**
     *批量修改记录
     * @param list
     */
    int modifyBatch(List<T> list);


    /**
     *根据Ｉｄ查询
     */
    T getById(Long id);

    /**
     *根据对象查询集合
     * @param t
     * @return
     */
    List<T> listByObject(T t);

    /**
     *根据ＩＤ集合查询对象集合
     * @param ids
     * @return
     */
    List<T> listByIds(List<Long> ids);

    /**
     *分页查询
     * @param t
     * @param size
     * @param offset
     * @return
     */
    List<T> listPage(T t, Integer size, Integer offset);

    /**
     *根据参数统计
     * @param t
     * @return
     */
    int countParam(T t);

}

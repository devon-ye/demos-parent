package com.ecas.common.base.dao;

import com.ecas.common.base.entiy.BaseEntiy;

import java.util.List;

/**
 * @author devon
 * @version V1.0
 * @Description: TODO
 * @date 18-1-31 上午12:57
 */
public interface BaseDao <E extends BaseEntiy> {
    /**
     * 单条记录存储
     * @param entiy
     */
    int inser(E entiy);

    /**
     * 批量存储
     * @param list
     */
    int insertBatch(List<E> list);

    /**
     * 根据ＩＤ删除
     * @param id
     */
    int deleteById(Long id);

    /**
     * 根据集合删除
     * @param idList
     */
    int deleteBatch(List<Long> idList);

    /**
     * 根据参数删除
     * @param entiy
     */
    int deleteByParam(E entiy);

    /**
     *修改单条记录
     * @param entiy
     */
    int update(E entiy);

    /**
     *批量修改记录
     * @param list
     */
    int updateBatch(List<E> list);


    /**
     *根据Ｉｄ查询
     */
    E selectById(Long id);

    /**
     *根据对象查询集合
     * @param entiy
     * @return
     */
    List<E> selectList(E entiy);

    /**
     *根据ＩＤ集合查询对象集合
     * @param ids
     * @return
     */
    List<E> selectByIds(List<Long> ids);

    /**
     *分页查询
     * @param entiy
     * @param size
     * @param offset
     * @return
     */
    List<E> selectPage(E entiy, Integer size, Integer offset);

    /**
     *根据参数
     * @param entiy
     * @return
     */
    int countParam(E entiy);
}

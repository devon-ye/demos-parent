package com.ecas.common.base.dao.impl;

import com.ecas.common.base.dao.BaseDao;
import com.ecas.common.base.model.BaseEntiy;

import java.util.List;

/**
 * @author devon
 * @version V1.0
 * @Description: TODO
 * @date 18-1-31 上午12:57
 */
public class BaseDaoImpl implements BaseDao {
    @Override
    public void save(BaseEntiy baseEntiy) {

    }

    @Override
    public void saveBatch(List list) {

    }

    @Override
    public void removeById(Long id) {

    }

    @Override
    public void removeByParam(BaseEntiy baseEntiy) {

    }

    @Override
    public void modify(BaseEntiy baseEntiy) {

    }

    @Override
    public void modifyBatch(List list) {

    }

    @Override
    public BaseEntiy getById(Long id) {
        return null;
    }

    @Override
    public List find(BaseEntiy baseEntiy) {
        return null;
    }

    @Override
    public List page(BaseEntiy baseEntiy, Integer size, Integer offset) {
        return null;
    }

    @Override
    public Integer countParam(BaseEntiy baseEntiy) {
        return null;
    }

    @Override
    public List getByIds(List ids) {
        return null;
    }

    @Override
    public void removeBatch(List idList) {

    }
}

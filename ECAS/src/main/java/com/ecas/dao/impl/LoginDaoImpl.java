package com.ecas.dao.impl;

import com.ecas.dao.LoginDao;
import com.ecas.model.Login;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by lenovo on 2017/12/14.
 */
@Repository
public class LoginDaoImpl implements LoginDao {
    private static Logger logger = LoggerFactory.getLogger(LoginDaoImpl.class);
    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    public LoginDaoImpl() {
    }

    public LoginDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }


    @Override
    public Login selectUserByID(long loginId) {
        SqlSession sqlSession = sqlSessionFactory.openSession();

        Login login = null;
        try {
            LoginDao loginDao =  sqlSession.getMapper(LoginDao.class);
            if(loginDao == null) {
                logger.error("selectUserByID, loginId is null!");
                return login;
            }
             login = loginDao.selectUserByID(loginId);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(sqlSession != null) {
                sqlSession.close();
            }
        }

        return login;
    }

    public SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }

    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }
}

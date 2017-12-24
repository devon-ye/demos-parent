package com.mybatis.demo.dao.impl;

import com.mybatis.demo.dao.IUserDao;
import com.mybatis.demo.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.*;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by lenovo on 2017/12/14.
 */
public class UserDaoImplTest {
    private IUserDao userDao;
    private static SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    @BeforeClass
    public static void beforeClass(){
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Before
    public void before() {
        sqlSession = sqlSessionFactory.openSession();
    }

    @Test
    public void testGetUserById() {
       IUserDao iUserDao = sqlSession.getMapper(IUserDao.class);
       User user = iUserDao.getUserById(1);

    }

    @After
    public void tearDown() {
        sqlSession.close();
    }

    @AfterClass
    public static void afterClass() {

    }

}

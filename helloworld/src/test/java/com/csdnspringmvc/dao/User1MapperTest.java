package com.csdnspringmvc.dao;

import com.csdnspringmvc.entity.User1;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by toutou on 2018/2/16.
 */
public class User1MapperTest {
    @Autowired
    private User1Mapper userMapper;

    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");//加载spring配置文件
        userMapper = applicationContext.getBean(User1Mapper.class);//在这里导入要测试的
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getCount() throws Exception {
        System.out.println(userMapper.getCount());
    }

    @Test
    public void selectSelective() throws Exception {
        User1 user=new User1();
        ArrayList<User1> list =  userMapper.selectSelective(user);
        for(User1 item:list){
            System.out.println(item);
        }
    }

    @Test
    public void countByExample() throws Exception {
    }

    @Test
    public void deleteByExample() throws Exception {
    }

    @Test
    public void deleteByPrimaryKey() throws Exception {
    }

    @Test
    public void insert() throws Exception {
    }

    @Test
    public void insertSelective() throws Exception {
    }

    @Test
    public void selectByExample() throws Exception {
    }

    @Test
    public void selectByPrimaryKey() throws Exception {
    }

    @Test
    public void updateByExampleSelective() throws Exception {
    }

    @Test
    public void updateByExample() throws Exception {
    }

    @Test
    public void updateByPrimaryKeySelective() throws Exception {
    }

    @Test
    public void updateByPrimaryKey() throws Exception {
    }
}
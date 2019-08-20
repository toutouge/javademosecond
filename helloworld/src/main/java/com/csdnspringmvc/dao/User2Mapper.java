package com.csdnspringmvc.dao;

import com.csdnspringmvc.entity.User2;
import com.csdnspringmvc.entity.User2Example;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface User2Mapper {
    int countByExample(User2Example example);

    int deleteByExample(User2Example example);

    int deleteByPrimaryKey(Integer id);

    int insert(User2 record);

    int insertSelective(User2 record);

    List<User2> selectByExample(User2Example example);

    User2 selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User2 record, @Param("example") User2Example example);

    int updateByExample(@Param("record") User2 record, @Param("example") User2Example example);

    int updateByPrimaryKeySelective(User2 record);

    int updateByPrimaryKey(User2 record);

    ArrayList<User2> selectSelective(User2 record);
}
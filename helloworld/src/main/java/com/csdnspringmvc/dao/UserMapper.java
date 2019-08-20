package com.csdnspringmvc.dao;

import com.csdnspringmvc.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);
}
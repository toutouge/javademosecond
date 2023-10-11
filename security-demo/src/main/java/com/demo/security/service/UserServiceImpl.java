package com.demo.security.service;

import com.demo.security.model.po.UserPo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author chen bo
 * @Date 2023/12
 * @Des
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Override
    public UserPo getUserByUserName(String userName){
        List<UserPo> userPoList = userPoList();
        if(CollectionUtils.isEmpty(userPoList)){
            return null;
        }

        return userPoList.stream().filter(item -> userName.equals(item.getUserName())).findAny().orElse(null);
    }

    /**
     * 正常这一步应该是在DB或者redis中查询的，这里为了简化demo流程，直接在内存中写入固定用户集合
     * @return
     */
    private List<UserPo> userPoList(){
        List<UserPo> userPoList = new ArrayList<>();
        UserPo userPo = new UserPo();
        userPo.setUserName("zhangsan");
        userPo.setPwd("zs123456");
        userPoList.add(userPo);
        userPo = new UserPo();
        userPo.setUserName("lisi");
        userPo.setPwd("ls123456");
        userPoList.add(userPo);
        userPo = new UserPo();
        userPo.setUserName("wangwu");
        userPo.setPwd("ww123456");
        userPoList.add(userPo);
        return userPoList;
    }
}

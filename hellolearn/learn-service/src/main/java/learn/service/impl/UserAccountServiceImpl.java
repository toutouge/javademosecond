package learn.service.impl;

import learn.model.po.UserAccount;
import learn.model.vo.UserAccountVO;
import learn.persist.UserAccountMapper;
import learn.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author toutou
 * @date by 2019/07
 */
@Service
public class UserAccountServiceImpl implements UserAccountService{
    @Autowired
    UserAccountMapper userMapper;

    public UserAccountVO getUserAccountById(Integer id){
        UserAccountVO accountVO = null;
        UserAccount account = userMapper.selectByPrimaryKey(id);
        if (account != null) {
            accountVO = new UserAccountVO();
            accountVO.setId(account.getId());
            accountVO.setAccount(account.getAccount());
            accountVO.setAge(account.getAge());
            accountVO.setEmail(account.getEmail());
            accountVO.setUsername(account.getUsername());
            accountVO.setPhone(account.getPhone());
        }

        return accountVO;
    }
}

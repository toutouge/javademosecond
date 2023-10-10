package com.demo.security.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

/**
 * @Author chen bo
 * @Date 2023/12
 * @Des
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLogin implements UserDetails {
    private String username;
    private String password;

    /**
     * 获取用户包含的权限，返回权限集合，权限是一个继承了GrantedAuthority的对象；
     * @return
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities(){
        return AuthorityUtils.commaSeparatedStringToAuthorityList("admin");
    }

    /**
     * 判断账户是否未过期，未过期返回true反之返回false
     * @return
     */
    @Override
    public boolean isAccountNonExpired(){
        return true;
    }

    /**
     * 判断账户是否未锁定
     * @return
     */
    @Override
    public boolean isAccountNonLocked(){
        return true;
    }

    /**
     * 判断用户凭证是否没过期，即密码是否未过期
     * @return
     */
    @Override
    public boolean isCredentialsNonExpired(){
        return true;
    }

    /**
     * 判断用户是否可用
     * @return
     */
    @Override
    public boolean isEnabled(){
        return true;
    }
}

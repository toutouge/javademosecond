package learn.model.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import learn.annotation.Sensitivity;
import learn.model.enums.SensitivityEnum;

/**
 * @author toutou
 * @date by 2019/07
 */
public class UserAccountVO {
    private Integer id;

    @Sensitivity(strategy = SensitivityEnum.USERNAME)
    private String username;

    private Integer age;

    @Sensitivity(strategy = SensitivityEnum.PHONE)
    private String tel;

    @JsonIgnore
    private Long phone;

    private String email;

    private String account;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getPhone() {
        return phone;
    }

    public void setPhone(Long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getTel() {
        return String.valueOf(getPhone());
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
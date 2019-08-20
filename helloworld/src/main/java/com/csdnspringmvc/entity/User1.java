package com.csdnspringmvc.entity;

import java.util.Date;

public class User1 {
    private Integer id;

    private String name;

    private Boolean sex;

    private Date createtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Date getCreatetime() {
        return createtime;
    }

    @Override
    public String toString() {
        return "User1{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", createtime=" + createtime +
                '}';
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }
}
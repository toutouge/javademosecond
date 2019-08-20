package com.mq.hellomq.Model;

import java.util.UUID;

/**
 * Created by toutou on 2018/12/15.
 */
public class MyModels {
    private UUID id;
    private String info;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}

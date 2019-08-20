package com.demo.mq.model;

import java.io.Serializable;
import java.util.UUID;

/**
 * Created by toutou on 2018/12/15.
 */
public class MyModel implements Serializable {
    private static final long serialVersionUID = 1L;
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

package com.toutou.sample.other;

/**
 * @author toutou
 * @date by 2020/06
 * @des
 */
public  abstract class People {
    private String name;

    public void outPutName(){
        System.out.println(this.name);
    }

    public abstract  void outName();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

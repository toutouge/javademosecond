package com.toutou.sample.other;

/**
 * @author toutou
 * @date by 2020/06
 * @des
 */
public class Employee2 extends People{
    private int id;

    public Employee2(int id){
        super.setName("2");
        this.id = id;
    }

    public void outPutId(){
        System.out.println(this.id);
    }

    public void outName(){
        System.out.println(super.getName());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

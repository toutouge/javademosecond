package com.toutou.sample.other;

/**
 * @author toutou
 * @date by 2020/06
 * @des
 */
public class Employee1 extends People{
    private int id1;

    public Employee1(int id1){
        super.setName("1");
        this.id1 = id1;
    }

    public void outName(){
        System.out.println(super.getName());
    }

    public void outPutId1(){
        System.out.println(this.id1);
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }
}

package oom;

import java.util.ArrayList;
class AAA{
    public void eee(){
        this.eee();
    }
}
public class InnOut {
    public static void main(String[] args) throws InterruptedException {
        AAA aaa=new AAA();
        aaa.eee();
    }
}

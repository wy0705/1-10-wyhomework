package homework;

import java.util.ArrayList;
import java.util.TreeMap;

class MyThread implements Runnable{
    int n=1;//下发的第ｎ条作业
    boolean iswork=false;//false表示老师是否布置作业，ture表示老师下发了作业
    //学生接受作业后iswork变为false,否则为ture

    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public MyThread(ArrayList<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            if (iswork)
                read();
            else
                work();

        }

    }
    private synchronized void work(){
        if (n<5) {
            System.out.println("老师下发了第" + n + "项作业");
            iswork = true;
        }else {
            System.out.println("作业太多了，老师不能布置了");
            return;
        }
    }
    private synchronized void read(){
        System.out.println("学生收到了第"+n+"项作业");
        arrayList.add(n);
        n++;
        iswork=false;
    }
}
public class HomeWork {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        MyThread myThread=new MyThread(arrayList);

        new Thread(myThread).start();
        new Thread(myThread).start();

        Parents parents=new Parents(arrayList);
        parents.calculation();
    }
}

interface CallBackInterface{
    public void calculationResult(ArrayList<Integer> arrayList);
}
class Logic{
    public void calculationLogic(ArrayList<Integer> arrayList,CallBackInterface callBackInterface){
        //ArrayList<Integer> arrayList1=arrayList;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        callBackInterface.calculationResult(arrayList);
    }
}

class Parents implements CallBackInterface{
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public Parents(ArrayList<Integer> arrayList){
        this.arrayList=arrayList;
    }
    public void calculation(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                new Logic().calculationLogic(arrayList,Parents.this);
            }
        }).start();
    }
    @Override
    public void calculationResult(ArrayList<Integer> arrayList) {
        for (int a:arrayList){
            System.out.println("家长知道了第"+a+"项作业");
        }
    }
}
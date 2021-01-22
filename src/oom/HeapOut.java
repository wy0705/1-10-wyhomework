package oom;

import java.util.ArrayList;
import java.util.List;

public class HeapOut {
    public static void main(String[] args) throws InterruptedException {
        int size=1024*1024*8;
        List<byte[]> list=new ArrayList<byte[]>();
        while(true) {
            Thread.sleep(1);
            list.add(new byte[size]);
        }
    }
}

package target;

import java.util.Scanner;

public class Target {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6};
        Scanner scanner=new Scanner(System.in);
        System.out.println("输入小于36的数");
        int target=scanner.nextInt();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (nums[i]+nums[j]==target){
                    System.out.println(i+"\t"+j);
                }
            }
        }
    }
}

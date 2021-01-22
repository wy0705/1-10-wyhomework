package repetition;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Repetition {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("数组长度为：");
        int n=scanner.nextInt();
        ArrayList<Integer> nums=new ArrayList<Integer>();
        Random random=new Random();
        for (int i = 0; i < n; i++) {
            nums.add(random.nextInt(n));
        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums.get(i)+"\t");
        }
        System.out.println();
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums.get(i)==nums.get(j)){
                    System.out.println(nums.get(i));
                    return;
                }

            }
        }
    }
}

package multiplicationTable;

public class Table {
    public static void main(String[] args) {
        //int i=1;
        for (int i=1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i+"*"+j+"="+(i*j)+"\t");
            }
            System.out.println("\n");
        }
    }
}

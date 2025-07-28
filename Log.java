import java.util.*;

public class Log {
    public static void main(String[] args) {
        System.out.println(" enter a and b for sum");
        
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b=sc.nextInt();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print('*');
                
            }
            System.out.println("");
        }

    }
}
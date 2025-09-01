public class sumofn {
    public static void allSum(int i,int n,int sum) {
        if (i == n) {
            System.out.println(sum);
            return;
        }
        i+=1;
        sum+=i;
        allSum(i, n, sum);
        
    }
    public static int factorial(int n) {
        if(n==0||n==1){
            return 1;

        }
        int fact_num = factorial(n-1);
        int res = n *fact_num;
        return res;
    }
    public static void fib (int a,int b,int n) {
        if (n==0) {
            return;
            
        }
        int c = a+b;
        System.out.println(c);
        
        fib(b, c, n-1);
        
    }
    public static void main(String[] args) {
        int a = 0;
        int b = 1;
        int n = 7;
        System.out.println(a+"\n"+b);
        fib(a, b, n-2);
    }
    
}

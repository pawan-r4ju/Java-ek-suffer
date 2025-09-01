public class power {

    public static int powercal(int x, int n) {

        if (x == 0) {
            return 0;

        }
        if (n == 0) {
            return 1;

        }
       int pow1 = powercal(x, n-1);
       int pown = x * pow1;
        return pown;

    }

    public static void main(String[] args) {
        int res = powercal(2, 5);
        System.out.println(res);
    }
}
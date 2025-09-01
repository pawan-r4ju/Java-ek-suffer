public class tower {
    public static void toh(int n, String src,String dest,String temp){
        if(n==1){
            System.out.println("move "+n+" from "+src+" to "+dest);
            return;
        }
        toh(n-1, src, temp, dest);
        System.out.println("move "+n+" from "+src+" to "+dest);
        toh(n-1, temp, dest, src);
    }
    public static void main(String[] args) {
        toh(3, "S", "D", "T");
    }
}

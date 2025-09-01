public class reverse {
    // public static void reverseS(String str,int idx){
    // if (idx <0){

    // return;
    // }
    // System.out.print(str.charAt(idx));
    // reverseS(str,idx-1);

    // }

    // public static void count(String str, int idx, int first, int last, char acc)
    // {
    // if (idx == str.length()) {
    // System.out.println(first + "and" + last);
    // return;
    // }
    // if (str.charAt(idx) == acc && first == -1) {
    // first = idx;

    // } else if (str.charAt(idx) == acc) {
    // last = idx;
    // }
    // count(str, idx + 1, first, last, acc);

    // }
    // public static boolean check(int arr[],int i,int length) {
    // if (i==length) {
    // return true;
    // }

    // if(arr[i]>= arr[i+1]){
    // return false;
    // }
    // return check(arr, i+1,length);

    // }
    // public static void placeToLast(String str, int idx, int count, String result, char find) {
    //     if (idx == str.length()) {
    //         for (int i = 0; i < count; i++) {
    //             result = result + find;

    //         }
    //         System.out.println(result);
    //         return;
    //     }
    //     if (str.charAt(idx) != find) {
    //         result = result + str.charAt(idx);
    //     } else {
    //         count++;

    //     }
    //     placeToLast(str, idx + 1, count, result, find);

    // }
    // public static void removeDuplicates(String str,int idx,boolean map[],String result) {
    //     if (idx==str.length()) {
    //         System.out.println(result);
    //         return;
            
    //     }
    //     if(map[str.charAt(idx)-'a']==false){
    //         map[str.charAt(idx)-'a']=true;
    //         result=result+str.charAt(idx);
    //     }
    //     removeDuplicates(str, idx+1, map, result);
        
    // }
    // public static void subsequence(String str,int idx,String resulString) {
    //     if(idx==str.length()){
    //         System.out.println(resulString);
    //         return;
    //     }
    //     char currChar = str.charAt((idx));
    //     subsequence(str, idx+1, resulString+currChar);
    //     subsequence(str, idx+1, resulString);
    // }
    // public static void cobinations(String str,int idx,String[] keypad,String result) {
    //     if (idx==str.length()) {
    //         System.out.println(result);
    //         return;
    //     }
    //     char currChar = str.charAt(idx);
    //     String mapping = keypad[currChar-'0'];
    //     for (int i = 0; i < mapping.length(); i++) {
    //         cobinations(str, idx+1, keypad, result+mapping.charAt((i)));
            
    //     }

        
    // }
    public static void permutationString(String str,String combination) {
        if (str.length()==0) {
            System.out.println(combination);
            return;
            
        }
        for (int i = 0; i < str.length(); i++) {
            char currChar = str.charAt(i);
            String slice = str.substring(0, i)+str.substring(i+1);
            permutationString(slice, combination+currChar);
            
        }
        
    }

    public static void main(String[] args) {
        String str = "abc";
        // reverseS(str,str.length()-1);+
        // count(str, 0, -1, -1, 'a');
        // int arr[]={1,2,3,4,4,5};
        // boolean c= check(arr, 0, arr.length-1);
        // placeToLast(str, 0, 0, "", 'x');
        //  boolean[] map=new boolean[25];
        // removeDuplicates(str, 0,map, "");
        // subsequence(str, 0, "");
        // String[] keypad = {".","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        // cobinations(str, 0, keypad, "");
        permutationString(str, "");

    }

}
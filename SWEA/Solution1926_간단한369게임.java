import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
         
        int num = sc.nextInt();
        boolean flag = false;
        for (int i = 1; i <= num; i++) {
             
            String str = String.valueOf(i);
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '3' || str.charAt(j) == '6' || str.charAt(j) == '9') {
                    sb.append("-");
                    flag = true;
                }
            }
            if (!flag) {
                sb.append(i);
            }
            sb.append(" ");
            flag = false;
             
        }
         
        System.out.println(sb.toString());
    }
}
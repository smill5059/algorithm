import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
         
            String s = sc.next();
            char cur = '0';
            int cnt = 0;
             
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != cur) {
                    if (cur == '0')
                        cur = '1';
                    else if (cur == '1')
                        cur = '0';
                    cnt++;
                }
            }
             
            System.out.println("#" + test_case + " " + cnt);
 
        }
    }
}
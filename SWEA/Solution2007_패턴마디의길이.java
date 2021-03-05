import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        int tc = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= tc; test_case++) {
            String str = in.readLine();
             
            int j = 0;
            for (int i = 1; i < str.length(); i++) {
                if (str.charAt(i) == str.charAt(j)) {
                    ++j;
                } else {
                    j = 0;
                }
            }
             
            System.out.println("#" + test_case + " " + (str.length()-j));
        }
         
    }
}
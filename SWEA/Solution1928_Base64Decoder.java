import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
                 
        int tc = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= tc; test_case++) {
             
            String str = in.readLine();
            String after = new String(Base64.getDecoder().decode(str));
            sb.append("#");
            sb.append(test_case);
            sb.append(" ");
            sb.append(after);
            sb.append("\n");
             
        }
         
        System.out.println(sb.toString());
    }
}
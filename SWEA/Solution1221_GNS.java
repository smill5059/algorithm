import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws Exception {
//      System.setIn(new FileInputStream("res/input_swea_1221.txt"));
         
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            in.readLine();
            StringTokenizer st = new StringTokenizer(in.readLine(), " ");
            int cnt = st.countTokens();
            int[] numbers = new int[cnt];
            for (int i = 0; i < cnt; i++) {
                String temp = st.nextToken();
                int number = -1;
                if ("ZRO".equals(temp)) number = 0;
                else if ("ONE".equals(temp)) number = 1;
                else if ("TWO".equals(temp)) number = 2;
                else if ("THR".equals(temp)) number = 3;
                else if ("FOR".equals(temp)) number = 4;
                else if ("FIV".equals(temp)) number = 5;
                else if ("SIX".equals(temp)) number = 6;
                else if ("SVN".equals(temp)) number = 7;
                else if ("EGT".equals(temp)) number = 8;
                else if ("NIN".equals(temp)) number = 9;
                numbers[i] = number;
            }
             
            Arrays.sort(numbers);
            String[] planet = {"ZRO", "ONE", "TWO", "THR", "FOR", "FIV", "SIX", "SVN", "EGT", "NIN"};
            sb.append("#").append(tc).append("\n");
            for (int i = 0; i < cnt; i++) {
                sb.append(planet[numbers[i]]).append(" ");
            }
            sb.append("\n");
             
        }
         
        System.out.print(sb.toString());
        in.close();
    }
}
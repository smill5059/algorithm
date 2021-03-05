import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        for (int tc = 1; tc <= 10; tc++) {
             
            StringTokenizer st = new StringTokenizer(in.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            char[] pwd = st.nextToken().toCharArray();
             
            for (int i = 0; i < cnt; i++) {
                if (i+1 < cnt && pwd[i] == pwd[i+1]) {
                    int j = 0, k = 0;
                    while (true) {
                        while (i-j > 0 && pwd[i-j] == ' ') j++;
                        if (i-j < 0 || i+1+k >= cnt) break;
                        if (pwd[i-j] != pwd[i+1+k]) break;
                        pwd[i-j] = ' ';
                        pwd[i+1+k] = ' ';
                        j++;
                        k++;
                    }
                }
            }
             
            StringBuilder real = new StringBuilder();
            for (int i = 0; i < cnt; i++) {
                if (pwd[i] == ' ') continue;
                real.append(pwd[i]);
            }
             
            sb.append("#").append(tc).append(" ").append(real.toString()).append("\n");
             
        }
         
        System.out.print(sb.toString());
    }
}
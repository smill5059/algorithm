import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
         
        int T = Integer.parseInt(in.readLine());
        for (int tc = 1; tc <= T; tc++) {
             
            StringTokenizer st = new StringTokenizer(in.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
             
            String temp = "";
            for (int i = 0; i < N; i++) {
                String str = in.readLine();
                if (!temp.equals("")) continue;
                for (int j = M-1; j > 0; j--) {
                    if (str.charAt(j) == '1') {
                        temp = str.substring(j-55, j+1);
                        break;
                    }
                }
            }
             
            /*코드파악*/
            int[][] code = new int[8][4];
            char status = '0';
            int cnt = 0, j = 0;
            for (int i = 0; i < 56; i++) {
                char cur = temp.charAt(i);
                if (cur != status) {
                    code[(i-1)/7][j%4] = cnt;
                    j++;
                    cnt = 0;
                    status = cur;
                }
                cnt++;
            }
            code[7][3] = cnt;
             
            /*암호화*/
            int[] pwd = new int[8];
            for (int i = 0; i < 8; i++) {
                if (code[i][0] == 1) {
                    if (code[i][1] == 1) {
                        if (code[i][2] == 1) {
                            pwd[i] = 6; //1 1 1
                        }else if (code[i][2] == 3) {
                            pwd[i] = 4; //1 1 3
                        }
                    }else if (code[i][1] == 2) {
                        if (code[i][2] == 1) {
                            pwd[i] = 8; //1 2 1
                        }else if (code[i][2] == 3) {
                            pwd[i] = 5; //1 2 3
                        }
                    }else if (code[i][1] == 3) {
                        pwd[i] = 7; //1 3
                    }else if (code[i][1] == 4) {
                        pwd[i] = 3; //1 4
                    }
                }else if (code[i][0] == 2) {
                    if (code[i][1] == 1) {
                        pwd[i] = 2; //2 1
                    }else if (code[i][1] == 2) {
                        pwd[i] = 1; //2 2
                    }
                }else if (code[i][0] == 3) {
                    if (code[i][1] == 1) {
                        pwd[i] = 9; //3 1
                    }else if (code[i][1] == 2) {
                        pwd[i] = 0; //3 2
                    }
                }
            }
             
            /*암호 검정*/
            int esum = 0, osum = 0, total = 0;
            for (int i = 0; i < 7; i++) {
                if (i%2 == 0) osum += pwd[i];
                else esum += pwd[i];
                total += pwd[i];
            }
            int check = osum*3 + esum + pwd[7];
            total += pwd[7];
             
            sb.append("#").append(tc).append(" ").append(check%10==0?total:0).append("\n");
             
        }
         
        System.out.print(sb.toString());
    }
}
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
         
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(in.readLine());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(in.readLine());
            String[] deck = new String[N];
            String card = in.readLine();
            StringTokenizer st = new StringTokenizer(card);
             
            for (int i = 0; i < Math.round(N/2.0); i++) {
                deck[i*2] = st.nextToken();
            }
            for (int i = 0; i < N-Math.round(N/2.0); i++) {
                deck[i*2 + 1] = st.nextToken();
            }
             
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < N; i++) {
                System.out.print(deck[i] + " ");
            }
            System.out.println();
        }
    }
}
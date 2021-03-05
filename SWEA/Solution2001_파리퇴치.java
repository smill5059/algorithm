import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    static int N, M;
    static int[][] fly;
     
    public static void main(String args[]) throws Exception
    {
         
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
         
            N = sc.nextInt();
            fly = new int[N][N];
            M = sc.nextInt();
             
            /*입력*/
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    fly[i][j] = sc.nextInt();
                }
            }
             
            int max = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (howManyFly(i, j, M) > max)
                        max = howManyFly(i, j, M);
                }
            }
             
            System.out.println("#" + test_case + " " + max);
 
        }
    }
     
    private static int howManyFly(int x, int y, int m) {
         
        int sum = 0;
        for (int i = x; i < x+m; i++) {
            if (i >= N) break;
            for (int j = y; j < y+m; j++) {
                if (j >= N) break;
                sum += fly[i][j];
            }
        }
         
        return sum;
    }
     
}
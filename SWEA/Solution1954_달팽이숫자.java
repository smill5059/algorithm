import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
         
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
         
            int n = sc.nextInt();
            int[][] snail = new int[n][n];
             
            int dir = 0;
            int x = -1, y = 0;
            int num = 1;
            for (int i = 0; i < (2*n)-1; i++) {
                dir = i % 4; //0:우, 1:하, 2:좌, 3:상
                 
                y = y + dy[dir];
                x = x + dx[dir];
                 
                while (x>=0 && x<n && y>=0 && y<n && snail[y][x]==0) {
                    snail[y][x] = num++;
                    y = y + dy[dir];
                    x = x + dx[dir];
                }
                y = y - dy[dir];
                x = x - dx[dir];
            }
             
            System.out.println("#" + test_case);
            for (int i = 0; i < snail.length; i++) {
                for (int j = 0; j < snail.length; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
 
        }
    }
}
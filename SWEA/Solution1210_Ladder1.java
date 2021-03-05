import java.util.Scanner;
import java.io.FileInputStream;
 
class Solution
{
    static int[][] ladder = new int[100][100];
     
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
         
        for(int test_case = 1; test_case <= 10; test_case++)
        {
         
            sc.nextInt();
             
            //테스트케이스 입력
            for (int i = 0; i < ladder.length; i++) {
                for (int j = 0; j < ladder.length; j++) {
                    ladder[i][j] = sc.nextInt();
                }
            }
             
             
            int index = 0;
            for (int i = 0; i < ladder.length; i++) {
                if (ladder[99][i] == 2)
                {
                    index = i;
                    break;
                }
            }
             
            int curY = 99, curX = index;
            int curDir = 0;
            int[] dy = {-1, 0, 0}; //상, 좌, 우
            int[] dx = {0, -1, 1};
            boolean flag = true;
             
            while (flag) {
                curX = curX + dx[curDir];
                curY = curY + dy[curDir];
                 
                curDir = checkLadder(curY, curX, curDir);
                 
                if (curY == 0)
                    flag = false;
            }
             
            System.out.println("#" + test_case + " " + curX);
 
        }
    }
     
    private static int checkLadder(int y, int x, int dir) {     
        switch (dir) {
        case 0:
            if (x>=1 && ladder[y][x-1]==1)
                dir = 1;
            else if (x<99 && ladder[y][x+1]==1)
                dir = 2;
            break;
        case 1:
            if (y>=1 && ladder[y-1][x]==1)
                dir = 0;
            break;
        case 2:
            if (y>=1 && ladder[y-1][x]==1)
                dir = 0;
            break;
        default:
            break;
        }
        return dir;
    }
}
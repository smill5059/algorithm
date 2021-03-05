import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
class Solution
{
    static int[][] room;
    static int N;
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
             
            N = Integer.parseInt(in.readLine());
            room = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = in.readLine();
                StringTokenizer st = new StringTokenizer(str);
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
                     
            int max = 0, maxRoomNumber = 0;
            int howMany = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    howMany = seekRoom(i, j);
                    if (howMany == max && room[i][j] < maxRoomNumber) {
                        maxRoomNumber = room[i][j];
                    } else if (howMany > max) {
                        max = howMany;
                        maxRoomNumber = room[i][j];
                    }
                }
            }
             
            System.out.println("#" + test_case + " " + maxRoomNumber + " " + (max + 1));
             
        }
    }
     
    private static int seekRoom(int X, int Y) {
        //상, 하, 좌, 우
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
         
        int cnt = 0;
        for (int i = 0; i < 4; i++) {
            int newX = X + dx[i];
            int newY = Y + dy[i];
            if (newX>=0 && newX<N && newY>=0 && newY<N
                    && room[newX][newY] == room[X][Y] + 1) {
                cnt = seekRoom(newX, newY) + 1;
            }
        }
         
        return cnt;
    }
     
}
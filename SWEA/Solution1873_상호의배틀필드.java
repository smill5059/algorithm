import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.io.FileInputStream;
 
class Solution
{
    static int H, W;
     
    static int curDir, curX, curY;
    static char[][] field;
     
    static int[] dy = {-1, 1, 0, 0}; //상, 하, 좌, 우
    static int[] dx = {0, 0, -1, 1};
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         
        int tc = Integer.parseInt(in.readLine());
        for (int test_case = 1; test_case <= tc; test_case++) {
            StringTokenizer temp = new StringTokenizer(in.readLine());
            H = Integer.parseInt(temp.nextToken());
            W = Integer.parseInt(temp.nextToken());
             
            field = new char[H][W];
             
            for (int i = 0; i < H; i++) {
                String tempmsg = in.readLine();
                field[i] = tempmsg.toCharArray();
            }
             
            int N = Integer.parseInt(in.readLine());
            String msg = in.readLine();
            char[] playerinput = msg.toCharArray();
            char[] car = {'^', 'v', '<', '>'};
            /*전차찾기*/
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    switch (field[i][j]) {
                    case '^':
                        curY = i;
                        curX = j;
                        curDir = 0;
                        break;
                    case 'v':
                        curY = i;
                        curX = j;
                        curDir = 1;
                        break;
                    case '<':
                        curY = i;
                        curX = j;
                        curDir = 2;
                        break;
                    case '>':
                        curY = i;
                        curX = j;
                        curDir = 3;
                        break;
                    default:
                        break;
                    }
                }
            }
            field[curY][curX] = '.';
             
            for (int i = 0; i < N; i++) {
                switch (playerinput[i]) {
                case 'U':
                    move(0);
                    break;
                case 'D':
                    move(1);
                    break;
                case 'L':
                    move(2);
                    break;
                case 'R':
                    move(3);
                    break;
                case 'S':
                    shoot();
                    break;
                default:
                    break;
                }
                 
            }
            field[curY][curX] = car[curDir];
             
            System.out.print("#" + test_case + " ");
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
             
        }
    }
     
    private static void shoot() {
        int tempX = curX+dx[curDir], tempY = curY+dy[curDir];
         
        while (tempY>=0 && tempY<H && tempX>=0 && tempX<W) {
            if (field[tempY][tempX] == '*') {
                field[tempY][tempX] = '.';
                return;
            }else if (field[tempY][tempX] == '#') {
                return;
            }
            tempX = tempX + dx[curDir];
            tempY = tempY + dy[curDir];
        }
    }
 
    private static void move(int dir) {
        curDir = dir;
        if (curY+dy[curDir]>=0 && curY+dy[curDir]<H && curX+dx[curDir]>=0 && curX+dx[curDir]<W
                && field[curY+dy[curDir]][curX+dx[curDir]] == '.') {
            curY = curY + dy[curDir];
            curX = curX + dx[curDir];
        }
    }
     
     
}
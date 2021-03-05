import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++){
        int N = sc.nextInt();
        int[] arr = new int[N];
        int[] LIS = new int[N]; //자신을 끝으로 하는 LIS 최장길이
         
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
         
        int max = 0; //전체 최장길이
        for (int i = 0; i < N; i++) {
            LIS[i] = 1; //자신만으로 LIS 구성했을 때의 길이 1
             
            //자신(i)의 앞에 있는 원소들과 비교
            for (int j = 0; j < i; j++) {
                //앞쪽 원소보다 자신이 큰 경우
                if (arr[j] < arr[i] && LIS[i] < LIS[j]+1) {
                    LIS[i] = LIS[j]+1;
                }
//              if (arr[j] < arr[i]) {
//                  LIS[i] = Math.max(LIS[i], LIS[j]+1);
//              }
                 
                //현 원소의 LIS값과 전체 최대값하고 비교하여 최댓값 갱신
                if (max < LIS[i]) max = LIS[i];
            }
             
             
        }
            System.out.println("#" + tc + " " + max);
        }
    }
}
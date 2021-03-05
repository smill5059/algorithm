import java.util.Scanner;
import java.io.FileInputStream;
 
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
                 
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int[] arr = new int[100];
            int dump = sc.nextInt(); 
             
            for (int j = 0; j < arr.length; j++) {
                arr[j] = sc.nextInt();
            }
                         
            int max = 0;
            int maxIndex = 0;
            int min = arr[0];
            int minIndex = 0;
             
            for (int i = 0; i < dump; i++) {
                max = 0;
                maxIndex = 0;
                min = arr[0];
                minIndex = 0;
                 
                for (int j = 0; j < arr.length; j++) {
                    if (arr[j] > max)
                    {
                        max = arr[j];
                        maxIndex = j;
                    }
                     
                    if (arr[j] < min)
                    {
                        min = arr[j];
                        minIndex = j;
                    }
                }
                 
                if (max - min <= 1) {
                    break;
                }
                 
                arr[maxIndex]--;
                arr[minIndex]++;
            }
             
            max = 0;
            maxIndex = 0;
            min = arr[0];
            minIndex = 0;
            for (int j = 0; j < arr.length; j++) {
                    if (arr[j] > max)
                    {
                        max = arr[j];
                        maxIndex = j;
                    }
                     
                    if (arr[j] < min)
                    {
                        min = arr[j];
                        minIndex = j;
                    }
            }
             
            System.out.println("#" + test_case + " " + (max - min));
 
        }
    }
}
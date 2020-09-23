//https://www.hackerrank.com/challenges/2d-array/problem?h_l=interview&playlist_slugs%5B%5D=interview-preparation-kit&playlist_slugs%5B%5D=arrays
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
      int maxsum=0;
      int sum=0;
      boolean flag=false;
      for(int i=0;i<arr.length-2;i++)
      {
        for(int j=0;j<arr[i].length-2;j++)
        {
          sum=0;
          for(int k=j;k<j+3;k++)
          {
              sum=sum+arr[i][k];
          }
          for(int k=i+1;k<i+2;k++)
          {
              sum=sum+arr[k][j+1];
          }
          for(int k=j;k<j+3;k++)
          {
              sum=sum+arr[i+2][k];
          }
          if(!flag)
          {
              maxsum=sum;
              flag=true;
          }
          else if(maxsum<sum)
          {
              maxsum=sum;
          }
        }
      }
      return maxsum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

//https://www.hackerrank.com/challenges/jim-and-the-orders/problem
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the jimOrders function below.
    static int[] jimOrders(int[][] orders) {
        PriorityQueue<Customer> pq = new PriorityQueue<>();
        int num = 1;
        for(int[] i : orders){
            Customer cu = new Customer(num,i[0]+i[1]);
            pq.add(cu);
            num++;
        }
        int[] res = new int[orders.length];
        for(int i = 0 ; i < res.length ; i++) {
           res[i] = pq.poll().customerNumber;
        }
        return res;
    }
    public static class Customer implements Comparable<Customer> {
        int customerNumber;
        int deliveryTime;
        public Customer(int cn , int dt) {
            this.customerNumber = cn;
            this.deliveryTime = dt;
        }
        public int compareTo(Customer ob) {
            if(this.deliveryTime == ob.deliveryTime) {
                return Integer.compare(this.customerNumber,ob.customerNumber);
            }
            else {
                return Integer.compare(this.deliveryTime,ob.deliveryTime);
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[][] orders = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] ordersRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int ordersItem = Integer.parseInt(ordersRowItems[j]);
                orders[i][j] = ordersItem;
            }
        }

        int[] result = jimOrders(orders);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

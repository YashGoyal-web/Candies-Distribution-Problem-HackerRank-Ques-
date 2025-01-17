/*
The below lines of code is the solution of Candies distribution problem .
function candies returns the minimum number of candies required..
*/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
        
        long totalNumberOfCandies=0;
        int count =1;
        int count2 = 1;
        int i =0;
        int []ResultArray = new int[n];

            for(int j = 0 ; j<arr.length ; j++){
                ResultArray[j] = 1;
            }       
            
            for(int j = 0 ; j<arr.length-1 ; j++){
                
                if(arr[j] < arr[j+1]){
                
                    ResultArray[j+1] = ResultArray[j]+1;
                             
                }
            }
            
            
            for(int j = arr.length-1 ; j>0 ; j--){
                
                if(arr[j] < arr[j-1] && ResultArray[j-1] <= ResultArray[j]){
                
                    ResultArray[j-1] = ResultArray[j]+1;
                             
                }
            }
        
           for(int j =0;j<arr.length;j++){
               totalNumberOfCandies += ResultArray[j] ; 
           }

           return totalNumberOfCandies;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

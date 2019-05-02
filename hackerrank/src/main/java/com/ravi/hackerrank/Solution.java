/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ravi.hackerrank;

/**
 *
 * @author ravi
 */
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
        List<Integer> results =  new ArrayList<Integer>();
        traverse(arr, 0 , 0, results);
        Collections.sort(results);
        return results.get(0);

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

    private static void traverse(int[][] arr, int rowCtr, int colCtr, List<Integer> arrayList) {
        if((colCtr + 2 ) > 5)
            traverse(arr, ++rowCtr, 0, arrayList) ;
        else if ( (rowCtr + 2) > 5)
            return;           
        else{
            arrayList.add(sum(arr, rowCtr, colCtr, rowCtr+3, colCtr+3));
            traverse(arr, rowCtr, ++colCtr, arrayList) ;
        }
    }

    private static Integer sum(int[][] arr, int rowCtr, int colCtr, int rowBound, int colBound) {
        if( (rowCtr == (rowBound-1)) && (colCtr == (colBound-2) || colCtr == (colBound)))
            return sum(arr, rowCtr, ++colCtr, rowBound, colBound);
        else if(rowCtr > rowBound)
            return 0;
        else if(colCtr > colBound)
            return sum(arr, ++rowCtr,colBound-2 , rowBound, colBound);
        else    
            return arr[rowCtr][colCtr] + sum(arr, rowCtr, ++colCtr, rowBound, colBound);
    }
}
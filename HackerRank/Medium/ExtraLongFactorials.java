/***   URL: https://www.hackerrank.com/challenges/extra-long-factorials/problem   ***/

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {
        BigInteger fac = new BigInteger("1");
        while(n>0)
        {
            BigInteger bign = new BigInteger(String.valueOf(n));
            fac = fac.multiply(bign);
            n--;
        }
        
        System.out.println(fac);
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        extraLongFactorials(n);

        scanner.close();
    }
}

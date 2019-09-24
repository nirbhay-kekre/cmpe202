package cmpe202.lab6;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'missingWords' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     */

    public static List<String> missingWords(String s, String t) {
    // Write your code here
    	String[] sWords = s.split(" ");
    	String[] tWords = t.split(" ");
    	List<String> missingWords = new ArrayList<>();
    	int sIndex =0, tIndex=0;
    	while(tIndex < tWords.length) {
    		if(sWords[sIndex].equals(tWords[tIndex])) {
    			tIndex++;
    			sIndex++;
    			continue;
    		}
    		missingWords.add(sWords[sIndex++]);
    	}
    	while(sIndex < sWords.length) {
    		missingWords.add(sWords[sIndex++]);
    	}
    	return missingWords;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        List<String> result = Result.missingWords(s, t);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
    
    public static int kDifference(List<Integer> a, int k) {
        // Write your code here

        }
}

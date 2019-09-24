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
     * Complete the 'textQueries' function below.
     *
     * The function accepts following parameters:
     *  1. STRING_ARRAY sentences
     *  2. STRING_ARRAY queries
     */

    public static void textQueries(List<String> sentences, List<String> queries) {
    // Write your code here
    	Map<String, List<Integer>> wordToSentenceNumbersMap = new HashMap<>();
    	int sentenceNumber = 0;
    	for(String sentence : sentences) {
    		String[] words = sentence.split(" ");
    		for(String word: words) {
    			List<Integer> sentenceNumbers = wordToSentenceNumbersMap.get(word);
    			if(sentenceNumbers == null) {
    				sentenceNumbers = new ArrayList<Integer>();
    				wordToSentenceNumbersMap.put(word,  sentenceNumbers);
    			}
    			sentenceNumbers.add(sentenceNumber);
    		}
    		sentenceNumber++;
    	}
    	for(String query: queries) {
    		String[] words = query.split(" ");
    		List<Integer> intersection = wordToSentenceNumbersMap.get(words[0]);
    		if(intersection == null) {
    			intersection = new ArrayList<Integer>();
    		}
    		for(int i=1 ; i< words.length; i++) {
    			intersection = intersection(intersection, wordToSentenceNumbersMap.get(words[i]));
    		}
    		for(Integer result : intersection) {
    			System.out.print(result+" ");
    		}
    		if(!intersection.isEmpty()) {
    			System.out.println();
    		}else {
    			System.out.println(-1);
    		}
    	}
    }
    public static List<Integer> intersection(List<Integer> a, List<Integer> b){
    	List<Integer> intersection = new ArrayList<>();
    	int i=0,j=0;
    	while(i<a.size() && j<b.size()) {
    		if(a.get(i)-b.get(j) ==0) {
    			intersection.add(a.get(i));
    			i++;j++;
    		}else if(a.get(i)-b.get(j) > 0) {
    			j++;
    		}else {
    			i++;
    		}
    	}
    	return intersection;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int sentencesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> sentences = IntStream.range(0, sentencesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int queriesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> queries = IntStream.range(0, queriesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        Result.textQueries(sentences, queries);

        bufferedReader.close();
    }
}
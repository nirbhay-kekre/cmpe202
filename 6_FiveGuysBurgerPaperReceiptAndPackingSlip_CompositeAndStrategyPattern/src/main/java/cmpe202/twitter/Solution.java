package cmpe202.twitter;

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
     * Complete the 'countMatches' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING_ARRAY grid1
     *  2. STRING_ARRAY grid2
     */

    public static int countMatches(List<String> grid1, List<String> grid2) {
    	int commonRegion =0;
    	int [][] g1= new int[grid1.size()][grid1.get(0).length()];
    	int [][] g2= new int[grid2.size()][grid2.get(0).length()];
    	int i=0;
    	for(String row : grid1) {
    		for(int j=0 ;j<row.length(); j++) {
    			g1[i][j] = row.charAt(j)-'0';
    		}
    		i++;
    	}
    	i=0;
    	for(String row : grid2) {
    		for(int j=0 ;j<row.length(); j++) {
    			g2[i][j] = row.charAt(j)-'0';
    		}
    		i++;
    	}
    	for(i= 0 ; i< Math.min(g1.length,g2.length); i++) {
    		for(int j=0; j <Math.min(g1[0].length,g2[0].length);j++ ) {
    			if(g1[i][j] == 1 && g1[i][j]==g2[i][j]) {
    				List<Integer> dfsResult1 = new ArrayList<>();
    				List<Integer> dfsResult2 = new ArrayList<>();
    				DFS(g1 , i ,j,dfsResult1);
    				DFS(g2, i, j, dfsResult2);
    				if(dfsResult1.equals(dfsResult2)) {
    					commonRegion++;
    				}
    			}
    		}
    	}
    	return commonRegion;
    }
    
    public static void DFS(int[][] grid, int row, int col, List<Integer> dfsResult) {
    	if(row<0 || col<0 || row>=grid.length || col >= grid[0].length || grid[row][col] == 0) {
    		return;
    	}
    	grid[row][col] = 0;
    	dfsResult.add(row*grid[0].length + col);
    	DFS(grid, row-1, col, dfsResult);
    	DFS(grid, row, col-1, dfsResult);
    	DFS(grid, row, col+1, dfsResult);
    	DFS(grid, row+1, col, dfsResult);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int grid1Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid1 = IntStream.range(0, grid1Count).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int grid2Count = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid2 = IntStream.range(0, grid2Count).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .collect(toList());

        int result = Result.countMatches(grid1, grid2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}


package src.AmzOA;

import java.util.Arrays;

public class MaximaCount {

    static int findMaximaCount(String categories){
        int[][] matrix = new int[26][categories.length()+1];
        for(int i = 0; i < categories.length(); i++){
            int charIndex = categories.charAt(i) - 'a';
            for(int j=0 ; j < 26; j++){
                if(charIndex == j){
                    matrix[j][i+1] = 1 + matrix[j][i];
                }else{
                    matrix[j][i+1] = matrix[j][i];
                }
            }
        }
        int[] maximums = new int[26];
        for(int i=0; i < categories.length(); i++){
            int maximum = 0;
            for(int j=0; j < 26; j++){
                maximum = Math.max(maximum, matrix[j][i+1]);
            }
            for(int j=0; j < 26; j++){
                if(matrix[j][i+1] == maximum){
                    maximums[j] +=1;
                }
            }
        }
        return Arrays.stream(maximums).max().getAsInt();
    }
    public static void main(String[] args) {
        System.out.println(findMaximaCount("bccaaacb"));
    }
}

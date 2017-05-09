

public class Main {

    public static void main(String[] args) {

        String word1 = "aleksander";
        String word2 = "olga";
        
        
        LongestCommonSequence LCS = new LongestCommonSequence();
        
        int[][] valuesTable = LongestCommonSequence.generateArray(word1, word2);
        LongestCommonSequence.printArray(valuesTable, word1, word2);
          LCS.longestSubsequences(valuesTable, word1, word2);
          System.out.println("Before remove the same");
          LCS.printWords();
          LCS.removeTheSame();
          System.out.println("after");
          LCS.printWords();   
    }

}

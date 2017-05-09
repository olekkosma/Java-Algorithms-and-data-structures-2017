
import java.util.ArrayList;


public class LongestCommonSequence {

    ArrayList words;

    public LongestCommonSequence() {
        words = new ArrayList();
    }

    public ArrayList getWords() {
        return words;
    }

    public static int[][] generateArray(String word1, String word2) {
        int lengthWord1 = word1.length();
        int LengthWord2 = word2.length();
        int[][] valuesTable = new int[lengthWord1 + 1][LengthWord2 + 1];

        int i, j;

        for (i = 0; i < lengthWord1 + 1; i++) {
            for (j = 0; j < LengthWord2 + 1; j++) {
                valuesTable[i][j] = 0;

            }

        }

        for (i = 0; i < lengthWord1; i++) {
            for (j = 0; j < LengthWord2; j++) {
                if (word1.charAt(i) == word2.charAt(j)) {

                    valuesTable[i + 1][j + 1] = 1 + valuesTable[i][j];
                } else {
                    valuesTable[i + 1][j + 1] = maximumValue(valuesTable[i + 1][j], valuesTable[i][j + 1]);
                }

            }
        }
        return valuesTable;

    }

    public static void printArray(int[][] valuesTable, String word1, String word2) {
        int i, j;
        int height = word1.length();
        int width = word2.length();
        System.out.print("    ");
        for (i = 0; i < width; i++) {
            System.out.print(" " + word2.charAt(i));
        }
        System.out.println("");
        System.out.print(" ");

        for (i = 0; i < height + 1; i++) {
            if (i - 1 >= 0) {
                System.out.print(" " + word1.charAt(i - 1));
            } else {
                System.out.print(" ");
            }
            for (j = 0; j < width + 1; j++) {

                System.out.print(" " + valuesTable[i][j]);
            }
            System.out.println("");
        }

    }

    public static void printTrueArray(int[][] valuesTable, String word1, String word2) {
        int i, j;
        int height = word1.length();
        int width = word2.length();

        for (j = 0; j < width + 1; j++) {
            for (i = 0; i < height + 1; i++) {

                System.out.print(valuesTable[i][j]);
            }
            System.out.println("");
        }

    }

    public String longestSubsequences(int[][] valuesTable, String word1, String word2) {
        String sLCS = "";
        ArrayList wordsTmp = new ArrayList();
        int lengthWord1 = word1.length();
        int lengthWord2 = word2.length();
        int i = lengthWord1;
        int j = lengthWord2;

        while (i > 0 && j > 0) {
            if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                sLCS = word1.charAt(i - 1) + sLCS;
                i--;
                j--;

            } else {
                if (valuesTable[i - 1][j] == valuesTable[i][j - 1]) {

                    int[][] tmpTable = new int[lengthWord1 + 1][lengthWord2 + 1];
                    int[][] tmpTable2 = new int[lengthWord1 + 1][lengthWord2 + 1];
                    CopyTwoDimentionalArray.copyArray(valuesTable, tmpTable, lengthWord1 + 1, lengthWord2 + 1);
                    CopyTwoDimentionalArray.copyArray(valuesTable, tmpTable2, lengthWord1 + 1, lengthWord2 + 1);

                    tmpTable[i - 1][j] -= 1;
                    tmpTable2[i][j - 1] -= 1;
                    //printTable(valuesTable, word1, word2);
                    sLCS = longestSubsequences(tmpTable, word1, word2);
                    words.add(sLCS);
                    sLCS = longestSubsequences(tmpTable2, word1, word2);
                    words.add(sLCS);

                    break;

                } else {
                    if (valuesTable[i - 1][j] > valuesTable[i][j - 1]) {
                        i--;
                    } else {
                        j--;
                    }
                }
            }

        }
        if (words.isEmpty()) {
            words.add(sLCS);
        }
        return sLCS;
    }

    public void printWords() {
        int z = 0;

        for (z = 0; z < this.words.size(); z++) {
            System.out.println(this.words.get(z));
        }

    }

    public void removeTheSame() {
        
        ArrayList tmp = new ArrayList();
        if (!this.words.isEmpty()) {
            tmp.add(this.words.get(0));
        } else {
            return;
        }
        int z;
         for (z = 1; z < this.words.size(); z++) {
             if(!tmp.contains(this.words.get(z))){
                 tmp.add(this.words.get(z));
             }
            
        }
         this.words=tmp;
        
        
    }

    public static int maximumValue(int one, int two) {
        if (one > two) {
            return one;
        } else {
            return two;
        }
    }

}

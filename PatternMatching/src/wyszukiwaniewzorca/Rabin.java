package wyszukiwaniewzorca;

public class Rabin {

    private static int lettersSize = 256;
    private static int prime = 14699;

    public static void Rabin(String wzorzec, String lancuch) {
        int patternLen = wzorzec.length();
        int textLen = lancuch.length();
        int max = textLen - patternLen;
        int wzorzecHash, lancuchHash;
        int h = 1;
        for (int i = 0; i < patternLen - 1; i++) {
            h = (h * lettersSize) % prime;
        }
        wzorzecHash = hash(wzorzec, 0, patternLen);
        lancuchHash = hash(lancuch, 0, patternLen);

        for (int i = 0; i < max; i++) {
            int j = 0;
            if (wzorzecHash == lancuchHash) {
                while ((j < patternLen) && (wzorzec.charAt(j) == lancuch.charAt(i + j))) {
                    j++;
                }

                if (j == patternLen) {
                    //System.out.println(i + 1);
                }
            }
            int t1 = (lancuch.charAt(i) * h) % prime;
            if (lancuchHash < t1) {
                lancuchHash += prime;
            }
            lancuchHash = (lettersSize * (lancuchHash - t1) + lancuch.charAt(i + patternLen)) % prime;
        }
    }

    public static int hash(String tekst, int pocz, int kon) {
        int h = 0;
        for (int i = pocz; i < kon; i++) {
            h = (lettersSize * h + tekst.charAt(i)) % prime;
        }
        return h;
    }
}

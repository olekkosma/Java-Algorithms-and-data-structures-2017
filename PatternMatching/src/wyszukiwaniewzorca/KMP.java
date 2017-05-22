
package wyszukiwaniewzorca;


public class KMP {

    public static void KMP(String wzorzec, String lancuch) {
        int b, j, i;
        int n = lancuch.length();
        int m = wzorzec.length();
        int KMPNext[] = new int[m + 1];

        KMPNext[0] = 0;
        KMPNext[1] = 0;
        b = 0;
        for (j = 2; j <= m; j++) {
            while ((b > 0) && (wzorzec.charAt(b) != wzorzec.charAt(j - 1))) {
                b = KMPNext[b];
            }
            if (wzorzec.charAt(b) == wzorzec.charAt(j - 1)) {
                b++;
            }
            KMPNext[j] = b;
        }
        i = 1;
        j = 0;
        while (i <= n - m + 1) {
            j = KMPNext[j];
            while ((j < m) && (wzorzec.charAt(j) == lancuch.charAt(i + j - 1))) {
                j++;
            }
            if (j == m) {
                //System.out.println(i);
            }
            i = i + Math.max(1, j - KMPNext[j]);
        }

    }
    
}

package wyszukiwaniewzorca;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WyszukiwanieWzorca {

    private static final int r = 256;   //liczba symboli alfabetu (char 0-255)
    private static final int q = 9551;  //możliwie duża liczba pierwsza  

    public static int power_modulo_fast(int a, int b, int m) {
        int i;
        int result = 1;
        long x = a % m;

        for (i = 1; i <= b; i <<= 1) {
            x %= m;
            if ((b & i) != 0) {
                result *= x;
                result %= m;
            }
            x *= x;
        }

        return result % m;
    }

    public static String WritingFileToString(String fileName) throws FileNotFoundException {
        String destination = "";
        File file = new File(fileName);
        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            destination = destination + line;

        }
        reader.close();
        return destination;

    }

    public static void FaMatcher(String lancuch, int[][] d, int m) {
        int q = 0;
        int i;
        int n = lancuch.length();
        for (i = 0; i < n; i++) {
            q = d[q][lancuch.charAt(i) - 97];
            if (q == m) {
                System.out.print(i);
            }
        }
    }

    public static int[][] TransitionFunction(String wzorzec, String alfabet) {
        int[] KMPNext = PrefixFunction(wzorzec);
        int q;
        int i;
        int n = alfabet.length();
        int m = wzorzec.length();
        int[][] d = new int[m][n];
        for (q = 1; q < m; q++) {
            for (i = 0; i < n; i++) {
                if (q == m || alfabet.charAt(i) != wzorzec.charAt(q - 1)) {
                    d[q - 1][alfabet.charAt(i) - 97] = d[KMPNext[q - 1]][alfabet.charAt(i) - 97];
                } else {
                    d[q - 1][alfabet.charAt(i) - 97] = q + 1;
                }

            }
        }
        return d;
    }

    public static int[] PrefixFunction(String wzorzec) {
        int b, j, i;
        int m = wzorzec.length();
        int KMPNext[] = new int[m + 1];

        //KMPNext[0] = 0;
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
        return KMPNext;
    }

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
                System.out.println(i);
            }
            i = i + Math.max(1, j - KMPNext[j]);
        }

    }

    public static void Rabin(String wzorzec, String lancuch) {

        int h1, h2, rm;
        int j, i;
        int n = lancuch.length();
        int m = wzorzec.length();
        h2 = 0;
        h1 = 0;
        System.out.println("Rabina");

        for (i = 0; i < m; i++) {
            h2 = ((h2 * r) + lancuch.charAt(i));
            h2 %= q;
        }

        for (i = 0; i < m; i++) {
            h1 = ((h1 * r) + wzorzec.charAt(i));
            h1 %= q;
        }

        rm = power_modulo_fast(r, m - 1, q);
        i = 0;
        while (i < n - m) {
            j = 0;
            if (h1 == h2) {
                while ((j < m) && (wzorzec.charAt(j) == lancuch.charAt(i + j))) {
                    j++;
                }
            }
            if (j == m) {
                System.out.println(i + 1);
            }
            h2 = ((h2 - lancuch.charAt(i) * rm) * r + lancuch.charAt(i + m));
            h2 %= q;
            if (h2 < 0) {
                h2 += q;
            }
            i++;
        }
        j = 0;
        if (h1 == h2) {
            while ((j < m) && (wzorzec.charAt(j) == lancuch.charAt(i + j))) {
                j++;
            }
        }
        if (j == m) {
            System.out.println(i + 1);
        }

    }

    public static void Obcious(String wzorzec, String lancuch) {
        int n = lancuch.length();
        int m = wzorzec.length();
        int i;
        System.out.println("oczywisty");
        for (i = 0; i < n - m + 1; i++) {

            if (wzorzec.equals(lancuch.subSequence(i, m + i))) {
                System.out.println(i + 1);
            }

        }

    }

    public static void main(String[] args) throws FileNotFoundException {
        String wzorzec = WritingFileToString("wzorzec.txt");
        String lancuch = WritingFileToString("tekst.txt");
        String alfabet = "abcdefghijklmnopqrstuvwxyz";

        //KMP
        System.out.println("indeksy wyszukanych wzorcow w tekscie:");
        long start = System.nanoTime();
        KMP(wzorzec, lancuch);
        long elapsedTime = System.nanoTime() - start;
        System.out.println("czas szukania wzorca dla KMP:" + elapsedTime);

        //Rabin
        System.out.println("indeksy wyszukanych wzorcow w tekscie");
        start = System.nanoTime();
        Rabin(wzorzec, lancuch);
        elapsedTime = System.nanoTime() - start;
        System.out.println("czas szukania wzorca dla Rabina:" + elapsedTime);
        //Obvious
        System.out.println("indeksy wyszukanych wzorcow w tekscie");
        start = System.nanoTime();
        Obcious(wzorzec, lancuch);
        elapsedTime = System.nanoTime() - start;
        System.out.println("czas szukania wzorca dla oczywistego:" + elapsedTime);

    }
}

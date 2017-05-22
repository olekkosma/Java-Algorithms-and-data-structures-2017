package wyszukiwaniewzorca;

import java.io.Console;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WyszukiwanieWzorca {

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

    public static void main(String[] args) throws FileNotFoundException {
        String wzorzec = WritingFileToString("wzorzec.txt");
        String lancuch = WritingFileToString("tekst.txt");
        long start;
        long elapsedTime;
        long sum = 0, i,sum2 = 0, sum3 = 0;
        long result;
        //kmp
        System.out.println("            KMP             ");
        for (i = 0; i < 20; i++) {
            start = System.nanoTime();
            KMP.KMP(wzorzec, lancuch);
            elapsedTime = System.nanoTime() - start;
            sum += elapsedTime;
        }
        result = sum / 20;
        System.out.println("sredni czas szukania wzorca dla KMP:" + result);

        System.out.println("            Rabin             ");
        for (i = 0; i < 20; i++) {
            start = System.nanoTime();
            Rabin.Rabin(wzorzec, lancuch);
            elapsedTime = System.nanoTime() - start;
            sum2 += elapsedTime;
        }
        result = sum2 / 20;
        System.out.println("sredni czas szukania wzorca dla Rabina:" + result);

        System.out.println("            Obvious             ");
        for (i = 0; i < 10; i++) {
            start = System.nanoTime();
            Obvious.Obvious(wzorzec, lancuch);
            elapsedTime = System.nanoTime() - start;
            sum3 += elapsedTime;
        }
        result = sum3 / 10;
        System.out.println("sredni czas szukania wzorca dla Oczywistego:" + result);

        System.out.println("Proporcje:");
        System.out.println("KMP : Rabin : Obvious:");
        double propocje1 = (double) sum2 / (double) sum;
        double propocje2 = sum3 / sum;
        System.out.printf(" 1  : %.2f  : %.0f  \n", propocje1, +propocje2);

    }
}

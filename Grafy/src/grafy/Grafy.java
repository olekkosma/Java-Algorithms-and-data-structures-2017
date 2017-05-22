
package grafy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Grafy {

    public static int krawedzie;
    public static String wierzcholkiOdp="";
    public static String krawedzieOdp="";

    public static void DFS(int v, boolean[] odwiedzone, int[][] macierz) {
        odwiedzone[v] = true;
        wierzcholkiOdp=wierzcholkiOdp+v+" ";

        for (int i = 0; i < krawedzie; i++) {
            if ((macierz[v][i] == 1) && !odwiedzone[i]) {
                krawedzieOdp=krawedzieOdp+"krawedz: " + v + " " + i+"\n";
                DFS(i, odwiedzone, macierz);
            }
        }
    }

    public static int[][] wczytajMacierz(String plik) throws FileNotFoundException {
        File fileName = new File(plik);
        Scanner reader = new Scanner(fileName);
        String line = reader.nextLine();
        krawedzie = Integer.parseInt(line);
        int[][] macierz = new int[krawedzie][krawedzie];
        int wiersz=0;
        while (reader.hasNextLine()) {
            
            line = reader.nextLine();
            for(int i=0;i<krawedzie;i++){
                macierz[wiersz][i]=Integer.parseInt(Character.toString(line.charAt(i)));
            }
            wiersz++;
        }
        return macierz;
    }

    public static void main(String[] args) throws FileNotFoundException {
        int[][] macierz = wczytajMacierz("Grafy.txt");
        boolean[] odwiedzone = new boolean[krawedzie];

        for (int i = 0; i < krawedzie; i++) {
            odwiedzone[i] = false;
            for (int j = 0; j < krawedzie; j++) {
                System.out.print(macierz[i][j]);
            }
            System.out.println("");
        }
          macierz[3][4] = 1;

        DFS(0, odwiedzone, macierz);
        System.out.println(krawedzieOdp);
        System.out.println(wierzcholkiOdp);

    }

}

package rozlaczne;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        /*
         Node[] values = new Node[11];
         int i;

         for (i = 1; i <= 10; i++) {
         values[i] = new Node(i);

         }

         rozlaczne.Union(values[1], values[2]);
         rozlaczne.Union(values[3], values[4]);
         rozlaczne.Union(values[5], values[4]);
         rozlaczne.Union(values[1], values[5]);
         rozlaczne.Union(values[6], values[7]);
         rozlaczne.Union(values[8], values[9]);
         rozlaczne.Union(values[6], values[8]);
         rozlaczne.Union(values[7], values[4]);

         System.out.println(values[9]);

         */
        Graf graf = new Graf();

        graf.addWierzcholek(0);
        graf.addWierzcholek(1);
        graf.addWierzcholek(2);
        graf.addWierzcholek(3);
        graf.addWierzcholek(4);
        graf.addWierzcholek(5);
       

        graf.addKrawedz(0, 2, 20);
        graf.addKrawedz(0, 1, 10);
        graf.addKrawedz(1, 4, 10);
        graf.addKrawedz(2, 4, 33);
        graf.addKrawedz(2, 3, 20);
        graf.addKrawedz(1, 3, 50);
        graf.addKrawedz(3, 4, 20);
        graf.addKrawedz(3, 5, 2);
        graf.addKrawedz(4, 5, 1);
        

        List<Krawedz> kruskal = rozlaczne.kruskal(graf);
        System.out.println(kruskal);
    }

}

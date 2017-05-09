/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozlaczne;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ukleja
 */
public class rozlaczne {

    public static Node findSet2(Node x) {

        if (x != x.getParent()) {

            return findSet2(x.getParent());
        }
        return x;
    }

    public static Node findSet(Node x) {

        if (x != x.getParent()) {

            x.setParent(findSet(x.getParent()));
        }
        return x.getParent();
    }

    public static void Union(Node y, Node x) {
        //System.out.println("=====================\n\n");
        //System.out.println(x.getParent()+" "+y.getParent());

        if (x.getParent().getRank() > y.getParent().getRank()) {
            y.setParent(findSet(x));

        } else {
            Node parentX = findSet(x);
            Node parentY = findSet(y);
            parentX.setParent(parentY);

            if (parentX.getRank() == parentY.getRank()) {
                parentY.setRank(parentY.getRank() + 1);
            }
        }

    }

    public static List<Krawedz> kruskal(Graf graf) {
        List<Krawedz> kruskal = new ArrayList<>();
        int i;
        Node[] wierzcholki = new Node[graf.getWierzcholki().size()+1];
        for (i = 1; i < graf.getWierzcholki().size()+1; i++) {
            wierzcholki[graf.getWierzcholki().get(i-1)] = new Node(graf.getWierzcholki().get(i-1));
        }

        graf.sortKrawedzie();

        for (Krawedz krawedz : graf.getKrawedzie()) {
            if (findSet(wierzcholki[krawedz.getPocz()]) != findSet(wierzcholki[krawedz.getKon()])) {
                kruskal.add(krawedz);
                Union(wierzcholki[krawedz.getPocz()], wierzcholki[krawedz.getKon()]);

            }

        }
        return kruskal;
    }

}

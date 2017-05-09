/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozlaczne;

import java.util.Comparator;

/**
 *
 * @author Ukleja
 */
public class krawedzComparator implements Comparator<Krawedz>{

    @Override
    public int compare(Krawedz o1, Krawedz o2) {
       if (o1.getWaga()> o2.getWaga()) {
            return 1;
        } else {
            if (o1.getWaga() < o2.getWaga()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
    
}

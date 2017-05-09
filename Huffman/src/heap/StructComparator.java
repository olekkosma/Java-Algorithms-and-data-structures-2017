/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import java.util.Comparator;

/**
 *
 * @author Ukleja
 */
public class StructComparator implements Comparator<Struct> {

    @Override
    public int compare(Struct o1, Struct o2) {

        if (o1.getValue() > o2.getValue()) {
            return 1;
        } else {
            if (o1.getValue() < o2.getValue()) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}

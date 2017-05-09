/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozlaczne;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Ukleja
 */
public class Graf {
    
    List<Integer> wierzcholki = new ArrayList<>();
    List<Krawedz> krawedzie = new ArrayList<>();
   

    public Graf() {
    }
    
    public void addWierzcholek(int value){
        wierzcholki.add(value);
        
    }
    
    public void addKrawedz(int pocz, int kon,int waga){
        krawedzie.add(new Krawedz(pocz,kon,waga));
    }

    public List<Krawedz> getKrawedzie() {
        return krawedzie;
    }

    public List<Integer> getWierzcholki() {
        return wierzcholki;
    }
    
    public void sortKrawedzie(){
        krawedzie.sort((Comparator<? super Krawedz>) new krawedzComparator());
    }
    
}

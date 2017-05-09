/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rozlaczne;

/**
 *
 * @author Ukleja
 */
public class Krawedz {
    
    private int pocz;
    private int kon;
    private int waga;

    public Krawedz(int pocz, int kon, int waga) {
        this.pocz = pocz;
        this.kon = kon;
        this.waga = waga;
    }

    public int getWaga() {
        return waga;
    }
    


    public int getKon() {
        return kon;
    }

    public int getPocz() {
        return pocz;
    }

    @Override
    public String toString() {
       return this.pocz+"--"+this.kon + "  waga:"+this.waga+"\n";
    }

   
    
    
}

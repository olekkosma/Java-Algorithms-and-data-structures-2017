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
public class Node {
    
    private Node parent;
    private int rank;
    private int key;

    public Node(int key) {
        this.parent = this;
        this.rank = 0;
        this.key = key;
    }

    @Override
    public String toString() {
        
        return "\nranga:"+this.rank+"\nklucz:"+this.key+"\nreprezentant:"+rozlaczne.findSet2(this).getKey()+"\nojciec:"+this.getParent().getKey();
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getKey() {
        return key;
    }
    
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 *
 * @author Ukleja
 */
public class Struct {

    private int value;
    private char letter;
    private Struct left;
    private Struct right;

    public Struct(int value, char letter) {

        this.value = value;
        this.letter = letter;
    }

    public Struct(int value, char letter, Struct left, Struct right) {
        this.value = value;
        this.letter = letter;
        this.left = left;
        this.right = right;
    }

    public static void printStruct(Struct struct) {

        if (struct == null) {
            return;

        } else {
            System.out.println(struct);
            printStruct(struct.getLeft());
            printStruct(struct.getRight());
        }

    }

    @Override
    public String toString() {
        return this.letter + " count: " + this.value;
    }

    public int getValue() {
        return value;
    }

    public char getLetter() {
        return letter;
    }

    public Struct getLeft() {
        return left;
    }

    public Struct getRight() {
        return right;
    }

}

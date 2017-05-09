/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Huffman {

    public static void generateTree(PriorityQueue<Struct> kolejka) {
        while (kolejka.size() > 1) {
            //for (Struct struct : kolejka) {
            //    System.out.println(struct);
            //}
            Struct tmp = kolejka.remove();
            Struct tmp2 = kolejka.remove();
            Struct newNode = new Struct((tmp.getValue()) + tmp2.getValue(), '!', tmp, tmp2);
            kolejka.add(newNode);
             //System.out.println("\n");

        }

    }

    public static Set<Character> addLeters(PriorityQueue<Struct> kolejka) {
        Set<Character> chars;
        chars = new HashSet<>();

        for (Struct struct : kolejka) {
            chars.add(struct.getLetter());
        }
        return chars;
    }

    static Map<Character, String> generateCodes(Set<Character> chars, Struct node) {

        Map<Character, String> map = new HashMap<>();
        doGenerateCode(node, map, "");
        return map;

    }

    public static void printCode(Map<Character, String> map) {
int i=0;
System.out.println("------------------------");
        System.out.println("Huffman codes: ");
        for (char s : map.keySet()) {
        i++;    
            System.out.printf("%c: %5s  ",s,map.get(s));
            if(i%3==0) System.out.println("");

        }
        System.out.println("\n------------------------");
        System.out.println("");

    }

    public static void doGenerateCode(Struct node, Map<Character, String> map, String s) {
        if (node.getLeft() == null && node.getRight() == null) {
            map.put(node.getLetter(), s);
            return;
        }
        doGenerateCode(node.getLeft(), map, s + '0');
        doGenerateCode(node.getRight(), map, s + '1');
    }

    
    
    public static Character EncodeLetter(Struct node, String code, int index) {
        Character letter=null;
        if (node.getLeft() == null && node.getRight() == null) {
            
            
            return node.getLetter();
        }
        if(code.length()<index+1){
            return null;
        }
        if (code.charAt(index) == '0') {
            
            letter =EncodeLetter(node.getLeft(), code, index + 1);
        } else if (code.charAt(index) == '1'){
           
            letter =EncodeLetter(node.getRight(), code, index + 1);
        }

         
         return letter;
    }

}

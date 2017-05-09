package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import javax.xml.stream.events.Characters;

public class Main {
    
    public static void main(final String[] args) throws Exception {
        Map<Character, Integer> lettersFriquency = null;
        lettersFriquency = ReaderFile.read();
        System.out.println(lettersFriquency);
        
        Comparator<Struct> comparator = new StructComparator();
        PriorityQueue<Struct> kolejka = new PriorityQueue(lettersFriquency.size(), comparator);
        
       for(Character letter : lettersFriquency.keySet()){
           kolejka.add(new Struct(lettersFriquency.get(letter),letter));
       
        }
        
        
        Huffman.generateTree(kolejka);      //now we have one Node

        Set<Character> chars = Huffman.addLeters(kolejka);          //add letters to Set of characters

        Map<Character, String> code = null;
        for (Struct struct : kolejka) {
            chars.add(struct.getLetter());
            
            code = Huffman.generateCodes(chars, struct);
            
        }
        
        Huffman.printCode(code);
        //Statistics
        int normalBytes = Calculations.allBytes(lettersFriquency);
        System.out.println("bytes needed to normal save: "+normalBytes);
        int HuffmanBytes = Calculations.HuffmanBytes(lettersFriquency, code);
        System.out.println("bytes needed to Huffman save: "+HuffmanBytes);
        double saving = Calculations.CalculateSave(normalBytes, HuffmanBytes);
        System.out.println("Memeory save: "+Math.ceil(saving)+"%");
                
        
        //Character foundLetter = Huffman.EncodeLetter(kolejka.element(),"0", 0);
        //System.out.println(foundLetter);
         ReaderFile.readAndSaveLetterByLetter(code);
        ReaderFile.Encode(kolejka.element());
        
       
    }
    
}

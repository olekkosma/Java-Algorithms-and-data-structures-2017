/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Ukleja
 */
public class ReaderFile {

    public static Map<Character, Integer> read() throws Exception {

        Map<Character, Integer> lettersFriquency = new HashMap<>();
        int i;
        File file = new File("slowa.txt");

        Scanner reader = new Scanner(file);
        while (reader.hasNextLine()) {
            String line = reader.nextLine();

            for (i = 0; i < line.length(); i++) {
                Character letter = line.charAt(i);

                if (lettersFriquency.containsKey(letter)) {

                    Integer value = lettersFriquency.get(letter);
                    value++;
                    lettersFriquency.put(letter, value);

                } else {

                    lettersFriquency.put(letter, 1);
                }

            }

        }
        reader.close();
        return lettersFriquency;
    }

    public static void readAndSaveLetterByLetter(Map<Character, String> code) throws FileNotFoundException, IOException {
        int c = 0;

        FileReader fileReader = new FileReader("slowa.txt");
        BufferedReader reader = new BufferedReader(fileReader);

        FileWriter writer = new FileWriter("HuffmanCode.txt");
        while ((c = reader.read()) != -1) {

            if (c == 13) {
                writer.write('\n');
            } else if (!(c == 10)) {
                char letter = (char) c;
                writer.write(code.get(letter));
            }

        }
        writer.close();
        reader.close();

    }

    public static void Encode(Struct node) throws FileNotFoundException, IOException {
        System.out.println("-----------------------");
        System.out.println("Encoding file:");
        int c = 0;
        FileReader fileReader = new FileReader("HuffmanCode.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        String searchedCode = "";
        while ((c = reader.read()) != -1) {
            
            if (!(c == 10)) {
               
               

                Character letter = (char) c;

                searchedCode += letter.toString();

                if (!(Huffman.EncodeLetter(node, searchedCode, 0) == null)) {
                    System.out.print(Huffman.EncodeLetter(node, searchedCode, 0));
                    searchedCode = "";
                }

            }else{
                System.out.println("");
            }
        }
         System.out.println("\n-----------------------");
       

    }

}

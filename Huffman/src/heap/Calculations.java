/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package heap;

import java.util.Map;

/**
 *
 * @author Ukleja
 */
public class Calculations {

    public static int Calculate(int value) {

        int comp = 2;
        int power = 1;

        while (comp < value) {
            comp *= 2;
            power++;
        }
        return power;
    }

    public static int allBytes(Map<Character, Integer> lettersFriquency) {
        int charactersCount = lettersFriquency.size();
        int power = Calculate(charactersCount);
        int sum = 0;
        for (Integer value : lettersFriquency.values()) {

            sum += value;
        }
        sum = sum * power;
        return sum;
    }
    
    public static int HuffmanBytes(Map<Character, Integer> lettersFriquency,Map<Character, String> code){
        int sum=0;
        for(Character letter : lettersFriquency.keySet()){
            sum = sum + lettersFriquency.get(letter) * code.get(letter).length();
        }
        
        return sum;
    }
    public static double CalculateSave(int normalCode,int HuffmanCode){
        double result = ((double)normalCode-(double)HuffmanCode)/(double)normalCode;
        
        return result*100;
    }

}

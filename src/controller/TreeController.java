package controller;

import model.HuffmanNode;
import model.HuffmanTree;

import java.util.ArrayList;
import java.util.HashMap;

public class TreeController {

    static public HuffmanTree buildTree(HashMap<Integer, Integer> symbolFrequency){

        createSheets(symbolFrequency);
        return null;

    }

    static private ArrayList<HuffmanNode> createSheets(HashMap<Integer, Integer> symbolFrequency){
        ArrayList<HuffmanNode> sheets = new ArrayList<HuffmanNode>();

        for(Integer symbol : symbolFrequency.keySet()){
            int frequency = symbolFrequency.get(symbol);
            String symbolCharacter = String.valueOf((char) symbol.byteValue());
            sheets.add(new HuffmanNode(symbolCharacter, frequency));
        }

        for(HuffmanNode hn : sheets){
            System.out.println("Symbol: " + hn.getSymbols() + " - Frequency: " + hn.getFrequency());
        }

        return null;
    }

}

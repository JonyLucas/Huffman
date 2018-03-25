package controller;

import model.HuffmanNode;
import model.HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TreeBuilder {

    static public HuffmanTree buildTree(HashMap<Integer, Integer> symbolFrequency){

        ArrayList<HuffmanNode> sheets = createSheets(symbolFrequency);
        HuffmanNode root = createParents(sheets);
        return new HuffmanTree(root);

    }

    static private ArrayList<HuffmanNode> createSheets(HashMap<Integer, Integer> symbolFrequency){
        ArrayList<HuffmanNode> sheets = new ArrayList<HuffmanNode>();

        for(Integer symbol : symbolFrequency.keySet()){
            int frequency = symbolFrequency.get(symbol);
            String symbolCharacter = String.valueOf((char) symbol.byteValue());
            sheets.add(new HuffmanNode(symbolCharacter, frequency));
        }

//        for(HuffmanNode hn : sheets){
//            System.out.println("Symbol: " + hn.getSymbols() + " - Frequency: " + hn.getFrequency());
//        }

        return sheets;
    }

    static private HuffmanNode createParents(ArrayList<HuffmanNode> huffmanNodes){
        int size = huffmanNodes.size();
        HuffmanNode parentNode = null;

        for(int i = size-1; i > 1; i--){
            HuffmanNode rightSon = huffmanNodes.remove(i);
            HuffmanNode leftSon = huffmanNodes.remove(i-1);

            parentNode = new HuffmanNode(rightSon, leftSon);
            huffmanNodes.add(parentNode);
            Collections.sort(huffmanNodes, Collections.reverseOrder());

//            for(HuffmanNode hn : huffmanNodes){
//                System.out.println(i + "- Symbols: " + hn.getSymbols() + " - Frequencies: " + hn.getFrequency());
//            }
//            System.out.println();

        }

        return parentNode;
    }

}

package controller;

import infra.HuffmanReader;
import model.HuffmanTree;

import java.util.HashMap;

public class HuffmanEncoder {

    private String code = "";
    private HuffmanReader huffmanReader;
    private HuffmanTree currentTree;
    private HashMap <Integer, Integer> currentFrequency = new HashMap<Integer,Integer>();

    public HuffmanEncoder(String filePath, HashMap<Integer, Integer> frequency){
        huffmanReader = new HuffmanReader(filePath);
        currentFrequency = frequency;
    }

    public void readAndDecrement()
    {
        try{
            int currentValue = huffmanReader.nextByte();
            while (currentValue != -1)
            {
                System.out.println("Current character: " + (char) currentValue);
                buildAndCodify(currentValue);
                decrement(currentValue);
                currentValue = huffmanReader.nextByte();
            }
            huffmanReader.close();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private void buildAndCodify(int currentValue){
        currentTree = TreeBuilder.buildTree(currentFrequency);
        String symbol = String.valueOf((char) currentValue);
        code += currentTree.codifySymbol(symbol, "");
        System.out.println("code: " + code + "\n");
    }

    private void decrement(int value){
        int count = currentFrequency.get(value);
        if(count == 1)
            currentFrequency.remove(value);
        else
            currentFrequency.put(value, count-1);
    }

    public String getCode(){ return code; }

}

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
    }

    private void decrement(int value){
        int count = currentFrequency.get(value);
        currentFrequency.put(value, count-1);
        System.out.println(currentFrequency);
    }

    public String getCode(){ return code; }

}

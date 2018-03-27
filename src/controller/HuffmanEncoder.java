package controller;

import infra.HuffmanReader;
import model.HuffmanTree;

import java.util.HashMap;

public class HuffmanEncoder {

    private String code = "";
    private HuffmanReader huffmanReader;
    private HuffmanTree currentTree;
    private HashMap <Integer, Integer> currentFrequency = new HashMap<>();

    public HuffmanEncoder(String filePath, HashMap<Integer, Integer> frequency){
        huffmanReader = new HuffmanReader(filePath);
        currentFrequency = new HashMap<>(frequency);
    }

    public void readAndDecrement()
    {
        try{
            int currentValue = huffmanReader.nextByte();
            while (currentValue != 300)
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
        code += currentTree.codifySymbol(currentValue, "");
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

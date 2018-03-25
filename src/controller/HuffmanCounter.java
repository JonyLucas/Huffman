package controller;

import infra.HuffmanReader;

import java.util.HashMap;

public class HuffmanCounter
{
    private HuffmanReader huffmanReader;
    private HashMap <Integer, Integer> frenquency = new HashMap<Integer,Integer>();
    public HuffmanCounter(String filePath)
    {
        huffmanReader = new HuffmanReader(filePath);
    }

    public void readAndCount()
    {
        try{
            int value = huffmanReader.nextByte();

            while (value != -1)
            {
                int count = (frenquency.get(value) == null) ? 1 : (frenquency.get(value)+1);
                frenquency.put(value, count);
                value = huffmanReader.nextByte();
            }
            huffmanReader.close();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public void showFrequency(){ System.out.println(frenquency); }

    public HashMap<Integer, Integer> getFrenquency() { return frenquency; }
}

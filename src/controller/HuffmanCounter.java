package controller;

import infra.HuffmanReader;

import java.util.HashMap;

public class HuffmanCounter
{
    private HuffmanReader huffmanReader;
    private HashMap <Integer, Integer> frequency = new HashMap<Integer,Integer>();
    public HuffmanCounter(String filePath)
    {
        huffmanReader = new HuffmanReader(filePath);
    }

    public void readAndCount()
    {
        try{
            int value = huffmanReader.nextByte();

            while (value != 300)
            {
                //System.out.println("Byte: " + value);
                int count = (frequency.get(value) == null) ? 1 : (frequency.get(value)+1);
                frequency.put(value, count);
                value = huffmanReader.nextByte();
            }

            System.out.println(frequency);

            huffmanReader.close();
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    public void showFrequency(){ System.out.println(frequency); }

    public HashMap<Integer, Integer> getFrequency() { return frequency; }
}

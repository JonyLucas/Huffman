package huffman;

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

    public void readAllFile()
    {
        try{
            int value = huffmanReader.nextByte();

            while (value != -1)
            {
                frequencyCounter(value);
                value = huffmanReader.nextByte();
            }
        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }

    private void frequencyCounter(int value){
        int count = frenquency.get(value) == null ? 1 : frenquency.get(value)+1;
        frenquency.put(value, count);
    }

    public void showFrequency(){
        System.out.println(frenquency);
    }

    public HashMap<Integer, Integer> getFrenquency() {
        return frenquency;
    }
}

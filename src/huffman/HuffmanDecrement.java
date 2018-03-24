package huffman;

import infra.HuffmanReader;

import java.util.HashMap;

public class HuffmanDecrement
{
    private HuffmanReader huffmanReader;
    private int frequencies[];
    private HashMap <Integer, Integer> frenquency = new HashMap<Integer,Integer>();
    public HuffmanDecrement(String filePath)
    {
        huffmanReader = new HuffmanReader(filePath);
    }

    public void run()
    {
        frequencies = new int[256];
        getAllFrequencies();

    }

    private void getAllFrequencies()
    {
        try{
            int value = huffmanReader.nextByte();

            while (value != -1)
            {
                frequencies[value]++;
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
        System.out.println(frenquency);
    }

    public void showFrequencies()
    {
        for(int i = 0; i < 256; i++)
        {
            System.out.println("Char: " + i + " Frequencia: " + frequencies[i]);
        }
    }


}

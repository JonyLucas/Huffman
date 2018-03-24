import huffman.HuffmanDecrement;

import java.io.File;

public class Main
{
    public static void main (String args[])
    {
        HuffmanDecrement huffmanDecrement = new HuffmanDecrement("C:\\Users\\Joao\\IdeaProjects\\Huffman\\src\\examples\\file.txt");
        huffmanDecrement.run();
//        huffmanDecrement.showFrequency();
    }

}

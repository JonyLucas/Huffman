import controller.TreeBuilder;
import controller.HuffmanCounter;

public class Main
{
    public static void main (String args[])
    {
        HuffmanCounter huffmanCounter = new HuffmanCounter("C:\\Users\\Joao\\IdeaProjects\\Huffman\\src\\examples\\file.txt");
        huffmanCounter.readAllFile();

        TreeBuilder.buildTree(huffmanCounter.getFrenquency());
//      huffmanDecrement.showFrequency();
    }

}

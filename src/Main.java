import controller.TreeController;
import huffman.HuffmanCounter;

public class Main
{
    public static void main (String args[])
    {
        HuffmanCounter huffmanCounter = new HuffmanCounter("C:\\Users\\Joao\\IdeaProjects\\Huffman\\src\\examples\\file.txt");
        huffmanCounter.readAllFile();

        TreeController.buildTree(huffmanCounter.getFrenquency());
//      huffmanDecrement.showFrequency();
    }

}

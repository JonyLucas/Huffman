import controller.HuffmanEncoder;
import controller.HuffmanCounter;
import infra.HuffmanWriter;

import javax.swing.*;

public class Main
{
    public static void main (String args[])
    {
        String fileInputPath = JOptionPane.showInputDialog("File Input Path:");//"src\\examples\\imagem1.png";
        String fileOutputPath = "src\\examples\\resultEncoder";

        HuffmanCounter huffmanCounter = new HuffmanCounter(fileInputPath);
        huffmanCounter.readAndCount();

        HuffmanEncoder huffmanEncoder = new HuffmanEncoder(fileInputPath, huffmanCounter.getFrequency());
        huffmanEncoder.readAndDecrement();

        new HuffmanWriter().saveFile(fileOutputPath, huffmanCounter.getFrequency(), huffmanEncoder.getCode());

    }

}

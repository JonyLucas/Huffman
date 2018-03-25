package model;

import java.util.ArrayList;

public class HuffmanNode implements Comparable<HuffmanNode>{

    private HuffmanNode leftSon, rightSon;
    private int frequencySum = 0;
    private ArrayList<String> symbols = new ArrayList<String>();


    public HuffmanNode(HuffmanNode rightSon, HuffmanNode leftSon){
        this.leftSon = leftSon;
        this.rightSon = rightSon;
        frequencySum = leftSon.getFrequency() + rightSon.getFrequency();
        symbols.addAll(leftSon.getSymbols());
        symbols.addAll(rightSon.getSymbols());
    }

    public HuffmanNode(String symbol, int frequency) {
        symbols.add(symbol);
        frequencySum = frequency;
    }

    public int getFrequency(){ return this.frequencySum; }

    public ArrayList<String> getSymbols() { return symbols; }

    public HuffmanNode getLeftSon() { return leftSon; }

    public HuffmanNode getRightSon() { return rightSon; }

    public boolean hasSymbol(String symbol){ return symbols.contains(symbol); }

    @Override
    public int compareTo(HuffmanNode node) {
        if(this.getFrequency() > node.getFrequency())
            return 1;
        else if(this.getFrequency() < node.getFrequency())
            return -1;
        else
            return 0;
    }
}

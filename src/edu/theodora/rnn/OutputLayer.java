package edu.theodora.rnn;

import java.util.ArrayList;
import java.util.Arrays;


public class OutputLayer extends Layer{
	
	public OutputLayer initLayer(OutputLayer outputLayer){
	ArrayList<Double> listaPonderiOutTemp = new ArrayList<Double>();
	ArrayList<Neuron> listaNeuroni = new ArrayList<Neuron>();
	
	for(int i=0; i< outputLayer.getNrNeuroniLayer(); i++){
		Neuron neuron = new Neuron();
		listaPonderiOutTemp.add(neuron.initNeuron());
		neuron.setListaPonderiOut(listaPonderiOutTemp);
		listaNeuroni.add(neuron);
		listaPonderiOutTemp = new ArrayList<Double>();
	}
	outputLayer.setListaNeuroni(listaNeuroni);
	return outputLayer;
}
	public void printLayer(OutputLayer outputLayer){
	       System.out.println("*** Output Layer *** ");
	       int n = 1;
	       for(Neuron neuron : outputLayer.getListaNeuroni()){
	    	   System.out.println("Neuron nr. " + n + ":");
	    	   System.out.println("Ponderi intrare: ");
	    	  // if(neuron.getListaPonderiOut() == null){
	    		//   System.out.println("Aici e problema!!!");
	    	   //} else
    			//   System.out.println("Hai ca poate am rezolvat");
	    	  System.out.println(Arrays.deepToString( neuron.getListaPonderiOut().toArray() ));
	    	   n++;
	       }
		}
}
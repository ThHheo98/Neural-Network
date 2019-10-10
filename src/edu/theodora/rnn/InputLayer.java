package edu.theodora.rnn;

import java.util.ArrayList;
import java.util.Arrays;

public class InputLayer extends Layer {

	public InputLayer initLayer(InputLayer inputLayer){
		ArrayList<Double> listaPonderiInTemp = new ArrayList<Double>();
		ArrayList<Neuron> listaNeuroni = new ArrayList<Neuron>();
		for(int i=0; i< inputLayer.getNrNeuroniLayer(); i++){
			Neuron neuron = new Neuron();
			listaPonderiInTemp.add(neuron.initNeuron());
			neuron.setListaPonderiIn(listaPonderiInTemp);
			listaNeuroni.add(neuron);
			listaPonderiInTemp = new ArrayList<Double>();
		}
		inputLayer.setListaNeuroni(listaNeuroni);
		return inputLayer;
	}
	
	public void printLayer(InputLayer inputLayer){
       
		System.out.println("*** Input Layer *** ");
       int n = 1;
       for(Neuron neuron : inputLayer.getListaNeuroni()){
    	   System.out.println("Neuron nr. " + n + ":");
    	   System.out.println("Ponderi intrare: ");
    	   System.out.println(Arrays.deepToString(neuron.getListaPonderiIn().toArray()));
    	   n++;
       }
	}
	
	//rescriu setNrNeuroniLayer pt introducere bias
	public void setNrNeuroniLayer(int nr){
		this.nrNeuroniLayer = nr + 1; //acesta e BIAS!!
	}
}

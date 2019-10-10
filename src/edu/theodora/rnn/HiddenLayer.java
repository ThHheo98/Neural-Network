package edu.theodora.rnn;

import java.util.ArrayList;
import java.util.Arrays;

public class HiddenLayer extends Layer {

	public ArrayList<HiddenLayer> initLayer(HiddenLayer hiddenLayer, ArrayList<HiddenLayer> listaHiddenLayer, InputLayer inputLayer, OutputLayer outputLayer){
		ArrayList<Double> listaPonderiIn = new ArrayList<Double>();
		ArrayList<Double> listaPonderiOut = new ArrayList<Double>();
		ArrayList<Neuron> listaNeuroni = new ArrayList<Neuron>();
		int nrHiddenLayer = listaHiddenLayer.size();
		
		for(int i = 0; i < nrHiddenLayer; i++){
			for(int j = 0; j < hiddenLayer.getNrNeuroniLayer(); j++){
				Neuron neuron = new Neuron();
				int limitaIn;
				int limitaOut;
				if(i==0){//primul
					limitaIn = inputLayer.getNrNeuroniLayer();
					if(nrHiddenLayer > 1){
						limitaOut = listaHiddenLayer.get(i+1).getNrNeuroniLayer();
					}else{
						limitaOut = listaHiddenLayer.get(i).getNrNeuroniLayer();
					}
				} else if(i == nrHiddenLayer - 1){//ultimul
					limitaIn = listaHiddenLayer.get(i-1).getNrNeuroniLayer();
					limitaOut = outputLayer.getNrNeuroniLayer();
				}else{//mijloc
					limitaIn = listaHiddenLayer.get(i-1).getNrNeuroniLayer();
					limitaOut = listaHiddenLayer.get(i+1).getNrNeuroniLayer();
				}
				for(int k = 0; k < limitaIn; k++){
					listaPonderiIn.add(neuron.initNeuron());
				}
				for(int k = 0; k < limitaOut; k++){
					listaPonderiOut.add(neuron.initNeuron());
				}
				neuron.setListaPonderiIn(listaPonderiIn);
				neuron.setListaPonderiOut(listaPonderiOut);
				listaNeuroni.add(neuron);
				
				listaPonderiIn = new ArrayList<Double>();
				listaPonderiOut = new ArrayList<Double>();
				
		}
		
		listaHiddenLayer.get(i).setListaNeuroni(listaNeuroni);
		listaNeuroni = new ArrayList<Neuron>(); //creeaza lista neuroni pt urmatoarea iteratie
	}
		return listaHiddenLayer;
	}
	
	public void printLayer(ArrayList<HiddenLayer> listaHiddenLayer){
		if(listaHiddenLayer.size() > 0){
			System.out.println("***Hidden Layer***");
			int h = 1;
			for (HiddenLayer hiddenLayer : listaHiddenLayer){
				System.out.println("Hidden Layer: " + h);
				int n = 1;
				//if (hiddenLayer.getListaNeuroni() == null){
				//	System.out.println("Lucreaza aici!");		
				//}else System.out.println("Ai gasit!");
				for (Neuron neuron : hiddenLayer.getListaNeuroni()){
					System.out.println("Neuron: " + n);
					System.out.println("Ponderi intrare: ");
					System.out.println(Arrays.deepToString(neuron.getListaPonderiIn().toArray()));
					System.out.println("Ponderi iesire: ");
					System.out.println(Arrays.deepToString(neuron.getListaPonderiOut().toArray()));
					n++;
				}
				h++;
			}
			
		}
	}
	
	public void setNrNeuroniLayer(int nr){
		this.nrNeuroniLayer = nr + 1; //acesta e BIAS!!
	}
}	

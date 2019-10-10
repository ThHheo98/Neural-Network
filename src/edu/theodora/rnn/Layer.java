package edu.theodora.rnn;

import java.util.ArrayList;

public abstract class Layer {
	private ArrayList<Neuron> listaNeuroni;
	protected int nrNeuroniLayer;
	
	public void printLayer(){
	}
	
	public ArrayList<Neuron> getListaNeuroni(){
		return listaNeuroni;
	}
	
	public void setListaNeuroni(ArrayList<Neuron> _lista){
		this.listaNeuroni = _lista;
	}
	
	public int getNrNeuroniLayer(){
		return nrNeuroniLayer;
	}
	
	public void setNrNeuroniLayer(int nr){
		this.nrNeuroniLayer = nr;
	}
}

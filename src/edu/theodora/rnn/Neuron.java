package edu.theodora.rnn;

import java.util.ArrayList;
import java.util.Random;

public class Neuron {

	private ArrayList<Double> listaPonderiIn;
	private ArrayList<Double> listaPonderiOut;
	
	public double initNeuron(){
		Random r = new Random();
		return r.nextDouble();
	}
	
	public ArrayList<Double> getListaPonderiIn(){
		return listaPonderiIn;
	}
	
	public void setListaPonderiIn(ArrayList<Double> _lista){
		this.listaPonderiIn = _lista;
	}
	
	public ArrayList<Double> getListaPonderiOut(){
		return listaPonderiOut;
	}
	
	public void setListaPonderiOut(ArrayList<Double> _lista){
		this.listaPonderiOut = _lista;
	}
	
}

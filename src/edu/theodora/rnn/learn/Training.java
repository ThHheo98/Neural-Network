package edu.theodora.rnn.learn;

import java.util.ArrayList;

import edu.theodora.rnn.NeuralNetwork;
import edu.theodora.rnn.Neuron;

public class Training {
	private int epoci;
	private double eroare;
	private double emp; // eroare patratica medie
	
	public enum TipuriTrainingENUM {
		PERCEPTRON, ADALINE
	}
	
	
	
	public NeuralNetwork train (NeuralNetwork nn){
		ArrayList<Double> ponderiInputIn = new ArrayList<Double>();
		
		return nn;
	}
	
	private ArrayList<Neuron> teachNeuronLayer(int nrInputNeuron, int linie, NeuralNetwork nn, double netVal){
		ArrayList<Neuron> listaNeuroni = new ArrayList<Neuron>();
		
		return listaNeuroni;
	}
	
	private double calcPondereNoua(TipuriTrainingENUM trainTip, double intPondVeche, NeuralNetwork nn,
								    double eroare, double trainSample, double netVal){
		switch(trainTip){
			case PERCEPTRON: 
				return intPondVeche + nn.getLearningRate()*eroare*trainSample;
			case ADALINE:
				return intPondVeche + nn.getLearningRate()*eroare*trainSample
						*derivataFncActivare(nn.getFncActivare(), netVal);
			default: 
				throw new IllegalArgumentException(trainTip + "NU EXISTA IN ENUMERAREA TipuriTrainingENUM");
		}
	}
	
	public enum fncActivareENUM {
		STEP, LINEAR, SIGLOG, HYPERTAN
	}
	
	private double fncActivare(fncActivareENUM fnc, double val){
		switch (fnc){
		case STEP: 
			return fncStep(val);
		case LINEAR:
			return fncLinear(val);
		case SIGLOG:
			return fncSigLog(val);
		case HYPERTAN:
			return fncHyperTan(val);
		default:
			throw new IllegalArgumentException(fnc + "NU EXISTA IN ENUMERAREA fncActivareENUM!!!");
		}
	}

	private double derivataFncActivare(fncActivareENUM fncActivare, double val) {
		switch( fncActivare ){
		case LINEAR:
			return derivFncLinear(val);
		case SIGLOG:
			return derivFncSigLog(val);
		case HYPERTAN:
			return derivFncHyperTan(val);
		default:
			throw new IllegalArgumentException(fncActivare + "NU EXISTA IN ENUMERAREA fncActivareENUM!!!");
		}
		
	}
	
	private double derivFncHyperTan(double val) {
		return 1.0 / Math.pow(Math.cosh(val), 2.0);
	}

	private double derivFncSigLog(double val) {
		return val*(1.0 - val);
	}

	private double derivFncLinear(double val) {
		return 1.0;
	}

	private double fncStep(double val) {
		if (val < 0){
			return 0.0;
			}else {
			return 1.0;}
	}
	
	private double fncLinear(double val){
		return val;
	}
	
	private double fncSigLog(double val){
		return 1.0/(1.0 + Math.exp(-val));
	}
	
	private double fncHyperTan(double val){
		return Math.tanh(val);
	}
	
	public void prinResultNetTrain(NeuralNetwork trainedNet){
		int linii = trainedNet.getTrainSet().length;
		int coloane = trainedNet.getTrainSet()[0].length;
		ArrayList<Double> inputPonderiIn = new ArrayList<Double>();
		
		for(int i = 0; i < linii; i++){
			double netVal = 0.0;
			for(int j = 0; j < coloane; j++){
				inputPonderiIn = trainedNet.getInputLayer().getListaNeuroni().get(j).getListaPonderiIn();
				double inputPonderi = inputPonderiIn.get(0);
				netVal = netVal + inputPonderi*trainedNet.getTrainSet()[i][j];
				System.out.print(trainedNet.getTrainSet()[i][j] + "\t");
			}
			double estimareIesire = this.fncActivare(trainedNet.getFncActivare(), netVal);
			System.out.print("Iesire neta: " + estimareIesire + "\t");
			System.out.print("Iesire real: " + trainedNet.getRealOutputSet()[i] + "\t");
			double eroare = estimareIesire - trainedNet.getRealOutputSet()[i];
			System.out.print("Eroare: " + eroare + "\n");
		}
	
		
		
	}
	
	private double getEroare(){
		return eroare;
	}
	
	private void setEroare(double e){
		eroare = e;
	}
	
	private int getEpoci(){
		return epoci;
	}
	
	private void setEpoci(int ep){
		epoci = ep;
	}
	
	private double getEmp(){
		return emp;
	}
	
	private void setEmp(double err){
		emp = err;
	}
}

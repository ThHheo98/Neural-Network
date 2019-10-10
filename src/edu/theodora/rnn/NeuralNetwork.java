package edu.theodora.rnn;

import java.util.ArrayList;

import edu.theodora.rnn.learn.Adaline;
import edu.theodora.rnn.learn.Perceptron;
import edu.theodora.rnn.learn.Training.TipuriTrainingENUM;
import edu.theodora.rnn.learn.Training.fncActivareENUM;

public class NeuralNetwork {

	private InputLayer inputLayer;
	private OutputLayer outputLayer;
	private HiddenLayer hiddenLayer;
	private ArrayList<HiddenLayer> listaHiddenLayer;
	private int nrHiddenLayers;
	
	//campuri noi
	private double[][] trainSet;
	private double[] realOutputSet;
	private int maxEpoci;
	private double learningRate;
	private double targetError;
	private double trainingError;
	private fncActivareENUM fncActivare;
	private TipuriTrainingENUM trainTip;
	private ArrayList<Double> listaEPM = new ArrayList<Double>();
	
	
	public NeuralNetwork initNet(int nrNeuroniInputLayer, int nrHiddenLayers, int nrNeuroniHiddenLayer, int nrNeuroniOutputLayer){
		inputLayer = new InputLayer();
		inputLayer.setNrNeuroniLayer(nrNeuroniInputLayer);
		
		listaHiddenLayer = new ArrayList<HiddenLayer>();
		for(int i = 0; i < nrHiddenLayers; i++){
			hiddenLayer = new HiddenLayer();
			hiddenLayer.setNrNeuroniLayer( nrNeuroniHiddenLayer );
			listaHiddenLayer.add( hiddenLayer );
		}
		
		outputLayer = new OutputLayer();
		outputLayer.setNrNeuroniLayer(nrNeuroniOutputLayer);
		
		inputLayer = inputLayer.initLayer(inputLayer);
		if(nrHiddenLayers > 0){
			listaHiddenLayer = hiddenLayer.initLayer(hiddenLayer, listaHiddenLayer, inputLayer, outputLayer);
		}
		outputLayer = outputLayer.initLayer(outputLayer);
		
		NeuralNetwork neurNet = new NeuralNetwork();
		
		neurNet.setInputLayer(inputLayer);
		neurNet.setHiddenLayer(hiddenLayer);
		neurNet.setListaHiddenLayer(listaHiddenLayer);
		neurNet.setNrHiddenLayer(nrHiddenLayers);
		neurNet.setOutputLayer(outputLayer);
		
		return neurNet;
	}
	
	public void printNet(NeuralNetwork nn){
		inputLayer.printLayer(nn.getInputLayer());
		System.out.println();
		if(nn.getHiddenLayer() != null){
			hiddenLayer.printLayer(nn.getListaHiddenLayer());
			System.out.println();
		}
		outputLayer.printLayer(nn.getOutputLayer());
	}
	
	//nou
	
	public NeuralNetwork trainNet(NeuralNetwork nn){
		NeuralNetwork nnTrained = new NeuralNetwork();
		switch(nn.trainTip){
		case PERCEPTRON:
			Perceptron p = new Perceptron();
			nnTrained = p.train(nn);
			return nnTrained;
		case ADALINE:
			Adaline a = new Adaline();
			nnTrained = a.train(nn);
			return nnTrained;
		default:
			throw new IllegalArgumentException(nn.trainTip + " NU EXISTA IN ENUMERAREA tipuriTrainingENUM!!!");
		}
	}
	
	public void printResultNetTrain(NeuralNetwork nn){
		switch(nn.trainTip){
		case PERCEPTRON:
			Perceptron p = new Perceptron();
			p.prinResultNetTrain(nn);
			break;
		case ADALINE:
			Adaline a = new Adaline();
			a.prinResultNetTrain(nn);
			break;
		default:
			throw new IllegalArgumentException(nn.trainTip + " NU EXISTA IN ENUMERAREA tipuriTrainingENUM!!!");
		}
	}
	
	public InputLayer getInputLayer(){
		return inputLayer;
	}
	
	public void setInputLayer(InputLayer il){
		this.inputLayer = il;
	}
	
	public OutputLayer getOutputLayer(){
		return outputLayer;
	}
	
	public void setOutputLayer(OutputLayer ol){
		this.outputLayer = ol;
	}
	
	public HiddenLayer getHiddenLayer(){
		return hiddenLayer;
	}
	
	public void setHiddenLayer(HiddenLayer hl){
		this.hiddenLayer = hl;
	}
	
	public ArrayList<HiddenLayer> getListaHiddenLayer(){
		return listaHiddenLayer;
	}
	
	public void setListaHiddenLayer(ArrayList<HiddenLayer> lhl){
		this.listaHiddenLayer = lhl;
	}
	
	public int getNrHiddenLayer(){
		return nrHiddenLayers;
	}
	
	public void setNrHiddenLayer(int nr){
		this.nrHiddenLayers = nr;
	}
	
	//metode noi
	public double getLearningRate() {
		return learningRate;
	}
	
	public void setLearningRate(double lr){
		this.learningRate = lr;
	}
	
	public double[][] getTrainSet(){
		return trainSet;
	}
	
	public void setTrainSet(double[][] ts){
		this.trainSet = ts;
	}
	
	public double[] getRealOutputSet(){
		return realOutputSet;
	}
	
	public void setRealOutputSet(double[] ros){
		this.realOutputSet = ros;
	}
	
	public int getMaxEpoci(){
		return maxEpoci;
	}
	
	public void setMaxEpoci(int me){
		this.maxEpoci = me;
	}
	
	public double getTargetError(){
		return targetError;
	}
	
	public void setTargetError(double te){
		this.targetError = te;
	}
	
	public double getTrainingError(){
		return trainingError;
	}
	
	public void setTrainingError(double t){
		this.trainingError = t;
	}
	
	public fncActivareENUM getFncActivare(){
		return fncActivare;
	}
	
	public void setFncActivare(fncActivareENUM fa){
		this.fncActivare = fa;
	}
	
	public TipuriTrainingENUM getTipTraining(){
		return trainTip;
	}
	
	public void setTipTraining(TipuriTrainingENUM tt){
		this.trainTip = tt;
	}
	
	public ArrayList<Double> getListaEPM(){
		return listaEPM;
	}
	
	public void setListaEPM(ArrayList<Double> lista){
		this.listaEPM = lista;
	}
}

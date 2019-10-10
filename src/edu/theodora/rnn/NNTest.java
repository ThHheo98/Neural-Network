package edu.theodora.rnn;

public class NNTest {

	public static void main(String[] args) {
	
	 NeuralNetwork nntest = new NeuralNetwork();
	 nntest= nntest.initNet(2, 1, 1, 1);
	 nntest.printNet(nntest);
	}

}

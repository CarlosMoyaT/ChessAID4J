//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.deeplearning4j.optimize.api.TrainingListener;
import org.deeplearning4j.optimize.listeners.ScoreIterationListener;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.learning.config.Adam;

public class ChessModel {
    public ChessModel() {
    }

    public MultiLayerNetwork createModel(int inputSize, int outputSize) {
        MultiLayerConfiguration config = (new NeuralNetConfiguration.Builder()).seed(123L).optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT).updater(new Adam(0.001)).list().layer(((DenseLayer.Builder)((DenseLayer.Builder)((DenseLayer.Builder)(new DenseLayer.Builder()).nIn(inputSize)).nOut(128)).activation(Activation.RELU)).build()).layer(((DenseLayer.Builder)((DenseLayer.Builder)((DenseLayer.Builder)(new DenseLayer.Builder()).nIn(128)).nOut(64)).activation(Activation.RELU)).build()).layer(((DenseLayer.Builder)((DenseLayer.Builder)((DenseLayer.Builder)(new DenseLayer.Builder()).nIn(64)).nOut(outputSize)).activation(Activation.SOFTMAX)).build()).build();
        MultiLayerNetwork model = new MultiLayerNetwork(config);
        model.init();
        model.setListeners(new TrainingListener[]{new ScoreIterationListener(10)});
        return model;
    }

    public void trainModel(MultiLayerNetwork model, DataSet trainingData, int epochs) {
        for(int i = 0; i < epochs; ++i) {
            model.fit(trainingData);
        }

    }

    public static void main(String[] args) {
        ChessDataProcessor dataProcessor = new ChessDataProcessor();
        String jsonData = "";
        DataSet chessDataSet = dataProcessor.parseChessGmesData(jsonData);
        ChessModel chessModel = new ChessModel();
        MultiLayerNetwork model = chessModel.createModel(64, 3);
        chessModel.trainModel(model, chessDataSet, 100);
    }
}

package org.example;
import org.deeplearning4j.datasets.iterator.utilty.ListDataSetIterator;
import org.deeplearning4j.nn.api.OptimizationAlgorithm;
import org.deeplearning4j.nn.conf.MultiLayerConfiguration;
import org.deeplearning4j.nn.conf.NeuralNetConfiguration;
import org.deeplearning4j.nn.conf.layers.DenseLayer;
import org.deeplearning4j.nn.weights.WeightInit;
import org.nd4j.linalg.activations.Activation;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;
import org.nd4j.linalg.factory.Nd4j;
import org.nd4j.linalg.learning.config.Sgd;

import java.util.Arrays;
import java.util.List;


//Contiene un conjunto de neuronas




public class Layer {

    MultiLayerConfiguration conf = new NeuralNetConfiguration.Builder()
            .layer(0, new DenseLayer.Builder().nIn(784).nOut(250)
                    .weightInit(WeightInit.XAVIER)
                    .activation(Activation.RELU)
                    .build())
            .layer(1, new DenseLayer.Builder().nIn(250).nOut(10)
                    .weightInit(WeightInit.XAVIER)
                    .activation(Activation.IDENTITY)
                    .build())
            .weightInit(WeightInit.XAVIER)
            .activation(Activation.RELU)
            .optimizationAlgo(OptimizationAlgorithm.STOCHASTIC_GRADIENT_DESCENT)
            .updater(new Sgd(0.05))
            .list()
            .backprop(true)
            .build();

    // Crear el modelo
    org.deeplearning4j.nn.multilayer.MultiLayerNetwork model = new org.deeplearning4j.nn.multilayer.MultiLayerNetwork(conf);
        model.init();

    // Crear datos de ejemplo
    List<DataSet> data = Arrays.asList(
            new DataSet(Nd4j.create(new double[][]{{1.0, 2.0, 3.0, 4.0}}, new int[]{1, 4}),
                    Nd4j.create(new double[]{1.0}, new int[]{1, 1})),
            new DataSet(Nd4j.create(new double[][]{{4.0, 3.0, 2.0, 1.0}}, new int[]{1, 4}),
                    Nd4j.create(new double[]{0.0}, new int[]{1, 1}))
    );

    // Crear DataSetIterator
    DataSetIterator iterator = new ListDataSetIterator<>(data, 1);

    // Entrenar el modelo
        model.fit(iterator);

    // Realizar una predicción de ejemplo (reemplaza esto con una predicción real)
    org.nd4j.linalg.api.ndarray.INDArray output = model.output(Nd4j.create(new double[][]{{1.0, 2.0, 3.0, 4.0}}, new int[]{1, 4}));
        System.out.println("Predicción: " + output);
}






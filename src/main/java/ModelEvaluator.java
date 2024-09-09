//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import org.deeplearning4j.eval.Evaluation;
import org.deeplearning4j.nn.multilayer.MultiLayerNetwork;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.api.DataSet;
import org.nd4j.linalg.dataset.api.iterator.DataSetIterator;

public class ModelEvaluator {
    public ModelEvaluator() {
    }

    public void evaluateModel(MultiLayerNetwork model, DataSetIterator testData) {
        Evaluation eval = new Evaluation();

        while(testData.hasNext()) {
            DataSet next = (DataSet)testData.next();
            INDArray output = model.output(next.getFeatures());
            eval.eval(next.getLabels(), output);
        }

        System.out.println(eval.stats());
    }
}

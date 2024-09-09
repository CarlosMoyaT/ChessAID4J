//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.nd4j.linalg.api.ndarray.INDArray;
import org.nd4j.linalg.dataset.DataSet;
import org.nd4j.linalg.factory.Nd4j;

public class ChessDataProcessor {
    private ObjectMapper objectMapper = new ObjectMapper();

    public ChessDataProcessor() {
    }

    public DataSet parseChessGmesData(String gamesDataJson) {
        try {
            JsonNode rootNode = this.objectMapper.readTree(gamesDataJson);
            List<INDArray> featuresList = new ArrayList();
            List<INDArray> labelsList = new ArrayList();
            Iterator var5 = rootNode.iterator();

            while(var5.hasNext()) {
                JsonNode gameNode = (JsonNode)var5.next();
                INDArray features = this.extractFeatures(gameNode);
                INDArray labels = this.extractLabels(gameNode);
                featuresList.add(features);
                labelsList.add(labels);
            }

            INDArray inputFeatures = Nd4j.vstack(featuresList);
            INDArray outputLabels = Nd4j.vstack(labelsList);
            return new DataSet(inputFeatures, outputLabels);
        } catch (Exception var9) {
            Exception e = var9;
            e.printStackTrace();
            return null;
        }
    }

    private INDArray extractFeatures(JsonNode gameNode) {
        return Nd4j.zeros(new int[]{1, 64});
    }

    private INDArray extractLabels(JsonNode gameNode) {
        return Nd4j.zeros(new int[]{1, 3});
    }
}

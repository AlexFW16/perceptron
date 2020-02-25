import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args){
        testPerceptron();
    }



    //Tests the perceptron algorithm with sample data from the "Iris Data-Set" | 1000 Training-Iterations
    private static void testPerceptron(){


        Perceptron pc = new Perceptron(0.05, 10, 4);

        ArrayList<double[]> trainingSet = DataUtil.getInputFromFile("data/iris.data", ",", true);
        ArrayList<double[]> testSet = DataUtil.getInputFromFile("data/predict.data", ",", false);


        for(int i = 0; i<1000; i++){
            trainingSet.forEach(pc::train);
            Collections.shuffle(trainingSet);
        }


        pc.showSpecifications();
        testSet.forEach(e-> System.out.println(pc.isPredictionRight(e)));


    }

}

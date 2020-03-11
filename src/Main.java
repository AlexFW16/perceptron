import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args){
        testPerceptron();
    }



    //Tests the perceptron algorithm with sample data from the "Iris Data-Set" | 1000 Training-Iterations
    private static void testPerceptron(){

        boolean train = true;

        Perceptron pc = new Perceptron(0.05, 0, 4);

        ArrayList<double[]> trainingSet = DataUtil.getInputFromFile("data/iris.data", ",", true);
        ArrayList<double[]> testSet = DataUtil.getInputFromFile("data/predict.data", ",", false);

        if(train){
            for(int i = 0; i<1000; i++){
                trainingSet.forEach(pc::train);
                Collections.shuffle(trainingSet);
            }
        }

        print(trainingSet, testSet, pc);


    }

    private static void print(ArrayList<double[]> trainingSet, ArrayList<double[]> testSet, Perceptron pc){

        int right = 0;

        for(int i = 0; i< testSet.size(); i++){

            if(pc.isPredictionRight(testSet.get(i)))
                right++;
        }
        System.out.println("-------------------------------------------------------------------------------------------------------------");
        System.out.println("Testdaten & Vorhersagen");
        System.out.println("              ");

        for(int i = 0; i<testSet.size(); i++){
            System.out.println(Arrays.toString(testSet.get(i)) + " Tatsächliche Klasse: " + testSet.get(i)[testSet.get(i).length-1]
                    + " | Vorhersage: " + (double) pc.predict(testSet.get(i)));

            }

        System.out.println("");
        System.out.println("--------------------");
        System.out.println(right + " von " + testSet.size() + " korrekt klassifiziert.");




    }
}

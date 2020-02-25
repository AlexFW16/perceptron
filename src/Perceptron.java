import java.util.ArrayList;
import java.util.Random;

public class Perceptron {

    private double learningRate;
    private double threshold;
    private double w_0; //Bias
    private ArrayList<Double> weights = new ArrayList<>();

    public void showSpecifications(){

        System.out.println("Lernrate: " + learningRate);
        System.out.println("Schwellenwert: " + threshold);
        System.out.println("Gewichtungen: " +  weights.toString());
        System.out.println("Bias: " + w_0);
    }

    public Perceptron(double learningRate, double threshold, int sample_length) {
        this.learningRate = learningRate;
        this.threshold = threshold;

        //Initializes the variables with random values between 0.0 and 1.0 | Sets bias to 1
        Random rnd = new Random();
        for(int i = 0; i<sample_length; i++){
            this.weights.add(rnd.nextDouble());
        }
        w_0 = 1;

    }

    //Returns true if the prediction was right | use supervised sample
    public boolean isPredictionRight(double[] sample) {

        return predict(sample) == sample[sample.length - 1];
    }
        //Appends the Heaviside function on the net_input to predict the classification
    public int predict(double[] sample){
       return heavisideFunction(net_input(sample));
    }

    //Learning-Algorithm
    public void train(double[] data){

        //Adjusts the bias
        w_0 += learningRate * (data[data.length - 1] - predict(data));

       for(int i = 0; i<weights.size(); i++){

           //Adjusts the weights
           double delta_w = learningRate * (data[data.length -1] - predict(data)) * data[i];
           weights.set(i, weights.get(i) + delta_w);
       }
    }


    //Calculates the net_input
    private double net_input(double[] sample){

        double sum = w_0;
        for(int i = 0; i<weights.size(); i++)
            sum += sample[i] * weights.get(i);

        return sum;
    }

    private int heavisideFunction(double x){
        return x < threshold ? 0 : 1;
    }
}

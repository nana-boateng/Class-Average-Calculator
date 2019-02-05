import java.util.ArrayList;
import java.util.Scanner;

class Average {

    private ArrayList<Double> marks = new ArrayList<>(1);
    private ArrayList<Double> weights = new ArrayList<>(1);


    Average(){

    }

    void setMarks(double num) throws IllegalAverage{
        if (num < 0){
            throw new IllegalAverage("Invalid mark");
        } else {
            marks.add(num);
            setWeights();
        }
    }

    private void setWeights() throws IllegalAverage {
        double sum = 0;
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter percentage weight: ");
        double num = keyboard.nextDouble();
        System.out.println(" ");
        for(double element: weights){
            sum += element;
        }
        if (sum+num > 100){
            throw new IllegalAverage("Weight sum greater than 100");
        } else {
            weights.add(num);
        }
    }
    void removeMark(int index){
        marks.remove(index);
        weights.remove(index);
    }

    ArrayList<Double> getMarks(){ return marks; }
    ArrayList<Double> getWeights(){ return weights; }

    double getCurrentAverage(ArrayList<Double> marks, ArrayList<Double> weights) throws IllegalAverage{
        double sum = 0;
        if (marks.size() != weights.size()){
            throw new IllegalAverage("Marks dont match up with weights");
        } else {
            for (int i = 0; i < marks.size(); i++) {
                sum += marks.get(i) * weights.get(i);
            }
        }
        return sum/getTotalWeights(weights);
    }

    double getTotalWeights(ArrayList<Double> weights){
        double sum = 0;
        for (Double weight : weights) {
            sum += weight;
        }
        return sum;
    }
}

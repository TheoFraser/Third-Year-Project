package ConnectX;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import RulesStrategies.Rules;
import RulesStrategies.Strategies;

public class Naive {
    Rules rules;
    Strategies strategies;
    boolean strategiesOn = false;
    Random random = new Random();
    int position;
    public Naive(){
        rules = new Rules(true, 5);
    }
    public Naive(ArrayList<Integer> strategyList){
        rules = new Rules(true, 5);
        strategies = new Strategies(strategyList);
        strategiesOn = true;
    }
    public int getMove(ConnectXBoard board, int lastPlaced){
        ArrayList<Integer> movesBefore = new ArrayList<>();
        for(int i = 0; i < board.width; i++){
            if(board.canPlace(i)){
                movesBefore.add(i);
            }
        }
        System.out.println("Moves before rules: " +  movesBefore);
        ArrayList<Integer> legalMoves = rules.getMoves(board);
        System.out.println("Moves after rules:  " + legalMoves);
        if(strategiesOn){
            ArrayList<Double> weightList = new ArrayList<>();
            // ArrayList<Double> temp = new ArrayList<>();
            for(int i = 0; i < legalMoves.size(); i++){
                weightList.add(strategies.applyStrategy(board, legalMoves.get(i), lastPlaced));
            }
            System.out.println(weightList);
            double maxWeight = Integer.MIN_VALUE; // Initialize with the smallest possible integer value
            List<Integer> maxIndices = new ArrayList<>(); // List to store indices with maximum weight
            for (int i = 0; i < weightList.size(); i++) {
                double weight = weightList.get(i);
                if (weight > maxWeight) {
                    maxWeight = weight;
                    maxIndices.clear(); // Clear previous maxIndices as we found a new maximum weight
                    maxIndices.add(i); // Add the current index to maxIndices
                } else if (weight == maxWeight) {
                    maxIndices.add(i); // Add the current index to maxIndices if it ties with maxWeight
                }
            }
            Random random = new Random();
            int randomIndex = maxIndices.get(random.nextInt(maxIndices.size()));
            position = legalMoves.get(randomIndex);
            // System.out.println(position);
            // double minNegative = Double.MAX_VALUE;
            // for (double weight : weightList) {
            //     if (weight < minNegative) {
            //         minNegative = weight;
            //     }
            // }
            // // Add the absolute value of the most negative number to all values in the list
            // double absMinNegative = Math.abs(minNegative) + 1;
            // for (int i = 0; i < weightList.size(); i++) {
            //     weightList.set(i, weightList.get(i) + absMinNegative);
            // }
            // // System.out.println(legalMoves);
            // // System.out.println("W " + weightList);
            // // System.out.println("KKKKK " + temp);
            // double totalWeight = weightList.stream().mapToDouble(Double::doubleValue).sum();
            // double randomNumber = random.nextDouble() * totalWeight;
            // // System.out.println(totalWeight);
            // // System.out.println(randomNumber);
            // for (int i = 0; i < weightList.size(); i++) {
            //     randomNumber -= weightList.get(i);
            //     if (randomNumber <= 0) {
            //         return legalMoves.get(i);
            //     }
            // }
        }
        else{
            int randomIndex = random.nextInt(legalMoves.size());
            position = legalMoves.get(randomIndex);
        }
        return position;
    }
}

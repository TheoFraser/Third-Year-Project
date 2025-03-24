package ConnectX;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import MCTs.MCTs;

public class Algorithm {
    public String playerOption;
    MCTs playerMCTs;
    Naive playerNaive;
    Scanner scanner = new Scanner(System.in);
    int iterations = 0;
    public ArrayList<Integer> strategies;
    public Algorithm(String playerOption, ArrayList<Double> parameters){
        this.playerOption = playerOption;
        if(playerOption.equalsIgnoreCase("NAIVE")){
            if(parameters.isEmpty()){
                playerNaive = new Naive();
            }
            else{
                strategies = new ArrayList<>();
                for (Double d : parameters) {
                    strategies.add(d.intValue()); // Convert Double to Integer
                }
                playerNaive = new Naive(strategies);
            }
        }
        if(playerOption.equalsIgnoreCase("MCTs")){
            // System.out.println(parameters);
            iterations = parameters.get(0).intValue();
            // System.out.println(iterations);
            if(parameters.size() == 1){
                playerMCTs = new MCTs(parameters.get(0).intValue(), 0);
            }
            else if(parameters.size() == 3){
                System.out.println("MCTS " + parameters.get(1).intValue());
                playerMCTs = new MCTs(parameters.get(0).intValue(), parameters.get(1).intValue(), parameters.get(2).intValue(), 0);
            }
            else if(parameters.size() > 3){
                strategies = new ArrayList<>();
                for(int i = 3; i < parameters.size(); i++){
                    strategies.add(parameters.get(i).intValue());
                }
                // System.out.println(strategies);
                // System.out.println(parameters.get(1).intValue());
                playerMCTs = new MCTs(parameters.get(0).intValue(), parameters.get(1).intValue(), parameters.get(2).intValue(), strategies, 0);
            }
        }
    }
    public int getMove(ConnectXBoard board, int lastPlaced){
        int position = 0;
        Random random = new Random();
        if(playerOption.equalsIgnoreCase("PERSON")){
            position = scanner.nextInt();
        }
        if(playerOption.equalsIgnoreCase("RAND")){
            position = random.nextInt(board.width);
            while(!board.canPlace(position)){
                position = random.nextInt(board.width);
            }
        }
        if(playerOption.equalsIgnoreCase("NAIVE")){
            position = playerNaive.getMove(board, lastPlaced);
        }
        if(playerOption.equalsIgnoreCase("MCTs")){
            position = playerMCTs.findBestMove(board, lastPlaced);
        }
        return position;
    }
}

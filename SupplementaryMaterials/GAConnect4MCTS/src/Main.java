package src;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Logger.MyLogger;
import ConnectX.Algorithm;
import ConnectX.ConnectX;
import ConnectX.Naive;
import MCTs.MCTs; 
import GA.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> stringValues;
        ArrayList<Double> doubleValues;
        HashMap<Integer,ArrayList<Double>> parameterDoubleValues;
        MyLogger logger = new MyLogger("");
        // MCTs player1MCTs = null;
        // MCTs player2MCTs = null;
        stringValues = new ArrayList<>();
        doubleValues = new ArrayList<>();
        parameterDoubleValues = new HashMap<>();
        int wordPosition = 0;
        for(int i = 0; i < args.length; i++){
            String word = args[i];
            parameterDoubleValues.put(wordPosition, new ArrayList<>());
            try {
                Double num = Double.parseDouble(word);
                doubleValues.add(num);
            } catch (Exception e) {
                if(word.contains("{")){
                    int startingIndex = word.indexOf("{") + 1;
                    stringValues.add(word.substring(0, startingIndex-1));
                    for(int j = startingIndex; j < word.length(); j++){
                        if(word.charAt(j) == ':'){
                            String parameter = word.substring(startingIndex, j);
                            try {
                                // System.out.println("P"+parameter);
                                Double num = Double.parseDouble(parameter);
                                parameterDoubleValues.get(wordPosition).add(num);
                            } catch (Exception exp) {
                            }
                            startingIndex = j + 1;
                        }
                        if(word.charAt(j) == '}'){
                            String parameter = word.substring(startingIndex, j);
                            try {
                                // System.out.println("P"+parameter);
                                Double num = Double.parseDouble(parameter);
                                parameterDoubleValues.get(wordPosition).add(num);
                            } catch (Exception exp) {
                            }
                        }
                    }
                }
                else{
                    stringValues.add(word);
                }
            }
            wordPosition = wordPosition + 1;
        }
        logger = new MyLogger(String.join(" ", args));
        if(stringValues.get(0).equalsIgnoreCase("connectX")){
            Algorithm player1Algorithm = new Algorithm(stringValues.get(1), parameterDoubleValues.get(1));
            Algorithm player2Algorithm = new Algorithm(stringValues.get(2), parameterDoubleValues.get(2));
            ConnectX connectX = new ConnectX(logger, stringValues.get(1), stringValues.get(2), player1Algorithm, player2Algorithm, doubleValues.get(0).intValue(), doubleValues.get(1).intValue() , doubleValues.get(2).intValue(), doubleValues.get(3).intValue());
            connectX.run();
        }
        if(stringValues.get(0).equalsIgnoreCase("GA")){
            System.out.println("LMAO");
            GeneticAlgorithm geneticAlgorithm = new GeneticAlgorithm(logger, stringValues.get(1), parameterDoubleValues.get(1), doubleValues.get(0).intValue(), doubleValues.get(1).intValue(), doubleValues.get(2).intValue(), doubleValues.get(3).intValue(), doubleValues.get(4).intValue(), doubleValues.get(5).intValue(), doubleValues.get(6).intValue());
            geneticAlgorithm.runGenetic();
        }
    }
}



        // if(!parameterDoubleValues.get(0).isEmpty()){

        // }
        // if(!parameterDoubleValues.get(0).isEmpty()){
        //     player1MCTs = new MCTs(Double.valueOf(parameterDoubleValues.get(0).get(0)).intValue(), doubleValues.get(3).intValue());
        //     if(parameterDoubleValues.get(0).size() > 1){
        //         if(parameterDoubleValues.get(0).size() > 2){
        //             player1MCTs.enableRules(parameterDoubleValues.get(0).get(1).intValue(), parameterDoubleValues.get(0).get(2).intValue());
        //         }
        //         else{
        //             player1MCTs.enableRules(parameterDoubleValues.get(0).get(1).intValue(), 0);
        //         }
        //     }
        //     // player1MCTs.setPlayerID(2);
        // }
        // if(!parameterDoubleValues.get(1).isEmpty()){
        //     player2MCTs = new MCTs(Double.valueOf(parameterDoubleValues.get(1).get(0)).intValue(), doubleValues.get(3).intValue());
        //     if(parameterDoubleValues.get(1).size() > 1){
        //         if(parameterDoubleValues.get(1).size() > 2){
        //             player2MCTs.enableRules(parameterDoubleValues.get(1).get(1).intValue(), parameterDoubleValues.get(1).get(2).intValue());
        //         }
        //         else{
        //             player2MCTs.enableRules(parameterDoubleValues.get(1).get(1).intValue(), 0);
        //         }
        //     }
        //     // player2MCTs.setPlayerID(-1);
        // }
        // logger = new MyLogger(String.join(" ", args));
        // if(stringValues.size() > 1){
        //     ConnectX connectX = new ConnectX(logger, stringValues.get(0), stringValues.get(1),player1MCTs, player2MCTs ,doubleValues.get(0).intValue(), doubleValues.get(1).intValue() , doubleValues.get(2).intValue(), doubleValues.get(3).intValue());
        //     connectX.run();
        // }
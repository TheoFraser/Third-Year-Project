package GA;
import MCTs.*;
import Logger.MyLogger;

import java.util.ArrayList;
import java.util.Random;

import javax.print.attribute.standard.MediaSize.NA;

import ConnectX.ConnectX;
import ConnectX.ConnectXBoard;
import ConnectX.Algorithm;


public class FitnessFunction {
    MyLogger logger;
    ArrayList<Algorithm> population;
    Algorithm chromosome;
    int numPlays;
    int gameMode;
    int log;
    int debug;
    int fitness;
    Random random;
    public FitnessFunction(MyLogger logger, ArrayList<Algorithm> population, Algorithm chromosome, int numPlays, int gameMode, int log, int debug){
        this.logger = logger;
        this.population = population;
        this.chromosome = chromosome;
        this.numPlays = numPlays;
        this.gameMode = gameMode;
        this.log = log;
        this.debug = debug;
    }
    public int runFitness(){
        random = new Random();
        // int player1Chromosome = 0;
        fitness = 0;
        // for(int i = 0; i < numPlays; i++){
        //     int populationIndex = random.nextInt(population.size());
        //     if(player1Chromosome == 0){
        //         ConnectX connectX = new ConnectX(logger, chromosome.playerOption, population.get(populationIndex).playerOption, chromosome, population.get(populationIndex), 1, gameMode, log, debug);
        //         connectX.run();
        //         if(connectX.connectXBoard.gameState() == 2){
        //             fitness = fitness + 3;
        //         }
        //         if(connectX.connectXBoard.gameState() == 3){
        //             fitness = fitness + 1;
        //         }
        //     }
        //     if(player1Chromosome == 0){
        //         ConnectX connectX = new ConnectX(logger, population.get(populationIndex).playerOption, chromosome.playerOption, population.get(populationIndex), chromosome, 1, gameMode, log, debug);
        //         connectX.run();
        //         if(connectX.connectXBoard.gameState() == -1){
        //             fitness = fitness + 3;
        //         }
        //         if(connectX.connectXBoard.gameState() == 3){
        //             fitness = fitness + 1;
        //         }
        //     }
        //     player1Chromosome = 1 - player1Chromosome;
        // }
        // for(int i = 0; i < 20; i++){
        for(int j = 0; j < 100; j ++){
            // ConnectX connectX = new ConnectX(logger, population.get(i).playerOption, chromosome.playerOption, population.get(i), chromosome, 1, gameMode, log, debug);
            ArrayList lmao = new ArrayList<Double>();
            lmao.add(1000.0);
            Algorithm MCTS =  new Algorithm("MCTS", lmao);
            ConnectX connectX = new ConnectX(logger, "MCTS", chromosome.playerOption, MCTS, chromosome, 1, gameMode, log, debug);
            connectX.run();
            if(connectX.connectXBoard.gameState() == -1){
                fitness = fitness + 3;
            }
            if(connectX.connectXBoard.gameState() == 3){
                fitness = fitness + 1;
            }
        }
        // }
        return fitness;
    }
}


// public int runMCTs(ArrayList<MCTs> population, MCTs chromosome){
//     Random random = new Random();
//     for(int i = 0; i < numPlays; i++){

//     }
//     return 1;
// }
// public int runNaive(ArrayList<Integer> population, Integer chromosome){
//     Random random = new Random();
//     int chromosomePlayerID = 0;
//     for(int i = 0; i < numPlays; i++){
//         ConnectX connectX = new ConnectX(logger, "NAIVE", "NAIVE", null, null, 1, gameMode, log ,debug);
//         if(chromosomePlayerID == 0){
//             connectX.setStrategies(chromosome, population.get(i));
//         }
//         if(chromosomePlayerID == 1){
//             connectX.setStrategies(population.get(i), chromosome);
//         }
//         connectX.run();
//         if(connectX.connectXBoard.gameState() == 3){
//             fitness = fitness + 1;
//         }
//         if(connectX.connectXBoard.gameState() == 2 && chromosomePlayerID == 0){
//             fitness = fitness + 1;
//         }
//         if(connectX.connectXBoard.gameState() == -1 && chromosomePlayerID == 1){
//             fitness = fitness + 3;
//         }
//         chromosomePlayerID = 1 - chromosomePlayerID;
//     }
//     return fitness;
// }








// import java.util.ArrayList;
// import java.util.Random;
// import MCTs.*;
// import Logger.MyLogger;
// import ConnectX.ConnectX;
// import ConnectX.ConnectXBoard;

// public class FitnessFunction {
//     int fitness;
//     ArrayList<MCTs> population;
//     MCTs chromosome;
//     int numPlays;
//     Random random;
//     MyLogger logger;
//     public FitnessFunction(ArrayList<MCTs> population, MCTs chromosome, int numPlays, MyLogger logger,int gameMode, int log, int debug){
//         this.population = population;
//         this.chromosome = chromosome;
//         this.numPlays = numPlays;
//         random = new Random();
//         int chromosomePlayerID = 0;
//         for(int i = 0; i < numPlays; i++){
//             // int chromosomePlayerID = random.nextInt(2);
//             if(chromosomePlayerID == 0){
//                 ConnectX connectX = new ConnectX(logger, "MCTs", "MCTs", chromosome, population.get(i), 1, gameMode, log ,debug);
//                 connectX.run();
//                 if(connectX.connectXBoard.gameState() == 2){
//                     fitness = fitness + 3;
//                 }
//                 if(connectX.connectXBoard.gameState() == 3){
//                     fitness = fitness + 1;
//                 }
//             }
//             if(chromosomePlayerID == 1){
//                 ConnectX connectX = new ConnectX(logger, "MCTs", "MCTs", population.get(i), chromosome, 1, gameMode, log,debug);
//                 connectX.run();
//                 if(connectX.connectXBoard.gameState() == -1){
//                     fitness = fitness + 3;
//                 }
//                 if(connectX.connectXBoard.gameState() == 3){
//                     fitness = fitness + 1;
//                 }
//             }
//             chromosomePlayerID = 1 - chromosomePlayerID;
//         }
//     }
//     public int getFitness(){
//         return fitness;
//     }
// }

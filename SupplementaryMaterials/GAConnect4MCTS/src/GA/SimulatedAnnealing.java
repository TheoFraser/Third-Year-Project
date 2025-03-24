// package GA;
// import java.util.ArrayList;
// import java.util.Random;

// import ConnectX.ConnectX;
// import Logger.MyLogger;
// import MCTs.MCTs;


// public class SimulatedAnnealing {
//     int iterations;
//     int numberOfStrategies;
//     int debug;
//     int iterationMCTs;
//     MyLogger logger;
//     int gameMode;
//     public int[] convertIntToBinary(int number){
//         int binaryValue[] = {0,0,0,0,0,0,0,0};
//         for(int i = 0; i < binaryValue.length; i++){
//             if((number & (1 << i)) == 1 << i){
//                 binaryValue[Math.abs(i - 7)] = 1;
//             }
//         }
//         return binaryValue;
//     }
//     public double connect4BinaryToInt(int strategy[]){
//         double strategyValue = 0;
//         for(int i = 0; i < strategy.length; i++){
//             if(strategy[i] == 1){
//                 strategyValue = strategyValue + Math.pow(2, (Math.abs(i - 7) - 6));
//             }
//         }
//         return strategyValue;
//     }
    
//     public SimulatedAnnealing(MyLogger logger, int iterations, int iterationMCTs, int numberOfStrategies, int gameMode ,int debug){
//         this.logger = logger;
//         this.iterations = iterations;
//         this.iterationMCTs = iterationMCTs;
//         this.numberOfStrategies = numberOfStrategies;
//         this.gameMode = gameMode;
//         this.debug = debug;
//     }
//     public void run(){
//         Random random = new Random();
//         ArrayList<Integer> strategyList = new ArrayList<>();
//         for(int i = 0; i < numberOfStrategies; i++){
//             strategyList.add(random.nextInt(256));
//         }
//         MCTs currentMCTs = new MCTs(iterationMCTs, debug);
//         for(int i = 0; i < iterations; i++){
//             MCTs newMCTs = new MCTs(iterations, debug);
//             strategyList = new ArrayList<>();
//             for(int j = 0; j < numberOfStrategies; j++){
//                 strategyList.add(random.nextInt(256));
//             }
//             newMCTs.enableStrategy(strategyList);
//             ConnectX connectX = new ConnectX(logger, "MCTs", "MCTs", currentMCTs, newMCTs, 2, gameMode, 0, debug);
//             ConnectX connectX2 = new ConnectX(logger, "MCTs", "MCTs", newMCTs, currentMCTs, 2, gameMode, 0, debug);
//             connectX.run();
//             connectX2.run();
//             if(connectX.player1Wins < connectX2.player2Wins){
//                 currentMCTs = newMCTs;
//             }
//         }
//     }
// }

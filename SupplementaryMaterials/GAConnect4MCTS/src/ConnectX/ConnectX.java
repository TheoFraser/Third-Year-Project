package ConnectX;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import javax.print.attribute.standard.MediaSize.NA;

import Logger.MyLogger;
import MCTs.MCTs;
import RulesStrategies.*;


public class ConnectX {
    String player1Option;
    String player2Option;
    int iterations;
    public int player1Wins = 0;
    public int player2Wins = 0;
    public int draws = 0;
    public ConnectXBoard connectXBoard;
    Random random;
    double player1TotalTime = 0;
    double player2TotalTime = 0;
    int position = -1;
    double player1TotalTimeGame = 0;
    double player2TotalTimeGame = 0;
    double startTime = 0;
    double endTime = 0;
    int player1MovesGame = 0;
    int player2MovesGame = 0;
    int player1MovesTotal = 0;
    int player2MovesTotal = 0;
    int player1NodesGame = 0;
    int player2NodesGame = 0;
    int player1NodeTotal = 0;
    int player2NodeTotal = 0;
    int gameMode;
    int debug = 0;
    int log;
    Scanner scanner = new Scanner(System.in);
    MyLogger logger;
    Rules rules;
    MyLogger debugLogger;
    MyLogger logger2;
    Strategies strategies;
    Algorithm player1Algorithm;
    Algorithm player2Algorithm;
    public ConnectX(MyLogger logger, String player1Option, String player2Option, Algorithm player1Algorithm, Algorithm player2Algorithm , int iterations, int gameMode,int log ,int debug){
        this.logger = logger;
        this.player1Option = player1Option;
        this.player2Option = player2Option;
        this.player1Algorithm = player1Algorithm;
        this.player2Algorithm = player2Algorithm;
        this.iterations = iterations;
        this.gameMode = gameMode;
        this.log = log;
        this.debug = debug; 
        if(log == 1){
            this.logger2 = new MyLogger(logger.filename + " Import");
        }
        if(debug == 1){
            debugLogger = new MyLogger("debug");
        }
    }
    public int getPlayer1Move(){
        double startTime = System.nanoTime();
        position = player1Algorithm.getMove(connectXBoard, position);
        double endTime = System.nanoTime();
        if(player1Option.equalsIgnoreCase("MCTs")){
            player1NodesGame = player1NodesGame + player1Algorithm.playerMCTs.numberNodes;
            player1NodeTotal = player1NodeTotal + player1Algorithm.playerMCTs.numberNodes;
        }
        player1TotalTimeGame = player1TotalTimeGame + (endTime - startTime);
        player1TotalTime = player1TotalTime + (endTime-startTime);
        player1MovesGame = player1MovesGame + 1;
        player1MovesTotal = player1MovesTotal + 1;
        return position;
    }
    public int getPlayer2Move(){
        double startTime = System.nanoTime();
        position = player2Algorithm.getMove(connectXBoard, position);
        double endTime = System.nanoTime();
        if(player2Option.equalsIgnoreCase("MCTs")){
            player2NodesGame = player2NodesGame + player2Algorithm.playerMCTs.numberNodes;
            player2NodeTotal = player2NodeTotal + player2Algorithm.playerMCTs.numberNodes;
        }
        player2TotalTimeGame = player2TotalTimeGame + (endTime - startTime);
        player2TotalTime = player2TotalTime + (endTime-startTime);
        player2MovesGame = player2MovesGame + 1;
        player2MovesTotal = player2MovesTotal + 1;
        return position;
    }
    public void run(){
        player1Wins = 0;
        player2Wins = 0;
        draws = 0;
        connectXBoard = new ConnectXBoard(gameMode);
        random = new Random();
        player1TotalTime = 0;
        player2TotalTime = 0;
        if(log == 1){
            logger.addInfo("P1 wins, P2 wins, Draws, TOTAL TIME P1, TOTAL TIME P2, TOTAL MOVES, TOTAL MOVES P1, TOTAL MOVES P2");
        }
        for(int i = 0; i < iterations; i++){
            int position = -1;
            player1TotalTimeGame = 0;
            player2TotalTimeGame = 0;
            player1MovesGame = 0;
            player2MovesGame = 0;
            int totalMoves = 0;
            player2NodesGame = 0;
            player1NodesGame = 0;
            this.connectXBoard = new ConnectXBoard(gameMode);
            connectXBoard.place(3);
            connectXBoard.place(4);
            connectXBoard.place(4);
            connectXBoard.place(5);
            connectXBoard.place(6);
            connectXBoard.place(5);
            connectXBoard.place(5);
            connectXBoard.place(2);
            connectXBoard.place(6);
            if(debug == 1){
                connectXBoard.showBoard();
            }
            random = new Random();
            while(connectXBoard.gameState() == 0){
                // PLAYER 1
                if(connectXBoard.nextTurn == 2){
                    position = getPlayer1Move();
                    // if(debug == 1){
                    //     System.out.println("Player 1 has placed " + position);
                    // }
                }
                // PLAYER 2
                else if(connectXBoard.nextTurn == -1){
                    position = getPlayer2Move();
                    // if(debug == 1){
                    //     System.out.println("Player 2 has placed " + position);
                    // }
                }
                boolean canPlace = connectXBoard.place(position);
                if(debug == 1){
                    if(canPlace){
                        if(connectXBoard.nextTurn == 2){
                            System.out.println("Player 2 has placed " + position);
                        }
                        if(connectXBoard.nextTurn == -1){
                            System.out.println("Player 1 has placed " + position);
                        }
                        debugLogger.addInfo("connectXBoard.place(" + position +");");
                    }
                    else{
                        System.out.println("INVALID MOVE");
                    }
                    connectXBoard.showBoard();
                    System.out.println("%%%%%%%%%%%%%%%%%%%END OF TURN%%%%%%%%%%%%%%%%%%%%%");
                }
                totalMoves = totalMoves + 1;
            }
            String won = "";
            if(connectXBoard.gameState() == 2)
            {
                player1Wins = player1Wins + 1;
                won = "P1 WINS";
                //logger.addInfo(won + ", Total Time P1: " + player1TotalTimeGame + ", Total Time P2: " + player2TotalTimeGame +  " , Total Moves: " + totalMoves + " P1: TotalMoves " + player1MovesGame + " P2: TotalMoves " + player2MovesGame + " P1: Num Nodes " + player1NodesGame + " P2: Num Nodes " + player2NodesGame);
                if(log == 1){
                    logger.addInfo("1, 0, 0, " + player1TotalTimeGame + ", " + player2TotalTimeGame + ", " + totalMoves + ", " + player1MovesGame + ", " + player2MovesGame);
                }
            }
            if(connectXBoard.gameState() == -1)
            {
                player2Wins = player2Wins + 1;
                won = "P2 WINS";
                if(log == 1){
                    logger.addInfo("0, 1, 0, " + player1TotalTimeGame + ", " + player2TotalTimeGame + ", " + totalMoves + ", " + player1MovesGame + ", " + player2MovesGame);
                }
            }
            if(connectXBoard.gameState() == 3)
            {
                draws = draws + 1;
                won = "DRAW";
                if(log == 1){
                    logger.addInfo("0, 0, 1, " + player1TotalTimeGame + ", " + player2TotalTimeGame + ", " + totalMoves + ", " + player1MovesGame + ", " + player2MovesGame);
                }
            }
            if(debug == 1){
                System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%% " + won + " %%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
            }
        }
        switch(player1Option.toUpperCase()){
            case "RAND":
                player1Option = "00 " + player1Option;
                break;
            case "NAIVE":
                player1Option = "01 " + player1Option;
                break;
            case "MCTS":
                player1Option = "02 " + player1Option;
                if(player1Algorithm.playerMCTs.onRulesTree == 1){
                    player1Option = player1Option + "+01 NAIVE";
                }
                if(player1Algorithm.playerMCTs.onRulesSimulation == 1){
                    player1Option = player1Option + "TREE";
                }
                // if(.onRules == 1){
                //     player1Option = player1Option + "+01 NAIVE";
                // }
            
        }
        switch(player2Option.toUpperCase()){
            case "RAND":
                player2Option = "00 " + player2Option;
                break;
            case "NAIVE":
                player2Option = "01 " + player2Option;
                break;
            case "MCTS":
                player2Option = "02 " + player2Option;
                if(player2Algorithm.playerMCTs.onRulesTree == 1){
                    player2Option = player2Option + "+01 NAIVE";
                }
                if(player2Algorithm.playerMCTs.onRulesSimulation == 1){
                    player2Option = player2Option + "TREE";
                }
        }
        if(log == 1){
            // logger2.addInfo("Iterations, P1 Algorithm, P1 Parameters, P1 Wins %, P1 Avg Moves per Game, P1 Avg Time Mico. Secs, P1 Power in mJ, P1 Avg MTSC Nodes Explored, P2 Algorithm, P2 Parameters, P2 Wins %, P2 Avg Moves per Game, P2 Avg Time Mico. Secs, P2 Power in mJ, P2 Avg MTSC Nodes Explored, No of Draws, Why we doing this? What do we hope to see");
            // logger2.addInfo(iterations + "," + player1Option + ", " + player1Algorithm.iterations + ", " + ((double)player1Wins / iterations) * 100 + ", " + (double)player1MovesTotal/iterations + ", " + ((double)player1TotalTime / iterations) / 1000 + ", " + null + ", " + (double)player1NodeTotal / iterations + "," + player2Option + ", " + player2Algorithm.iterations + ", " + ((double)player2Wins / iterations) * 100 + ", " + (double)player2MovesTotal/iterations + ", " + ((double)player2TotalTime / iterations) / 1000 + ", " + null + ", " + (double)player2NodeTotal / iterations + ", " + ((double)draws / iterations) * 100 + ", "  + null);
            logger2.addInfo("Iterations; P1 Algorithm; P1 Parameters; P1 Wins %; P1 Avg Moves per Game; P1 Avg Time Mico. Secs; P1 Power in mJ; P1 Avg MTSC Nodes Explored; P1 Strategies; P2 Algorithm; P2 Parameters; P2 Wins %; P2 Avg Moves per Game; P2 Avg Time Mico. Secs; P2 Power in mJ; P2 Avg MTSC Nodes Explored; P2 Strategies; No of Draws; Why we doing this? What do we hope to see");
            logger2.addInfo(iterations + ";" + player1Option + "; " + player1Algorithm.iterations + "; " + ((double)player1Wins / iterations) * 100 + "; " + (double)player1MovesTotal/iterations + "; " + ((double)player1TotalTime / iterations) / 1000 + "; " + null + "; " + (double)player1NodeTotal / iterations + ";" + player1Algorithm.strategies + "; " + player2Option + "; " + player2Algorithm.iterations + "; " + ((double)player2Wins / iterations) * 100 + "; " + (double)player2MovesTotal/iterations + "; " + ((double)player2TotalTime / iterations) / 1000 + "; " + null + "; " + (double)player2NodeTotal / iterations + "; " + player2Algorithm.strategies + "; " +((double)draws / iterations) * 100 + "; "  + null);
        }
    }
}



// connectXBoard.place(1);
// connectXBoard.place(2);
// connectXBoard.place(1);
// connectXBoard.place(2);
// connectXBoard.place(1);
// connectXBoard.place(0);
// connectXBoard.place(0);
// connectXBoard.place(1);
// connectXBoard.place(2);
// connectXBoard.place(2);
// connectXBoard.place(3);
// connectXBoard.place(4);
// connectXBoard.place(3);
// connectXBoard.place(3);
// connectXBoard.place(4);
// connectXBoard.place(5);

// logger.addInfo("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
// logger.addInfo("P1 wins: " + player1Wins + " , P2 wins: " + player2Wins + ", Draws: " + draws + ", Total iterations: " + iterations + ", P1 Total Time: " + player1TotalTime + ", P2 Total Time: " + player2TotalTime);
// logger.addInfo("P1 Total Moves: " + player1MovesTotal + " P2 Total Moves: " + player2MovesTotal + " P1 Num Nodes Total " + player1NodeTotal + " P2 Num Nodes Total " + player2NodeTotal);
// logger.addInfo("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%AVG%%%%%%%%%%%%%%%%%%%%%%%%%%%");
// logger.addInfo("P1 wins percent " + ((double)player1Wins / iterations) * 100 + " AVG MOVES: " + (double)player1MovesTotal/iterations + " AVG TIME: " + ((double)player1TotalTime / iterations) / 1000 + " MCTs NODES: " + (double)player1NodeTotal / iterations);
// logger.addInfo("P2 wins percent " + ((double)player2Wins / iterations) * 100 + " AVG MOVES: " + (double)player2MovesTotal/iterations + " AVG TIME: " + ((double)player2TotalTime / iterations) / 1000 + " MCTs NODES: " + (double)player2NodeTotal / iterations);
// logger.addInfo("Draws percent " + ((double)draws / iterations) * 100);



// connectXBoard.place(3)
// connectXBoard.place(4)
// connectXBoard.place(3)
// connectXBoard.place(4)
// connectXBoard.place(4)
// connectXBoard.place(3)
// connectXBoard.place(4)
// connectXBoard.place(3)
// connectXBoard.place(3)
// connectXBoard.place(4)
// connectXBoard.place(2)
// connectXBoard.place(1)
// connectXBoard.place(1)
// connectXBoard.place(2)
// connectXBoard.place(5)
// connectXBoard.place(1)
// connectXBoard.place(2)
// connectXBoard.place(2)
// connectXBoard.place(5)
// connectXBoard.place(1)
// connectXBoard.place(1)
// connectXBoard.place(5)
// connectXBoard.place(5)


            // connectXBoard.place(3);
            // connectXBoard.place(4);
            // connectXBoard.place(3);
            // connectXBoard.place(4);
            // connectXBoard.place(4);
            // connectXBoard.place(3);
            // connectXBoard.place(4);
            // connectXBoard.place(3);
            // connectXBoard.place(3);
            // connectXBoard.place(4);
            // connectXBoard.place(2);
            // connectXBoard.place(1);
            // connectXBoard.place(1);
            // connectXBoard.place(2);
            // connectXBoard.place(5);
            // connectXBoard.place(1);
            // connectXBoard.place(2);
            // connectXBoard.place(2);
            // connectXBoard.place(5);
            // connectXBoard.place(1);
            // connectXBoard.place(1);
            // connectXBoard.place(4);
            // connectXBoard.place(1);
            // connectXBoard.place(0);
            // connectXBoard.place(5);



            // connectXBoard.place(3);
            // connectXBoard.place(3);
            // connectXBoard.place(3);
            // connectXBoard.place(4);
            // connectXBoard.place(3);
            // connectXBoard.place(4);
            // connectXBoard.place(5);
            // connectXBoard.place(1);
            // connectXBoard.place(5);
            // connectXBoard.place(1);
            // connectXBoard.place(2);
            // connectXBoard.place(1);
            // connectXBoard.place(1);
            // connectXBoard.place(4);
            // connectXBoard.place(2);
            // connectXBoard.place(2);
            // connectXBoard.place(4);
            // connectXBoard.place(4);
            // connectXBoard.place(4);
            // connectXBoard.place(2);
            // connectXBoard.place(0);
            // connectXBoard.place(3);
            // connectXBoard.place(0);
            // connectXBoard.place(3);
            // connectXBoard.place(0);
            // connectXBoard.place(0);
            // connectXBoard.place(2);







            // if(debug == 1){
            //     System.out.println("PLAYER 1 TURN");
            // }
            // // Person
            // if(player1Option.equalsIgnoreCase("PERSON")){
            //     position = scanner.nextInt();
            // }
            // // Random Moves
            // if(player1Option.equalsIgnoreCase("RAND")){
            //     startTime = System.nanoTime();
            //     position = random.nextInt(connectXBoard.width);
            //     while(!connectXBoard.canPlace(position)){
            //         position = random.nextInt(connectXBoard.width);
            //     }
            //     endTime = System.nanoTime();
            // }
            // if(player1Option.equalsIgnoreCase("NAIVE")){
            //     startTime = System.nanoTime();
            //     int position = (Naive) player1ALG.getMove();
            //     endTime = System.nanoTime();
            // }
            // if(player1Option.equalsIgnoreCase("MCTs")){
            //     startTime = System.nanoTime();
            //     int position = (MCTs) player1ALG.findBestMove(connectXBoard);
            //     endTime = System.nanoTime();
            //     player1NodesGame = (MCTs) player1ALG.numberNodes;
            //     player1NodeTotal = (MCTs) player1ALG.numberNodes;
            // }
                    // 4 RULES
        // if(player1Option.equalsIgnoreCase("NAIVE")){
            // startTime = System.nanoTime();
            // ArrayList<Integer> legalMoves = rules.getMoves(connectXBoard);
            // int randomIndex = random.nextInt(legalMoves.size());
            // position = legalMoves.get(randomIndex);
            // endTime = System.nanoTime();
        // }
        // if(player1Option.equalsIgnoreCase("MCTs")){
        //     startTime = System.nanoTime();
        //     position = player1MCTs.findBestMove(connectXBoard);
        //     endTime = System.nanoTime();
            // player1NodesGame = player1NodesGame + player1MCTs.numberNodes;
            // player1NodeTotal = player1NodeTotal + player1MCTs.numberNodes;
        // }



            // if(debug == 1){
            //     System.out.println("PLAYER 2 TURN");
            // }
            // // Person
            // if(player2Option.equalsIgnoreCase("PERSON")){
            //     position = scanner.nextInt();
            // }
            // // Random Moves
            // if(player2Option.equalsIgnoreCase("RAND")){
            //     startTime = System.nanoTime();
            //     position = random.nextInt(connectXBoard.width);
            //     while(!connectXBoard.canPlace(position)){
            //         position = random.nextInt(connectXBoard.width);
            //     }
            //     endTime = System.nanoTime();
            // }
            // // 4 RULES
            // if(player2Option.equalsIgnoreCase("NAIVE")){
            //     startTime = System.nanoTime();
            //     int position = (Naive) player2ALG.getMove();
            //     endTime = System.nanoTime();
            // }
            // if(player2Option.equalsIgnoreCase("MCTs")){
            //     startTime = System.nanoTime();
            //     int position = (MCTs) player2ALG.findBestMove(connectXBoard);
            //     endTime = System.nanoTime();
            //     player1NodesGame = (MCTs) player2ALG.numberNodes;
            //     player1NodeTotal = (MCTs) player2ALG.numberNodes;
            // }
                    // if(player2Option.equalsIgnoreCase("NAIVE")){
        //     startTime = System.nanoTime();
        //     ArrayList<Integer> legalMoves = rules.getMoves(connectXBoard);
        //     System.out.println(legalMoves);
        //     // System.out.println(legalMoves);
        //     int randomIndex = random.nextInt(legalMoves.size());
        //     position = legalMoves.get(randomIndex);
        //     endTime = System.nanoTime();
        // }
        // if(player2Option.equalsIgnoreCase("MCTs")){
        //     startTime = System.nanoTime();
        //     position = player2MCTs.findBestMove(connectXBoard);
        //     endTime = System.nanoTime();
        //     player2NodesGame = player2NodesGame + player2MCTs.numberNodes;
        //     player2NodeTotal = player2NodeTotal + player2MCTs.numberNodes;
        // }
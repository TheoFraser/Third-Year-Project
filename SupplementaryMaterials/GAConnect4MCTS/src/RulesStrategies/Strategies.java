package RulesStrategies;

import java.util.ArrayList;

import ConnectX.ConnectXBoard;
import MCTs.MCTsNode;

public class Strategies {
    ArrayList<Integer> strategyList;
    ConnectXBoard board; 
    int position;
    int lastPlaced;
    double weight = 1;
    boolean onMCTs;
    public Strategies(ArrayList<Integer> strategyList){
        this.strategyList = strategyList;
    }
    // PLACE ON TOP OF OPPONENT
    public void applyStrategy1(){
        // System.out.println("Strategy 1 " + (strategyList.get(0) / Math.pow(2, 6)));
        // System.out.println(weight * (strategyList.get(0) / Math.pow(2, 6)));
        if(position == lastPlaced){
            // weight = weight * (strategyList.get(0) / Math.pow(2, 6));
            // System.out.println("TRUE 1: " + position);
            weight = weight + strategyList.get(0);
        }
        // System.out.println("Strategy 1 weight " + weight);
    }
    // BLOCK OPPONENT 2 
    public void applyStrategy2(){
        // System.out.println("Strategy 2 " + (strategyList.get(1) / Math.pow(2, 6)));
        int threeInARowBefore = board.checkHowManyWins(-board.nextTurn + 1, board.gameMode - 1);
        board.setNextTurn(-board.nextTurn + 1);
        board.place(position);
        int threeInARowAfter = board.checkHowManyWins(-board.nextTurn + 1, board.gameMode - 1);
        board.removeDisk(position);
        board.setNextTurn(-board.nextTurn + 1);
        if(threeInARowAfter > threeInARowBefore){
            // weight = weight * (strategyList.get(1) / Math.pow(2, 6));
            // System.out.println("TRUE 2: " + position);
            weight = weight + strategyList.get(1);
        }
        // System.out.println("Strategy 2 weight " + weight);
    }
    // CREATE A 3
    public void applyStrategy3(){
        // System.out.println("Strategy 3 " + (strategyList.get(2) / Math.pow(2, 6)));
        int threeInARowBefore = board.checkHowManyWins(board.nextTurn, board.gameMode - 1);
        board.place(position);
        int threeInARowAfter = board.checkHowManyWins(-board.nextTurn + 1, board.gameMode - 1);
        board.removeDisk(position);
        if(threeInARowAfter >  threeInARowBefore){
            // weight = weight * (strategyList.get(2) / Math.pow(2, 6));
            // System.out.println("TRUE 3: " + position);
            weight = weight + strategyList.get(2);
        }
        // System.out.println("Strategy 3 weight " + weight);
    }
    // PLACE MIDDLE
    public void applyStrategy4(){
        // System.out.println("Strategy 4 " + (strategyList.get(3) / Math.pow(2, 6)));
        if(position == 3){
            // weight = weight * (strategyList.get(3) / Math.pow(2, 6));
            // System.out.println("TRUE 4: " + position);
            weight = weight + strategyList.get(3);
        }
        // System.out.println("Strategy 4 weight " + weight);
    }
    // PLACE FORK
    // public void applyStrategy5(){
    //     if(board.checkIfPlayerWin(board.nextTurn, board.gameMode - 2)){
    //         int threeInARowBefore = board.checkHowManyWins(board.nextTurn, board.gameMode - 1);
    //         boolean place1 = board.place(position);
    //         int threeInARowAfter = board.checkHowManyWins(-board.nextTurn + 1, board.gameMode - 1);
    //         if(threeInARowAfter > threeInARowBefore){
    //             boolean place2 = board.place(position);
    //             boolean place3 = board.place(position);
    //             if(board.checkIfPlayerWin(-board.nextTurn + 1, board.gameMode)){
    //                 // weight = weight * (strategyList.get(4) / Math.pow(2, 6));
    //                 // System.out.println("TRUE 5: " + position);
    //                 weight = weight + strategyList.get(4);
    //             }
    //             if(place2){
    //                 board.removeDisk(position);
    //             }
    //             if(place3){
    //                 board.removeDisk(position);
    //             }
    //         }
    //         if(place1){
    //             board.removeDisk(position);
    //         }
    //     }
    // }
    // CREATE A 2
    public void applyStrategy5(){
        // System.out.println("Strategy 3 " + (strategyList.get(2) / Math.pow(2, 6)));
        int twoInARowBefore = board.checkHowManyWins(board.nextTurn, board.gameMode - 2);
        int threeInARowBefore = board.checkHowManyWins(board.nextTurn, board.gameMode - 1);
        board.place(position);
        int twoInARowAfter = board.checkHowManyWins(-board.nextTurn + 1, board.gameMode - 2);
        int threeInARowAfter = board.checkHowManyWins(board.nextTurn, board.gameMode - 1);
        board.removeDisk(position);
        if(twoInARowAfter >  twoInARowBefore){
            if(threeInARowBefore == threeInARowAfter){
                weight = weight + strategyList.get(4);
            }
            // weight = weight * (strategyList.get(2) / Math.pow(2, 6));
            // System.out.println("TRUE 3: " + position);
        }
        // System.out.println("Strategy 3 weight " + weight);
    }
    // DON'T CREATE 3 FOR OPPOSITION
    public void applyStrategy6(){
        int threeInARowBefore = board.checkHowManyWins(-board.nextTurn+1, board.gameMode - 1);
        boolean place1 = board.place(position);
        if(place1){
            boolean place2 = board.place(position);
            int threeInARowAfter = board.checkHowManyWins(-board.nextTurn+1, board.gameMode - 1);
            if(threeInARowAfter > threeInARowBefore){
                // System.out.print(strategyList.get(5) + "  POSITION " + position + " TREE BEFORE " + threeInARowBefore + " THREE AFTER " + threeInARowAfter);
                // weight = weight * (strategyList.get(5) / Math.pow(2, 6));
                weight = weight + strategyList.get(5);
            }
            if(place2){
                board.removeDisk(position);
            }
        }
        if(place1){
            board.removeDisk(position);
        }
    }
    public void lol(int i){
        if(i == 0){
            applyStrategy1();
        }
        if(i == 1){
            applyStrategy2();
        }
        if(i == 2){
            applyStrategy3();
        }
        if(i == 3){
            applyStrategy4();
        }
        if(i == 4){
            applyStrategy5();
        }
        if(i == 5){
            applyStrategy6();
        }
    }
    public double applyStrategy(ConnectXBoard board, int position, int lastPlaced){
        weight = 1;
        this.board = board;
        this.position = position;
        this.lastPlaced = lastPlaced;
        for(int i = 0; i < strategyList.size(); i++){
            lol(i);
        }
        // System.out.println(weight);
        return weight;
    }
    // // PLACE ON TOP OF OPPONENT 
    // public void applyStrategy1(){
    //     if(node.getPlayerMove() == node.getOpponentMove()){
    //         UCB1 = strategyList.get(0) * UCB1 / Math.pow(2, 6);
    //     }
    // }
    // // BLOCK OPPONENT 2
    // public void applyStrategy2(){
    //     node.getBoard().removeDisk(node.getPlayerMove());
    //     node.getBoard().setNextTurn(-node.getBoard().nextTurn + 1);
    //     node.getBoard().place(node.getPlayerMove());
    //     boolean twoInARow = node.getBoard().checkIfPlayerWin(-node.getBoard().nextTurn + 1, 3);
    //     node.getBoard().setNextTurn(-node.getBoard().nextTurn + 1);
    //     node.getBoard().place(node.getPlayerMove());
    //     if(twoInARow){
    //         UCB1 = strategyList.get(1) * UCB1 / Math.pow(2, 6);
    //     }
    // }
    // // CREATE A 3
    // public void applyStrategy3(){
    //     boolean threeInARow = node.getBoard().checkIfPlayerWin(-node.getBoard().nextTurn + 1, 3);
    //     if(threeInARow){
    //         UCB1 = strategyList.get(2) * UCB1 / Math.pow(2, 6);
    //     }
    // }
    // // PLACE MIDDLE COLUMN
    // public void applyStrategy4(){
    //     if(node.getPlayerMove() == 3){
    //         UCB1 = strategyList.get(3) * UCB1 / Math.pow(2, 6);
    //     }
    // }
    // public double applyStrategy(double UCB1, MCTsNode node){
    //     this.UCB1 = UCB1;
    //     this.node = node;
    //     applyStrategy1();
    //     applyStrategy2();
    //     applyStrategy3();
    //     applyStrategy4();
    //     return UCB1;
    // }

}

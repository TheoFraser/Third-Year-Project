package RulesStrategies;

import java.util.ArrayList;
import ConnectX.ConnectXBoard;

public class Rules {
    ArrayList<Boolean> ruleList;
    ConnectXBoard connectXBoard;
    ConnectXBoard board;
    public Rules(boolean on, int size){
        ruleList = new ArrayList<>();
        for(int i = 0; i < size; i++){
            ruleList.add(on);
        }
    }
    public Rules(ArrayList<Boolean> ruleList){
        this.ruleList = ruleList;
    }
    public ArrayList<Integer> getMoves(ConnectXBoard connectXBoard){
        this.connectXBoard = connectXBoard;
        ArrayList<Integer> legalMoves = new ArrayList<>();
        if(ruleList.get(0)){
            if(connectXBoard.checkIfPlayerWin(connectXBoard.nextTurn, connectXBoard.gameMode - 2)){
                    legalMoves = canWin(connectXBoard.nextTurn);
                    if(!legalMoves.isEmpty()){
                        return legalMoves;
                    }
            }
        }
        if(ruleList.get(1) || ruleList.get(3)){
            if(connectXBoard.checkIfPlayerWin(-connectXBoard.nextTurn + 1, connectXBoard.gameMode - 2)){
                if(ruleList.get(1)){
                    legalMoves = canWin(-connectXBoard.nextTurn+1);
                    if(!legalMoves.isEmpty()){
                        return legalMoves;
                    }
                }
                if(ruleList.get(3)){
                    for(int i = 0; i < connectXBoard.width; i++){
                        if(connectXBoard.canPlace(i)){
                            legalMoves.add(i);
                        }
                    }
                    connectXBoard.addGhostDisk();
                    ArrayList<Integer> removeList = canWin(-connectXBoard.nextTurn + 1);
                    connectXBoard.removeGhostDisk();
                    legalMoves.removeAll(removeList);
                }
            }
        }
        if(legalMoves.isEmpty()){
            for(int i = 0; i < connectXBoard.width; i++){
                if(connectXBoard.canPlace(i)){
                    legalMoves.add(i);
                }
            }
        }
        return legalMoves;
    }
    public ArrayList<Integer> canWin(int turn)
    {
        ConnectXBoard winBoard = new ConnectXBoard(connectXBoard.board, turn, connectXBoard.gameMode);
        ArrayList<Integer> winingPlace = new ArrayList<>();
        for(int i = 0; i < connectXBoard.width; i++){
            if(connectXBoard.canPlace(i)){
                winBoard.place(i);
                if(winBoard.checkIfPlayerWin(turn,connectXBoard.gameMode)){
                    winingPlace.add(i);
                }
                winBoard.removeDisk(i);
            }
        }
        return winingPlace;
    }

}


// public ArrayList<Integer> getMoves(ConnectXBoard board)
// {
//     this.board = board;
//     ArrayList<Integer> legalMoves = new ArrayList<>();
//     if(ruleList.get(0))
//     {
//         int position = canWin(board.nextTurn);
//         if(position != -1)
//         {
//             //System.out.println("PLAYER WINS ");
//             //System.out.println("WIN");
//             legalMoves.add(position);
//             return legalMoves;
//         }
//     }
//     if(ruleList.get(0))
//     {
//         int position = canWin((-board.nextTurn + 1));
//         if(position != -1)
//         {
//             legalMoves.add(position);
//             //System.out.println("OTHER PLAYER WINS " + legalMoves);
//             return legalMoves;
//         }
//     }
//     //System.out.println("LOL");
//     for(int i = 0; i < board.width; i++)
//     {
//         if(board.canPlace(i))
//         {
//             legalMoves.add(i);
//         }
//     }
//     //System.out.println("LOL");
//     if(ruleList.get(0))
//     {
//         for(int i = 0; i < board.width; i++)
//         {
//             if(board.canPlace(i))
//             {
//                 board.place(i);
//                 int position = canWin(board.nextTurn);
//                 //System.out.println(position + " I " + i);
//                 if(position != -1)
//                 {
//                     legalMoves.remove(Integer.valueOf(i));
//                 }
//                 board.removeDisk(i);
//             }
//         }
//     }
//     if(legalMoves.isEmpty())
//     {
//         //System.out.println("EMPTY ");
//         for(int i = 0; i < board.width; i++)
//         {
//             if(board.canPlace(i))
//             {
//                 legalMoves.add(i);
//             }
//         }
//         //System.out.println("EMPTY " + legalMoves);
//         //System.out.println("TRUE");
//     }
//     //System.out.println("END ");
//     return legalMoves;
// }
// public int canWin(int turn)
// {
//     ConnectXBoard winBoard = new ConnectXBoard(board.board, turn, 4);
//     int winingPlace = -1;
//     for(int i = 0; i < board.width; i++)
//     {
//         if(board.canPlace(i))
//         {
//             winBoard.place(i);
//             //System.out.println("winning Plcae "  + winingPlace + "I " + i);
//             if(winBoard.checkIfPlayerWin(turn,4))
//             {
//                 //System.out.print("LMAO ");
//                 winingPlace = i;
//             }
//             winBoard.removeDisk(i);
//         }
//     }
//     //System.out.println("WIN " + winingPlace);
//     return winingPlace;
// }


    // public ArrayList<Integer> getMoves(ConnectXBoard connectXBoard){
    //     this.connectXBoard = connectXBoard;
    //     ArrayList<Integer> legalMoves = new ArrayList<>();
    //     if(ruleList.get(0)){
    //         if(connectXBoard.checkIfPlayerWin(connectXBoard.nextTurn, connectXBoard.gameMode - 2)){
    //                 legalMoves = canWin(connectXBoard.nextTurn);
    //                 if(!legalMoves.isEmpty()){
    //                     return legalMoves;
    //                 }
    //         }
    //     }
    //     if(ruleList.get(1) || ruleList.get(3)){
    //         if(connectXBoard.checkIfPlayerWin(-connectXBoard.nextTurn + 1, connectXBoard.gameMode - 2)){
    //             if(ruleList.get(1)){
    //                 legalMoves = canWin(-connectXBoard.nextTurn+1);
    //                 if(!legalMoves.isEmpty()){
    //                     return legalMoves;
    //                 }
    //             }
    //             if(ruleList.get(3)){
    //                 for(int i = 0; i < connectXBoard.width; i++){
    //                     if(connectXBoard.canPlace(i)){
    //                         legalMoves.add(i);
    //                     }
    //                 }
    //                 connectXBoard.addGhostDisk();
    //                 ArrayList<Integer> removeList = canWin(-connectXBoard.nextTurn + 1);
    //                 connectXBoard.removeGhostDisk();
    //                 legalMoves.removeAll(removeList);
    //             }
    //         }
    //     }
    //     if(legalMoves.isEmpty()){
    //         for(int i = 0; i < connectXBoard.width; i++){
    //             if(connectXBoard.canPlace(i)){
    //                 legalMoves.add(i);
    //             }
    //         }
    //     }
    //     return legalMoves;
    // }
    // public ArrayList<Integer> canWin(int turn)
    // {
    //     ConnectXBoard winBoard = new ConnectXBoard(connectXBoard.board, turn, connectXBoard.gameMode);
    //     ArrayList<Integer> winingPlace = new ArrayList<>();
    //     for(int i = 0; i < connectXBoard.width; i++){
    //         if(connectXBoard.canPlace(i)){
    //             winBoard.place(i);
    //             if(winBoard.checkIfPlayerWin(turn,connectXBoard.gameMode)){
    //                 winingPlace.add(i);
    //             }
    //             winBoard.removeDisk(i);
    //         }
    //     }
    //     return winingPlace;
    // }

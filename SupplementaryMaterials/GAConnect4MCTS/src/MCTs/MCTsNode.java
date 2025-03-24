package MCTs;
import java.util.HashMap;
import ConnectX.ConnectXBoard;

public class MCTsNode {
    private ConnectXBoard board; // 2D array to represent the Connect 4 board
    private int visits; // Number of times this node has been visited in the simulation
    private double wins; // Number of simulated games that resulted in a win from this node
    private MCTsNode parent; // Reference to the parent node
    private HashMap<Integer,MCTsNode> children; // Child nodes representing possible next moves
    private Integer playerMove;
    private Integer opponentMove;
    private int depth;
    private double weight;

    public MCTsNode(MCTsNode parent, ConnectXBoard board, Integer playerMove, Integer opponentMove, int depth, double weight) {
        this.board = board;
        this.parent = parent;
        this.visits = 0;
        this.wins = 0;
        this.depth = depth;
        this.children = new HashMap<>();
        this.playerMove = playerMove;
        this.opponentMove = opponentMove;
        this.weight = weight;
    }
    public MCTsNode getParent() {
        return parent;
    }

    public ConnectXBoard getBoard() {
        return board;
    }

    public int getVisits() {
        return visits;
    }
    public int getDepth(){
        return depth;
    }

    public double getWins() {
        return wins;
    }

    public Integer getOpponentMove(){
        return opponentMove;
    }

    public Integer getPlayerMove(){
        return playerMove;
    }
    
    public double getWeight(){
        return weight;
    }

    public void setDepth(int depth){
        this.depth = depth;
    }

    public void incrementVisits() {
        visits++;
    }

    public void incrementWins(double value) {
        wins = wins + value;
    }

    public HashMap<Integer,MCTsNode> getChildren() {
        return children;
    }

    public void addChild(MCTsNode child, int key) {
        children.put(key,child);
    }
}


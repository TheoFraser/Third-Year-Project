package MCTs;
import java.util.ArrayList;
import java.util.Random;

import ConnectX.ConnectXBoard;
import RulesStrategies.Rules;
import RulesStrategies.Strategies;


public class MCTs {
    public int iterations;
    MCTsNode rootNode;                                      
    double EXPLORATION_PARAMETER = 2;                       // The value for the exploration parameter
    int debug = 0;
    int width;
    int depth;
    public int numberNodes;
    public int onRulesTree = 0;
    public int onRulesSimulation = 0;
    int gameMode;
    Rules rules;
    int strategiesOn = 0;
    public ArrayList<Integer> strategyList;
    public Strategies strategies;
    // BASIC MCTs
    public MCTs(int iterations, int debug){
        this.iterations = iterations;                       // Number of back propagation of MCTS
        this.debug = debug;                                 // Print out details for debugging 
        this.onRulesTree = 0;                               // If zero rules aren't applied to the tree search of MCTS
        this.onRulesSimulation = 0;                         // If zero rules aren't applied to the simulation of MCTS
    }
    // MCTs WITH RULES
    public MCTs(int iterations, int onRulesTree, int onRulesSimulation, int debug){
        this.iterations = iterations;                       // Number of back propagation for MCTS  
        this.onRulesTree = onRulesTree;                     // If 1 rules are applied to tree search of MCTS
        this.onRulesSimulation = onRulesSimulation;         // If 1 rules are applied to the simulation of MCTS
        this.debug = debug;                                 // Print out details for debugging 
        rules = new Rules(true, 5);                 // initializes the object rules which applies the rules to the MCTS
    }
    // MCTs WITH RULES, STRATEGIES
    public MCTs(int iterations, int onRulesTree, int onRulesSimulation, ArrayList<Integer> strategyList, int debug){
        this.iterations = iterations;                       // Number of back propagations for MCTS
        this.onRulesTree = onRulesTree;                     // If 1 rules are applied to tree search of MCTS
        this.onRulesSimulation = onRulesSimulation;         // If 1 rules are applied to the simulation of MCTS
        this.strategiesOn = 1;
        this.debug = debug;                                 // Print out details for debugging 
        strategies = new Strategies(strategyList);          // initializes the object strategies which applies the strategies to the MCTS
        rules = new Rules(true, 5);                 // initializes the object rules which applies the rules to the MCTS
    }
    // This function finds the best move using MCTS.
    public int findBestMove(ConnectXBoard board, int lastPlaced){
        this.width = board.width;                           // Set the width to the width of the board
        this.rootNode = new MCTsNode(null, board, -1, lastPlaced, 0, 0);          // Sets the initial node (root node) for MCTS 
        depth = 0;                                          // Set the depth of MCTS to 0
        numberNodes = 0;                                    // Set the number of new node to 0
        selection();                                        // Run the selection part of the MCTS algorithm
        int maxIndex = -1;                                  // Set the max Index to - 1 
        for(int i = 0; i < width; i++){                     // Loop through all the root nodes children and pick the child with the highest number of visits (most robust child).
            if(rootNode.getChildren().containsKey(i)){
                if(maxIndex == -1 || rootNode.getChildren().get(i).getVisits() > rootNode.getChildren().get(maxIndex).getVisits()){
                    maxIndex = i;
                }
            }
        }
        if(debug == 1){                                     // If debug is 1 print debug messages
            for(int i = 0; i < width; i++)
            {
                if(rootNode.getChildren().containsKey(i))
                {
                    double childUCB1 = (rootNode.getChildren().get(i).getWins()/rootNode.getChildren().get(i).getVisits()) + (8 * Math.sqrt(Math.log(rootNode.getVisits()) / rootNode.getChildren().get(i).getVisits()));
                    //System.out.println(i + " wins " + rootNode.getChildren().get(i).getWins() + " visits " + rootNode.getChildren().get(i).getVisits() + " UCB1 " + ((rootNode.getChildren().get(i).getWins()/rootNode.getChildren().get(i).getVisits()) + (32 * Math.sqrt(Math.log(rootNode.getVisits()) / rootNode.getChildren().get(i).getVisits()))));
                    System.out.println(i + " wins " + rootNode.getChildren().get(i).getWins() + " visits " + rootNode.getChildren().get(i).getVisits() + " UCB1 " + childUCB1);
                    System.out.println("START CHILDREN&&&&&&&&&&&&&&&&&&&&&&");
                    for(int j = 0; j < width; j++){
                        if(rootNode.getChildren().get(i).getChildren().containsKey(j)){
                            System.out.println(j + " wins " + rootNode.getChildren().get(i).getChildren().get(j).getWins() + " visits " + rootNode.getChildren().get(i).getChildren().get(j).getVisits() );
                        }
                    }
                    System.out.println("END CHILDREN&&&&&&&&&&&&&&&&&&&&&&");
                }
            }
        }   
        return maxIndex;                                    // return the best move                        
    }
    private void selection(){                                               // This functions builds the MCTS Tree
        //expansion();
        // long startTime = System.nanoTime();
        // long endTime = startTime + time;
        // while (System.nanoTime() < endTime) {
        for(int i = 0; i < iterations;){                                    // Loop iterations number of times
            if(rootNode.getBoard().gameState() == 0){                       // If the current root node game state == 0 (The game hasn't finished)
                if(rootNode.getChildren().isEmpty()){                       // If the current root node has no children (leaf node)
                    if(rootNode.getVisits() != 0){                          // IF the current root node has been visited before
                        expansion();                                        // Expand the root node add children to the root node
                        if(rootNode.getChildren().size() != 0){             // If the root node has no children (no available moves)
                            int child = calculateUCB1(rootNode);            // Calculate the UCB value for each child and returns the child with with the highest UCB
                            rootNode = rootNode.getChildren().get(child);   // root node is now equal to child with best UCB
                            numberNodes = numberNodes + 1;                  // Increments new nodes explored by 1
                        }
                    }
                    double reward = simulation(rootNode.getBoard());        // Calculate the reward for the root node
                    backPropagation(reward, rootNode.getBoard().nextTurn);  // back propagate the reward back to the start of the tree 
                    i++;                                                    // increments i by 1
                }
                else{                                                       // If root node has no children we need to calculate the reward for this node
                    int child = calculateUCB1(rootNode);                    // Calculate the UCB value for each child and returns the child with with the highest UCB
                    rootNode = rootNode.getChildren().get(child);           // root node is now equal to child with highest UCB
                }
            }
            else{                                                           // If the root node is a terminal node the game has finished
                double reward = simulation(rootNode.getBoard());            // Calculate the reward for the root node
                backPropagation(reward, rootNode.getBoard().nextTurn);      // back propagate the reward back to the start of the tree 
                i++;                                                        // Increments i by 1
            }
        }
        while (rootNode.getParent() != null) {                              // Loop until the root node no longer has a parent (the node at the top of the tree)
            rootNode = rootNode.getParent();                                // new root node is now equal to the current root nodes parent
        }
    }
    private void expansion(){                                                       // This function expands the current node by adding children to it
        ArrayList<Integer> legalMoves = getLegalMoves(rootNode.getBoard());         // Get the legal moves from current root node
        for(int i = 0; i < width; i++)                                              // Loops from 0 to width of board - 1
        {
            if(legalMoves.contains(i))                                              // If the placing in position I is a legal move
            {
                ConnectXBoard childBoard = new ConnectXBoard(rootNode.getBoard().board, rootNode.getBoard().nextTurn, rootNode.getBoard().gameMode);    // Create a new connectX board for the child node
                double weight = 1;                                                  // Set the weight of the node to 1
                if(strategiesOn == 1){                                              // If strategies are enabled 
                    weight = strategies.applyStrategy(childBoard, i, rootNode.getPlayerMove());                                                       // Set the weight of the node to weight calculated based on the strategies
                }
                rootNode.addChild(new MCTsNode(rootNode, childBoard, i, rootNode.getOpponentMove(), rootNode.getDepth() + 1, weight), i);               // Add the new child to the root nodes children
                rootNode.getChildren().get(i).getBoard().place(i);                                                                                      // Place the move for the new child
            }
        }
    }

    private double simulation(ConnectXBoard childBoard){                                                            // This function does a play out of the child node board and evaluates its fitness
        Random random = new Random();                                                                               // Create a new Random to generate new random numbers
        int randomNumber = 0;                                                                                       // Sets the random number to 0
        ConnectXBoard board = new ConnectXBoard(childBoard.board, childBoard.nextTurn, childBoard.gameMode);        // Creates a new board to do the play out on
        while (board.gameState() == 0) {                                                                            // While the new board game hasn't finished
            if(onRulesSimulation == 1){                                                                             // If the rules are enables for play out
                ArrayList<Integer> legalMoves = rules.getMoves(board);                                              // Get legal moves from current position of board from the rules
                int randomIndex = random.nextInt(legalMoves.size());                                                // Selects a random index based on size of legal moves
                randomNumber = legalMoves.get(randomIndex);                                                         // Selects the legal move with the random index as move
            }
            if(onRulesSimulation == 0){                                                                             // IF the rules are not enabled for play out
                randomNumber = random.nextInt(width);                                                               // Selects a random number based on boards width
            }
            while (!board.canPlace(randomNumber)) {                                                                 // If the board cant place at position generated do the generation again
                if(onRulesSimulation == 1){
                    ArrayList<Integer> legalMoves = rules.getMoves(board);
                    int randomIndex = random.nextInt(legalMoves.size());
                    randomNumber = legalMoves.get(randomIndex);
                }
                if(onRulesSimulation == 0){
                    randomNumber = random.nextInt(width);
                }
            }
            board.place(randomNumber);                                                                              // Place the move generated above on the play out board
        }
        if(board.gameState() == -childBoard.nextTurn + 1){                                                          // If the child node lost the game return 1
            return 1;
        }
        if(board.gameState() ==  childBoard.nextTurn){                                                              // If the child node lost the game return 0
            return 0;                                                                                               
        }
        return 0.25;                                                                                                // If draw return 0.25
    }
    private void backPropagation(double reward, int turn) {                                                         // This function back propagates the reward alp the way up the tree 
        while (rootNode.getParent() != null){                                                                       // Loop until the root node no longer has a parent (the node at the top of the tree)
            rootNode.incrementVisits();                                                                             // Increments root node visits by 1
            rootNode.incrementWins(reward);                                                                         // Increments root nodes wins by reward
            rootNode = rootNode.getParent();                                                                        // new root node is now equal to current root node parent
            if(reward != 0.25){                                                                                     // if reward is not equal to 0.25 (draw)
                reward = 1 - reward;                                                                                // reward is equal to 1 - reward (reverse reward for other player)
            }
        }
        rootNode.incrementVisits();                                                                                 // Increments roo node visits by 1
    }
    public ArrayList<Integer> getLegalMoves(ConnectXBoard connectXBoard){                                           // This function gets and returns the legal moves for the player at a current position
        ArrayList<Integer> legalMoves = new ArrayList<>();                                                          // Creates a new array list for the legal moves
        if(onRulesTree == 0){                                                                                       // If rules are disabled for the tree search part of the MCTS
            for(int i = 0; i < connectXBoard.width; i++){                                                           // Iterate i from 0 to width - 1. 
                if(connectXBoard.canPlace(i)){                                                                      // If you can place a position i
                    legalMoves.add(i);                                                                              // Add i to the legal moves array list
                }
            }
        }
        if(onRulesTree == 1){                                                                                       // If rules are enabled for the tree search part of the MCTS
            legalMoves = rules.getMoves(connectXBoard);                                                             // Get legals moves from the object rules calling the function getMoves()
        }
        return legalMoves;                                                                                          // return the arraylist legal moves
    }
    public int calculateUCB1(MCTsNode rootNode){                                                                    // This function calculates the UCB value for each child node
        int child = 0;                                                                                              // This variable holds the index for the child with the highest UCB
        double childUCB1 = 0;                                                                                       // This variable holds the UCB value of the child with the highest UCB value
        double UCB1 = -10000000;                                                                                    // THis is the base UCB value
        double totalWeight = 0;
        for(int i = 0; i < width; i++){
            if(rootNode.getChildren().containsKey(i)){
                totalWeight = totalWeight + Math.abs(rootNode.getChildren().get(i).getWeight());
            }
        }
        for(int i = 0; i < width; i++){                                                                             // Iterates i from 0 to width - 1
            if(rootNode.getChildren().containsKey(i)){                                                              // If the root node has a child at position i
                // childUCB1 = (rootNode.getChildren().get(i).getWins()/rootNode.getChildren().get(i).getVisits()) + (EXPLORATION_PARAMETER * Math.sqrt(Math.log(rootNode.getVisits()) / rootNode.getChildren().get(i).getVisits()));  // Calculates UCB value for the child node
                // childUCB1 = childUCB1 * rootNode.getChildren().get(i).getWeight();
                // if(strategiesOn == 1){
                //     childUCB1 = (rootNode.getChildren().get(i).getWins()/rootNode.getChildren().get(i).getVisits()) + ((EXPLORATION_PARAMETER + (rootNode.getChildren().get(i).getWeight() / totalWeight)) * Math.sqrt(Math.log(rootNode.getVisits()) / rootNode.getChildren().get(i).getVisits()));
                // } 
                // if(strategiesOn == 0){
                //     childUCB1 = (rootNode.getChildren().get(i).getWins()/rootNode.getChildren().get(i).getVisits()) + (EXPLORATION_PARAMETER * Math.sqrt(Math.log(rootNode.getVisits()) / rootNode.getChildren().get(i).getVisits())); 
                // }
                childUCB1 = (rootNode.getChildren().get(i).getWins()/rootNode.getChildren().get(i).getVisits()) + ((EXPLORATION_PARAMETER + (rootNode.getChildren().get(i).getWeight() / totalWeight)) * Math.sqrt(Math.log(rootNode.getVisits()) / rootNode.getChildren().get(i).getVisits()));
                if (UCB1 < childUCB1 || Double.isNaN(childUCB1) || Double.isInfinite(childUCB1)){                   // If the child UCB value is bigger than the UCB1 value or childUCB value is NAN or infinite
                    child = i;                                                                                      // Set child to i
                    UCB1 = childUCB1;                                                                               // Set UCB value to child UCB
                }
            }
        }
        return child;                                                                                               // return the index of the child with the highest UCB value
    }
}

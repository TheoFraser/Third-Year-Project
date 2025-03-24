package ConnectX;
public class ConnectXBoard {
    public int height;
    public int width;
    public int[][] board;

    public int nextTurn = 2;
    public int gameMode;

    public ConnectXBoard(int gameMode){
        this.gameMode = gameMode;
        this.width = 1 + ((gameMode-1) * 2);
        this.height = 2 + gameMode;
        board = new int[height][width];
    }
    public ConnectXBoard(int[][] boardContents, int nextTurn, int gameMode)
    {
        this.gameMode = gameMode;
        this.width = 1 + ((gameMode-1) * 2);
        this.height = 2 + gameMode;
        this.board = new int[height][width];
        copyBoardState(boardContents);
        this.nextTurn = nextTurn;
    }
    public void setNextTurn(int nextTurn){
        this.nextTurn = nextTurn;
    }  
    public boolean canRemove(int position){
        if(position < 0 || position > width || board[height-1][position] == 0){
            return false;
        }
        return true;
    }
    public boolean canPlace(int position){
        if(position < 0 || position > width || board[0][position] != 0){
            return false;
        }
        return true;
    }
    public void addGhostDisk(){
        for(int i = 0; i < width; i++){
            int diskHeight = height - 1;
            if(canPlace(i)){
                while (board[diskHeight][i] != 0) {
                    diskHeight = diskHeight - 1;
                }
                board[diskHeight][i] = 5;
            }
        }
    }
    public void removeGhostDisk(){
        for(int i = 0; i < width; i++){
            int diskHeight = 0;
            if(canRemove(i)){
                while (board[diskHeight][i] == 0) {
                    diskHeight = diskHeight + 1;
                }
                if(board[diskHeight][i] == 5){
                    board[diskHeight][i] = 0;
                }
            }
        }
    }
    public boolean place(int position){
        int diskHeight = height - 1;
        if(canPlace(position)){
            while (board[diskHeight][position] != 0) {
                diskHeight = diskHeight - 1;
            }
            board[diskHeight][position] = nextTurn;
            nextTurn = -nextTurn + 1;
            return true; 
        }
        return false;
    }
    public boolean removeDisk(int position){
        int diskHeight = 0;
        if(canRemove(position)){
            while (board[diskHeight][position] == 0) {
                diskHeight = diskHeight + 1;
            }
            board[diskHeight][position] = 0;
            nextTurn = -nextTurn + 1;
            return true; 
        }
        return false;
    }
    public int checkHowManyWins(int playerDisk, int numberInRow){
         // CHECK HORIZONTAL
        int numberOfTimes = 0;
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width - (numberInRow - 1); j++){
                int counter = 0;
                for(int z = 0; z < numberInRow; z++){
                    if(playerDisk == board[i][j+z]){
                        counter = counter + 1;
                    }
                }
                if(counter == numberInRow){
                    numberOfTimes = numberOfTimes + 1;
                }
            }
        }
        // CHECK VERTICAL
        for(int i = 0; i < height - (numberInRow - 1); i++){
            for(int j = 0; j < width; j++){
                int counter = 0;
                for(int z = 0; z < numberInRow; z++){
                    if(playerDisk == board[i+z][j]){
                        counter = counter + 1;
                    }
                }
                if(counter == numberInRow){
                    numberOfTimes = numberOfTimes + 1;
                }
            }
        }
        // CHECK X = Y PLAIN
        for(int i = 0; i < height - (numberInRow - 1); i++){
            for(int j = 0; j < width - (numberInRow - 1); j++){
                int counter = 0;
                for(int z = 0; z < numberInRow; z++){
                    if(playerDisk == board[i+z][j+z]){
                        counter = counter + 1;
                    }
                }
                if(counter == numberInRow){
                    numberOfTimes = numberOfTimes + 1;
                }
            }
        }
        // CHECK X = - Y PLAIN
        for(int i = 0; i < height  - (numberInRow - 1) ; i++){
            for(int j = numberInRow - 1; j < width; j++){
                int counter = 0;
                for(int z = 0; z < numberInRow; z++){
                    if(playerDisk == board[i+z][j-z]){
                        counter = counter + 1;
                    }
                }
                if(counter == numberInRow){
                    numberOfTimes = numberOfTimes + 1;
                }
            }
        }
        return numberOfTimes;
    }
    public boolean checkIfPlayerWin(int playerDisk, int numberInRow){
        // CHECK HORIZONTAL
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width - (numberInRow - 1); j++){
                int counter = 0;
                for(int z = 0; z < numberInRow; z++){
                    if(playerDisk == board[i][j+z]){
                        counter = counter + 1;
                    }
                }
                if(counter == numberInRow){
                    return true;
                }
            }
        }
        // CHECK VERTICAL
        for(int i = 0; i < height - (numberInRow - 1); i++){
            for(int j = 0; j < width; j++){
                int counter = 0;
                for(int z = 0; z < numberInRow; z++){
                    if(playerDisk == board[i+z][j]){
                        counter = counter + 1;
                    }
                }
                if(counter == numberInRow){
                    return true;
                }
            }
        }
        // CHECK X = Y PLAIN
        for(int i = 0; i < height - (numberInRow - 1); i++){
            for(int j = 0; j < width - (numberInRow - 1); j++){
                int counter = 0;
                for(int z = 0; z < numberInRow; z++){
                    if(playerDisk == board[i+z][j+z]){
                        counter = counter + 1;
                    }
                }
                if(counter == numberInRow){
                    return true;
                }
            }
        }
        // CHECK X = - Y PLAIN
        for(int i = 0; i < height  - (numberInRow - 1) ; i++){
            for(int j = numberInRow - 1; j < width; j++){
                int counter = 0;
                for(int z = 0; z < numberInRow; z++){
                    if(playerDisk == board[i+z][j-z]){
                        counter = counter + 1;
                    }
                }
                if(counter == numberInRow){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean isBoardFull(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                if(board[i][j] == 0){
                    return false;
                }
            }
        }
        return true;
    }
    public void copyBoardState(int[][] boardContents){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                board[i][j] = boardContents[i][j];
            }
        }
    }
    public int gameState(){
        if(checkIfPlayerWin(2, gameMode)){
            return 2;
        }
        if(checkIfPlayerWin(-1, gameMode)){
            return -1;
        }
        if(isBoardFull()){
            return 3;
        }
        return 0;
    }
    public void showBoard()
    {
        for(int i = 0; i < height; i++)
        {
            for(int j =0; j < (width * 4) + 1; j++)
            {
                System.out.printf("-");
            }
            System.out.printf("\r\n");
            for(int j = 0; j < width; j++)
            {
                if(j == 0)
                {
                    System.out.printf("|");
                }
                if(board[i][j] == 0)
                {
                    System.out.printf("   |");
                }
                if(board[i][j] == 2)
                {
                    System.out.printf(" X |");
                }
                if(board[i][j] == -1)
                {
                    System.out.printf(" O |");
                }
                if(board[i][j] == 5){
                    System.out.printf(" L |");
                }
            }
            System.out.printf("\r\n");
        }
        for(int j = 0; j < (width * 4) + 1; j++)
        {
            System.out.printf("-");
        }
        System.out.printf("\r\n");
        for(int j =0 ,counter = 0; j < (width * 4) + 1; j++)
        {
            if((j - 2) % 4 == 0 && j > 0)
            {
                System.out.printf("%d" , counter);
                counter++;
            }
            else
            {
                System.out.printf(" ");
            }
        }
        System.out.printf("\r\n");
    }
}

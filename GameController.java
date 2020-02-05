class Game
{
    int currentPlayerIndex=0, numberOfPlayers;
    Dice dice=new Dice();
    Board board;
    boolean stopGame = false;
    Player players[];
    PrinterAndScanner printerAndScanner=new PrinterAndScanner();

    void createPlayers() 
    {
        numberOfPlayers=printerAndScanner.getNumberOfPlayers();
        players=new Player[numberOfPlayers];
        for(int playerIndex=0; playerIndex<numberOfPlayers ;playerIndex++)
            players[playerIndex]=new Player();
    }

    public void startGame()
    {
        createPlayers();
        board = new Board(numberOfPlayers);
        board.printSnakesLadders();
        play();
    }

    public void playTurn() {
        currentPlayerIndex = currentPlayerIndex % numberOfPlayers;
        Player currentPlayer = players[currentPlayerIndex];
        int position = currentPlayer.position;
        int diceValue = currentPlayer.rollDice(dice, currentPlayerIndex);
        position = board.updatePosition(currentPlayerIndex, position, diceValue);
        currentPlayer.position = position;
    }

    public void play()
    {
        while(!stopGame)
        {
            playTurn();
            if(isGameFinished())
                printerAndScanner.printWinner(currentPlayerIndex+1);
            printerAndScanner.displayPositions(players);
            currentPlayerIndex++;
        }
    }


    public boolean isGameFinished()
    {
        stopGame = players[currentPlayerIndex].position==board.boardSize;
        return stopGame;
    }
}
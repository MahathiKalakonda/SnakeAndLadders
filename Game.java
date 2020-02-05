class Game
{
    int currentPlayerIndex = 0, numberOfPlayers;
    int currentPlayerId = currentPlayerIndex+1;
    Dice dice = new Dice();
    Board board;
    boolean stopGame = false;
    Player players[];
    PrinterAndScanner printerAndScanner=new PrinterAndScanner();

    public void start()
    {
        createPlayers();
        board = new Board(numberOfPlayers);
        board.printSnakesLadders();
        play();
    }

    void createPlayers() 
    {
        numberOfPlayers = printerAndScanner.getNumberOfPlayers();
        Player temperoryPlayers[] = new Player[numberOfPlayers];
        for(int playerIndex = 0; playerIndex<numberOfPlayers; playerIndex++)
            temperoryPlayers[playerIndex] = new Player();
        players=temperoryPlayers;
    }

    public void play()
    {
        while(!stopGame)
        {
            playTurn();
            if(isGameFinished())
                printerAndScanner.printWinner(currentPlayerId);
            printerAndScanner.displayPositions(players);
            changePlayerTurn();
        }
    }

    public void playTurn() 
    {
        currentPlayerIndex = currentPlayerIndex % numberOfPlayers;
        currentPlayerId = currentPlayerIndex+1;
        Player currentPlayer = players[currentPlayerIndex];
        int position = currentPlayer.position;
        int diceValue = currentPlayer.rollDice(dice, currentPlayerIndex);
        position = board.updatePosition(currentPlayerIndex, position, diceValue);
        currentPlayer.position = position;
    }

    public boolean isGameFinished()
    {
        stopGame = isPlayerInLastPosition();
        return stopGame;
    }

    boolean isPlayerInLastPosition()
    {
        return players[currentPlayerIndex].position == board.boardSize;
    }

    void changePlayerTurn()
    {
        currentPlayerIndex++;
    }
}
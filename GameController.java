class GameController
{
    boolean status=false;
    int currentPlayer=0,numberOfPlayers;
    Dice dice=new Dice();
    Player players[];
    Board board;
    PrintAndScan printAndGet=new PrintAndScan();

    public void startGame()
    {
        numberOfPlayers=printAndGet.getPlayersNumber();
        players=new Player[numberOfPlayers];
        for(int playerNumber=0;playerNumber<numberOfPlayers;playerNumber++)
            players[playerNumber]=new Player();
        board = new Board(numberOfPlayers);
        board.displaySnakesLadders();
        takeInputs();
    }

    public void takeInputs()
    {
        while(status==false)
        {
            currentPlayer=currentPlayer%numberOfPlayers;
            int Position=players[currentPlayer].position;
            int diceValue=players[currentPlayer].rollDice(dice,currentPlayer);
            Position=board.updatePosition(Position,diceValue,currentPlayer);
            players[currentPlayer].position=Position;
            isGameFinished();
        }
    }


    public void isGameFinished()
    {
        if(players[currentPlayer].position==board.boardSize)
        {
            printAndGet.printWinner(currentPlayer+1);
            status=true;
        }
        printAndGet.displayPositions(players);
        currentPlayer++;
    }
}
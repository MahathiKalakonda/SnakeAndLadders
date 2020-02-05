class Board
{
    int boardSize = 30;
    int playersInBoard[];
    Snake snakes[] = new Snake[4];
    Ladder ladders[] = new Ladder[4];
    PrinterAndScanner print = new PrinterAndScanner();
    
    Board()
    {
        playersInBoard = new int[2];
    }

    Board(int numberOfPlayers)
    {
        createSnakes();
        createLadders();
        playersInBoard = new int[numberOfPlayers];
    }

    void createSnakes()
    {
        snakes[0] = new Snake(17,4);
        snakes[1] = new Snake(19,7);
        snakes[2] = new Snake(21,9);
        snakes[3] = new Snake(27,1);
    }

    void createLadders()
    {
        ladders[0] = new Ladder(3,22);
        ladders[1] = new Ladder(5,8);
        ladders[2] = new Ladder(11,26);
        ladders[3] = new Ladder(20,29);
    }

    public int updatePosition(int currentPlayer, int position, int diceValue)
    {
        int resultPosition = position+diceValue;
        if(resultPosition > boardSize)
            return position;
        int currentPosition = positionInSnakesLadders(resultPosition);
        if(resultPosition != currentPosition)
            resultPosition = currentPosition;
        playersInBoard[currentPlayer] = resultPosition;
        return resultPosition;
    }

    public int positionInSnakesLadders(int resultPosition)
    {
        int snakeTail = PositionInSnakes(resultPosition);
        int ladderUpEnd = PositionInLadders(resultPosition);
        if(snakeTail != resultPosition)
            return snakeTail;
        if(ladderUpEnd != resultPosition)
            return ladderUpEnd;
        return resultPosition;
    }

    public int PositionInSnakes(int resultPosition)
    {
        for(int snake=0; snake<4; snake++)
        {   
            if(resultPosition == snakes[snake].head)
                return snakes[snake].tail;
        }
        return resultPosition;
    }

    public int PositionInLadders(int resultPosition)
    {
        for(int ladder=0; ladder<4; ladder++)
        {
            if(resultPosition == ladders[ladder].lowEnd)
                return ladders[ladder].upEnd;
        }
        return resultPosition;
    }

    void printSnakesLadders()
    {
        print.printSnakes(snakes);
        print.printLadders(ladders);
    }
}
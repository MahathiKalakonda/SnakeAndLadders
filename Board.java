class Board
{
    int boardSize=30;
    int playersInBoard[];
    Snake snakes[]=new Snake[4];
    Ladder ladders[]=new Ladder[4];
    
    Board()
    {
        playersInBoard=new int[2];
    }

    Board(int numberOfPlayers)
    {
        snakes[0]=new Snake(17,4);
        snakes[1]=new Snake(19,7);
        snakes[2]=new Snake(21,9);
        snakes[3]=new Snake(27,1);
        ladders[0]=new Ladder(3,22);
        ladders[1]=new Ladder(5,8);
        ladders[2]=new Ladder(11,26);
        ladders[3]=new Ladder(20,29);
        playersInBoard=new int[numberOfPlayers];
    }

    public int updatePosition(int currentPosition,int diceValue,int currentPlayer)
    {
        int resultPosition=currentPosition+diceValue;
        if(resultPosition>boardSize)
            return currentPosition;
        while(resultPosition!=isInSnakesLadders(resultPosition))
            resultPosition=isPositionInSnakes(resultPosition);
        playersInBoard[currentPlayer]=resultPosition;
        return resultPosition;
    }

    public int isInSnakesLadders(int resultPosition)
    {
        int snakeTail=isPositionInSnakes(resultPosition);
        int ladderUpEnd=isPositionInLadders(resultPosition);
        if(snakeTail!=resultPosition)
            resultPosition=snakeTail;
        if(ladderUpEnd!=resultPosition)
            resultPosition=ladderUpEnd;
        return resultPosition;
    }

    public int isPositionInSnakes(int resultPosition)
    {
        for(int snakeNumber=0;snakeNumber<4;snakeNumber++)
            if(resultPosition==snakes[snakeNumber].head)
                return snakes[snakeNumber].tail;
        return resultPosition;
    }

    public int isPositionInLadders(int resultPosition)
    {
        for(int ladderNumber=0;ladderNumber<4;ladderNumber++)
            if(resultPosition==ladders[ladderNumber].lowEnd)
                return ladders[ladderNumber].upEnd;
        return resultPosition;
    }
}
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
        int resultantPosition=currentPosition+diceValue;
        if(resultantPosition>boardSize)
            return currentPosition;
        while(resultantPosition!=isPositionInSnakes(resultantPosition) || resultantPosition!=isPositionInLadders(resultantPosition))
        {
            resultantPosition=isPositionInSnakes(resultantPosition);
            resultantPosition=isPositionInLadders(resultantPosition);
        }
        return resultantPosition;
    }

    public int isPositionInSnakes(int resultantPosition)
    {
        for(int snakeNumber=0;snakeNumber<4;snakeNumber++)
        {
            if(resultantPosition==snakes[snakeNumber].head)
            {
                System.out.println("Swallowed by snake");
                return snakes[snakeNumber].tail;
            }
        }
        return resultantPosition;
    }

    public int isPositionInLadders(int resultantPosition)
    {
        for(int ladderNumber=0;ladderNumber<4;ladderNumber++)
        {
            if(resultantPosition==ladders[ladderNumber].lowerEnd)
            {
                System.out.println("Climbed the ladder");
                return ladders[ladderNumber].upperEnd;
            }
        }
        return resultantPosition;
    }
}
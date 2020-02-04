class Board
{
    int boardSize=30;
    int playersInBoard[];
    Snake snakes[]=new Snake[4];
    Ladder ladders[]=new Ladder[4];
    PrintAndScan print=new PrintAndScan();
    
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
        int position=isInSnakesLadders(resultPosition);
        if(resultPosition!=position)
            resultPosition=position;
        playersInBoard[currentPlayer]=resultPosition;
        return resultPosition;
    }

    public int isInSnakesLadders(int resultPosition)
    {
        int snakeTail=isPositionInSnakes(resultPosition);
        int ladderUpEnd=isPositionInLadders(resultPosition);
        if(snakeTail!=resultPosition)
            return snakeTail;
        if(ladderUpEnd!=resultPosition)
        {
            System.out.println(ladderUpEnd);
            return ladderUpEnd;
        }
        return resultPosition;
    }

    public int isPositionInSnakes(int resultPosition)
    {
        for(int snake=0;snake<4;snake++)
        {   
            if(resultPosition==snakes[snake].head)
                return snakes[snake].tail;
        }
        return resultPosition;
    }

    public int isPositionInLadders(int resultPosition)
    {
        for(int ladder=0;ladder<4;ladder++)
        {
            if(resultPosition==ladders[ladder].lowEnd)
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
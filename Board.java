class Board
{
    int boardSize=30;
    int playersInBoard[];
    Snake snakes[]=new Snake[4];
    Ladder ladders[]=new Ladders[4];
    Board(int numberOfPlayers)
    {
        playersInBoard=new int[numberOfPlayers];
    }
    public int updatePosition(int currentPosition,int diceValue,int currentPlayer)
    {
        if(currentPosition+diceValue>boardSize)
            return currentPosition;
        
    }
}
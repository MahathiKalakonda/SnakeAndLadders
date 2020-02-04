import java.util.Scanner;
class GameController
{
    boolean status=false;
    int currentPlayer=0,numberOfPlayers;
    Dice dice=new Dice();
    Scanner scanner=new Scanner(System.in);

    public void startGame()
    {
        System.out.println("Enter number of Players between 2 and 6");
        numberOfPlayers=scanner.nextInt();
        Player players[]=new Player[numberOfPlayers];
        for(int playerNumber=0;playerNumber<numberOfPlayers;playerNumber++)
            players[playerNumber]=new Player();
        Board board = new Board(numberOfPlayers);
        takeInputs();
    }

    public void takeInputs()
    {
        while(status==false)
        {
            int currentPosition=players[(currentPlayer%numberOfPlayers)+1].position;
            int diceValue=players[(currentPlayer%numberOfPlayers)+1].rollDice(dice);
            players[(currentPlayer%numberOfPlayers)+1].position=board.updatePosition(currentPosition,diceValue);
            isGameFinished();
            currentPlayer++;
        }
    }

    public void Display()
    {
        for(int playerNumber=0;playerNumber<numberOfPlayers;playerNumber++)
            System.out.println("Position of Player "+  (playerNumber+1)+" is "+players[playerNumber].position);
    }

    public void isGameFinished()
    {
        if(players[(currentPlayer%numberOfPlayers)+1].position==board.boardSize)
        {
            System.out.println("Player "+((currentPlayer%numberOfPlayers)+1)+" won the game");
            status=true;
        }
        Display();
    }
}
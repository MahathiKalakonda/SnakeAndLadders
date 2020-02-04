import java.util.Scanner;
class GameController
{
    boolean status=false;
    int currentPlayer=0,numberOfPlayers;
    Dice dice=new Dice();
    Scanner scanner=new Scanner(System.in);
    Player players[];
    Board board;

    public void startGame()
    {
        System.out.println("Enter number of Players between 2 and 6");
        numberOfPlayers=scanner.nextInt();
        players=new Player[numberOfPlayers];
        for(int playerNumber=0;playerNumber<numberOfPlayers;playerNumber++)
            players[playerNumber]=new Player();
        board = new Board(numberOfPlayers);
        takeInputs();
    }

    public void takeInputs()
    {
        while(status==false)
        {
            int currentPosition=players[currentPlayer%numberOfPlayers].position;
            int diceValue=players[currentPlayer%numberOfPlayers].rollDice(dice,currentPlayer%numberOfPlayers);
            players[currentPlayer%numberOfPlayers].position=board.updatePosition(currentPosition,diceValue,currentPlayer%numberOfPlayers);
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
        if(players[currentPlayer%numberOfPlayers].position==board.boardSize)
        {
            System.out.println("Player "+((currentPlayer%numberOfPlayers)+1)+" won the game");
            status=true;
        }
        Display();
    }
}
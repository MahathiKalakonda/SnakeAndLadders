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
        board.displaySnakesLadders();
        takeInputs();
    }

    public void takeInputs()
    {
        while(status==false)
        {
            currentPlayer=currentPlayer%numberOfPlayers;
            int currentPosition=players[currentPlayer].position;
            int diceValue=players[currentPlayer].rollDice(dice,currentPlayer);
            players[currentPlayer].position=board.updatePosition(currentPosition,diceValue,currentPlayer);
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
        if(players[currentPlayer].position==board.boardSize)
        {
            System.out.println("Player "+((currentPlayer)+1)+" won the game");
            status=true;
        }
        Display();
    }
}
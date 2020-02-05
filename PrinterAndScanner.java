import java.util.Scanner;
class PrinterAndScanner
{
    Scanner scanner = new Scanner(System.in);

    public int getNumberOfPlayers()
    {
        System.out.println("Enter number of Players between 2 and 6");
        int numberOfPlayers = scanner.nextInt();
        return numberOfPlayers;
    }

    String getPlayerChoice(int player)
    {
        System.out.println("Player "+player+ " enter 'roll' to roll the dice");
        String choice = scanner.nextLine();
        return choice;
    }

    public void printDice(int diceValue)
    {
        System.out.println("Dice value is :"+diceValue);
    }

    public void printWinner(int player)
    {
        System.out.println("Player "+player+" won the game");
    }

    public void displayPositions(Player players[])
    {
        for(int player = 1; player<players.length+1; player++)
        {
            int position = players[player-1].position;
            System.out.println("Position of Player "+player+" is "+position);
        }
    }

    public void printSnakes(Snake snakes[])
    {
        for(int snake = 0; snake<snakes.length; snake++)
        {
            int head = snakes[snake].getHead();
            int tail = snakes[snake].getTail();
            System.out.println("Snake from "+head+" to "+tail);
        }
    }

    public void printLadders(Ladder ladders[])
    {
        for(int ladder = 0; ladder<ladders.length; ladder++)
        {
            int lowEnd = ladders[ladder].getLowEnd();
            int upEnd = ladders[ladder].getUpEnd();
            System.out.println("Ladder from "+lowEnd+" to "+upEnd);
        }
    }
}
import java.util.Scanner;
class PrintAndScan
{
    Scanner scanner=new Scanner(System.in);

    Character playerChoice(int player)
    {
        System.out.println("Player "+player+ " enter 'roll' to roll the dice");
        Character choice=playerChoice((scanner.nextLine()).charAt(0));
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

    public int getPlayersNumber()
    {
        System.out.println("Enter number of Players between 2 and 6");
        int numberOfPlayers=scanner.nextInt();
        return numberOfPlayers;
    }

    public void displayPositions(Player players[])
    {
        for(int player=1;player<players.length+1;player++)
        {
            int position=players[player-1].position;
            System.out.println("Position of Player "+player+" is "+position);
        }
    }

    public void printSnakesLadders(Snake snakes[],Ladder ladders[])
    {
        for(int snake=0;snake<snakes.length;snake++)
            System.out.println("Snake from "+snakes[snake].head+" to "+snakes[snake].tail);
        for(int ladder=0;ladder<ladders.length;ladder++)
            System.out.println("Ladder from "+ladders[ladder].lowEnd+" to "+ladders[ladder].upEnd);
    }
}
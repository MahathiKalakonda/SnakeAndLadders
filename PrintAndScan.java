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

    
}
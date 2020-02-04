import java.util.Scanner;
class Player
{
    int position=0,diceValue=0;
    Character choice;
    Scanner scanner=new Scanner(System.in);
    
    public int rollDice(Dice dice,int currentPlayer)
    {
        System.out.println("Player "+(currentPlayer+1)+ " enter  'roll' to roll the dice");
        choice=((scanner.nextLine()).charAt(0));
        if(choice!=null)
            diceValue=dice.generateMove();
        System.out.println("Dice value is "+diceValue);
        return diceValue;
    }
}
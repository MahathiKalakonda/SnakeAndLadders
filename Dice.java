import java.lang.Math; 
class Dice
{
    int minimumDiceValue=1,rangeOfDice=6;
    public int generateMove()
    {
        int diceValue=(int)(Math.random() * rangeOfDice) + minimumDiceValue;
        return diceValue;
    }
}
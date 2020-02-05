import java.lang.Math; 
class Dice
{
    int minimumDiceValue = 1, maximumDiceValue = 6;

    public int generateMove()
    {
        int diceValue = (int)(Math.random()*maximumDiceValue) +minimumDiceValue;
        return diceValue;
    }
}
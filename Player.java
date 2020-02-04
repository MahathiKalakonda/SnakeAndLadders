class Player
{
    int position=0;
    public int rollDice(Dice dice)
    {
        int diceValue=dice.generateMove();
        return diceValue;
    }
}
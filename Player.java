class Player
{
    int position=0,diceValue=0;
    Character choice;
    PrintAndScan printAndGet=new PrintAndScan();
    
    public int rollDice(Dice dice,int currentPlayer)
    {
        choice=printAndGet.playerChoice(currentPlayer+1);
        if(choice!=null)
            diceValue=dice.generateMove();
        printAndGet.printDice(diceValue);
        return diceValue;
    }
}
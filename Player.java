class Player
{
    int position=0,diceValue=0;
    Character choice;
    PrinterAndScanner printerAndScanner=new PrinterAndScanner();
    
    public int rollDice(Dice dice,int currentPlayer)
    {
        choice=printerAndScanner.playerChoice(currentPlayer+1);
        if(choice!=null)
            diceValue=dice.generateMove();
        printerAndScanner.printDice(diceValue);
        return diceValue;
    }
}
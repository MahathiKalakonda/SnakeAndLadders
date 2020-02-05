class Player
{
    int position = 0;
    PrinterAndScanner printerAndScanner = new PrinterAndScanner();
    
    public int rollDice(Dice dice, int currentPlayer)
    {
        int diceValue = 0, currentPlayerId = currentPlayer + 1 ;
        String choice = printerAndScanner.playerChoice(currentPlayerId);
        if(choice.equals("roll"))
            diceValue = dice.generateMove();
        printerAndScanner.printDice(diceValue);
        return diceValue;
    }
}
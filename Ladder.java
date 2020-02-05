class Ladder
{
    int lowEnd, upEnd;

    Ladder()
    {
        this.lowEnd = 0;
        this.upEnd = 0;
    }

    Ladder(int lowerEnd,int upperEnd)
    {
        this.lowEnd = lowerEnd;
        this.upEnd = upperEnd;
    }

    int getUpEnd()
    {
        return upEnd;
    }

    int getLowEnd()
    {
        return lowEnd;
    }
}
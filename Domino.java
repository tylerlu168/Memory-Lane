public class Domino
{
    private int top, bottom;
    private boolean revealed;

    /**
     * Constructs an unrevealed Domino from x and y.
     *      The minimum of x and y is top number.
     *      The maximum of x and y is the bottom number.
     * @param x
     * @param y
     */
    public Domino(int x, int y)
    {
        this.top = Math.min(x, y); //This finds the minimum number between the two parameters

        this.bottom = Math.max(x, y); //This finds the maximum number between the two parameters

    }

    /**
     * @return top
     */
    public int getTop() //getter
    {
        return this.top;
    }

    /**
     * @return bottom
     */
    public int getBottom() //getter
    {
        return this.bottom;
    }

    /**
     * @return revealed
     */
    public boolean isRevealed()
    {
        return this.revealed;
    }

    /**
     * Sets revealed to the specified value
     * @param revealed
     */
    public void setRevealed(boolean revealed)
    {
        this.revealed = revealed;
    }

    /**
     * Returns true if this Domino has the same top and bottom as other
     * @param other
     * @return
     */
    public boolean equals(Domino other)
    {
        if(this.top == other.getTop() && this.bottom == other.getBottom())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
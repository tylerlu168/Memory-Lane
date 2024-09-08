import java.util.Random;

public class MemoryLane
{
    private Domino[] board;

    /**
     * Constructs a Memory Lane game with max^2 + max Dominoes.
     *
     *      Example: max <-- 2
     *              [1] [1] [1] [1] [2] [2]
     *              [1] [1] [2] [2] [2] [2]
     *
     *      Example: max <-- 3
     *              [1] [1] [1] [1] [1] [1] [2] [2] [2] [2] [3] [3]
     *              [1] [1] [2] [2] [3] [3] [2] [2] [3] [3] [3] [3]
     *
     * Postcondition: board is random
     *
     * @param max the largest number of pips on the Dominoes
     */
    public MemoryLane(int max) // creating Domino board & shuffle
    {
        int length = (max * max) + max; //length of domino array
        Domino[] board_temp = new Domino[length]; //creates a temporary board which will shuffle then be assigned to the real board
        board = new Domino[length];
        int i = 0;
        for (int top = 1; top <= max; top++)
        {
            for (int bottom = top; bottom <= max; bottom++)
            {
                board_temp[i] = new Domino(top, bottom);
                board_temp[i + 1] = new Domino(top, bottom);
                i += 2;
            }
        }

        //shuffle

        Random rand = new Random();
        int[] shuffle = new int[length];

        for (int j = 0; j < length; j++)
        {
            int random = rand.nextInt(length);
            shuffle[j] = random;
            for (int k = j - 1; k >= 0; k--)
            {
                int check = 0;
                while(shuffle[k] == random)
                {
                    check = 1;
                    random = rand.nextInt(length);
                    shuffle[j] = random;
                }
                if(check == 1)
                k = j;
            }
            board[j] = board_temp[random]; //assigns temporary board to real board
        }






    }
// Below method was not used as shuffle was created in the method above
//    /**
//     * Shuffles board
//     * Precondition: board does not contain null elements
//     *
//     * @return
//     */
//    /*private void shuffle()
//    {
//
//    }
//   */
//
  /**
    * Reveals the Dominoes at index i and k if they match
    *
    * @param i
    * @param k
    * @return true if the Dominoes at i and k match; false otherwise
    */
    public boolean guess(int i, int k) //boolean
    {
        if(board[i].getTop() == board[k].getTop() && board[i].getBottom() == board[k].getBottom())
        {
            board[i].setRevealed(true);
            board[k].setRevealed(true);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Returns a String representation of the Dominoes at the specified indexes
     *      in the following format:
     *
    *          [top] [top]
     *          [bot] [bot]
     *
     * Precondition: the elements at the specified indexes are not null
     *
     * @param a
     * @param b
     * @return
     */
    public String peek(int a, int b)
    {
        String sneakpeek = "[" + board[a].getTop() + "]" + "[" + board[b].getTop() + "]\n" +
                "[" + board[a].getBottom() + "]" + "[" + board[b].getBottom() + "]";
        return sneakpeek; // returns a string
    }

    /**
     * @return true if the number of revealed Dominoes is equal to the
     *          length of the board
     */
    public boolean gameOver()
    {
        int count = 0;
        for (int i = 0 ; i < board.length; i++){
            if (board[i].isRevealed())
                count += 1;
        }

        if(count == board.length) //checks if the length of board is equal to the count of revealed dominos
        {
            return true;
        }
        return false;
    }

    /**
     * Returns a String representation of the board in the following format:
     *
     *        0     1     2     3     4     5
     *      [top] [   ] [top] [   ] [top] [top]
     *      [bot] [   ] [bot] [   ] [bot] [bot]
     *
     * Note: the top and bottom numbers of an unrevealed Domino are represented with
     *          an empty space
     *
     * @return
     */
    /* Space if hasn't been picked
    Hashtag if has been pick but it does not match
    Actual domino if picked and matched
     */
    // */
  //  */
   //  */
    public String toString() //prints code
    {
        String rtn = "";
        for (int i = 0; i  < board.length; i++){
            rtn = rtn + " " + i + "  " ;
        }
        rtn = rtn + "\n";

        for (int i = 0; i < board.length; i++)
        {
            if(board[i].isRevealed())
            {
                rtn = rtn + "[" + board[i].getTop() + "] " ;
            }
            else {
                rtn = rtn + "[ ] " ;
            }
        }

        rtn = rtn + "\n";

        for (int i = 0; i < board.length; i++)
        {
            if(board[i].isRevealed())
            {
                rtn = rtn + "[" + board[i].getBottom() + "] ";
            }
            else
            {
                rtn = rtn + "[ ] ";
            }
        }
        return rtn;


    }

}


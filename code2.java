
/**
 * Write a description of class code2 here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
  
public class code2
{
    int board[][] = new int[8][8];
    int c = 0;
    public code2()
    {
        int board[][] = new int[8][8];
    }
 
    private boolean isSafe(int x, int y)
    {
        if (x >= 0 && x < board.length && y >= 0 && y < board.length && board[x][y] == -1)
            return true;
        return false;
    }
 
    private void printSolution()
    {
        for (int row = 0; row < board.length; row++)
        {
            for (int col = 0; col < board[0].length; col++)
            {
                System.out.print("  " + board[row][col]);
            }
            System.out.println();
        }
    }
 
    private boolean solveKTUtil(int x, int y, int movei, int xMove[],int yMove[])
    {
        int k, next_x, next_y;
        if (movei == board.length * board[0].length)
            return true;
 
        for (k = 0; k < board.length; k++)
        {
            next_x = x + xMove[k];
            next_y = y + yMove[k];
            if (isSafe(next_x, next_y))
            {
                board[next_x][next_y] = movei;
                if (solveKTUtil(next_x, next_y, movei + 1, xMove, yMove))
                    return true;
                else
                    board[next_x][next_y] = -1;
            }
        }
        return false;
    }
 
    public boolean solveKnightTour()
    {
        for (int row1 = 0; row1 < board.length; row1++)
        {
            for (int col1 = 0; col1 < board[0].length; col1++)
            {
                board[row1][col1] = -1;
            }
        }
        int xMove[] = { 2, 1, -1, -2, -2, -1, 1, 2 };
        int yMove[] = { 1, 2, 2, 1, -1, -2, -2, -1 };
        board[0][0] = 0;
        if (!solveKTUtil(0, 0, 1, xMove, yMove))
        {
            System.out.println("the solution does not exist");
            return false;
        }
        else
        {
            printSolution();
        }
        return true;
    }
 
    public static void main(String... arg)
    {
        code2 Code = new code2();
        System.out.println("the solution is");
        Code.solveKnightTour();
    }
}

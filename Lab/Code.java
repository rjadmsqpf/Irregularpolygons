import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Code
{
    Scanner in;
    int[][]matrix = new int[20][20];
    public Code()
    {
        try
        {
            in = new Scanner(new File("digital.txt"));
            String test = in.nextLine();
            System.out.println(test);
        }
        catch(IOException i)
        {
            System.out.println("Error: " + i.getMessage());
        }
        //fill 2darray with 0s
        for(int row = 0; row < matrix.length; row++)
        {
            for(int col = 0; col < matrix[0].length; col++)
            {
                matrix[row][col]=0;
            }
        }
        //set values to 1 corresponding coordinate
        while(in.hasNext())
        {
            int a = in.nextInt()-1;
            int b = in.nextInt()-1;
            matrix[a][b] = 1;
        }
    }

    public void print()
    {
        System.out.print('\u000C');
        System.out.println("  12345678901234567890");
        for(int row = 0; row < matrix.length; row++){//goes through each row prints 1 and cycles
            System.out.print((row+1) + " ");
            for(int col = 0; col< matrix[0].length; col++){//checks if it has a 0/1
                int value = matrix[row][col];
                if(value == 1){
                    System.out.print("@");
                }else{
                    System.out.print("-");
                }                
            }
            System.out.println("");
        }
    }
    public void eraser(int r, int c){
        erase(r-1,c-1);
        print();
    }
    public void erase(int r, int c){
        if(matrix[r][c] == 1)
        {
            matrix[r][c] = 0;
            if(r!=0 && r!=19)
            {
                erase(r-1,c);
                erase(r+1,c);
                if(c!=0 && c!=19)
                {
                    erase(r,c+1);
                    erase(r,c-1);
                }
                else
                {
                    if(c==19)
                    {
                        erase(r,c-1);
                    }
                    else if(c==0)
                    {
                        erase(r,c+1);
                    }
                }
            }
            else
            {
                if(r==0)
                {
                    erase(r+1,c);
                }
                else if(r==19)
                {
                    erase(r-1,c);
                }
            }        
        }
    }
}

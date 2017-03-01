import java.io.BufferedReader;
import java.io.InputStreamReader;

class m2945
{
    int[][] tab = new int[12][10];
    int mark = (int)'+', emptyCell = (int)'o';
    
    private int getNBalls()
    {
        int balls = 0;
        for(int r=0; r<12; r++)
        {
            for(int c=0; c<10; c++)
            {
                if (tab[r][c]!=emptyCell) balls++;
            }
        }
        return balls;
    }
    
    private void setRow(int r, String rowColors)
    {
        for(int c=0; c<10; c++)
        {
            tab[r][c] = (int)rowColors.charAt(c);
        }
    }
    
    private void click(int r, int c)
    {
        int color = tab[r][c];
        int total = mark(r, c, color);
        
        if (total == 0) return;
        if (total < 3) unmark(r,c,color);
        else {
            blow(r, c);
            adjust();
        }
    }
    
    private int mark(int r, int c, int color)
    {
        if (r<0 || c<0 || r>11 || c>9)
            return 0;
        if (tab[r][c]!=color)
            return 0;
        
        int total = 1;
        tab[r][c] = mark;
        total+=mark(r-1,c,color);
        total+=mark(r+1,c,color);
        total+=mark(r,c-1,color);
        total+=mark(r,c+1,color);
        return total;
    }
    
    private void unmark(int r, int c, int color)
    {
        if (r<0 || c<0 || r>11 || c>9)
            return;
        if (tab[r][c]!=mark)
            return;
        
        tab[r][c] = color;
        unmark(r-1,c,color);
        unmark(r+1,c,color);
        unmark(r,c-1,color);
        unmark(r,c+1,color);
    }
    
    private void blow(int r, int c)
    {
        if (r<0 || c<0 || r>11 || c>9)
            return;
        if (tab[r][c]!=mark)
            return;
        
        tab[r][c] = emptyCell;
        blow(r-1,c);
        blow(r+1,c);
        blow(r,c-1);
        blow(r,c+1);
    }
    
    private void adjust()
    {
        for(int c =0; c<10; c++)
            adjustCol(c);
        adjustEmptyCols();
    }
    
    private void adjustCol(int c)
    {
        int nextEmptyRow = -1;
        for (int r = 0; r < 12; r++)
        {
            if (nextEmptyRow==-1)
            {
                if (tab[r][c] == emptyCell)
                {
                    nextEmptyRow = r;
                }
            }
            else
            {
                if (tab[r][c] != emptyCell)
                {
                    tab[nextEmptyRow][c] = tab[r][c];
                    tab[r][c] = emptyCell;
                    nextEmptyRow++;
                }
            }
        }
    }
    
    private void adjustEmptyCols()
    {
        int nextEmptyCol = -1;
        for (int c = 0; c < 10; c++)
        {
            if (nextEmptyCol==-1)
            {
                if (tab[0][c] == emptyCell)
                {
                    nextEmptyCol = c;
                }
            }
            else
            {
                if (tab[0][c] != emptyCell)
                {
                    // move all column to nextEmptyCol
                    for (int r = 0; r < 12; r++)
                    {
                        tab[r][nextEmptyCol] = tab[r][c];
                        tab[r][c] = emptyCell;
                    }
                    nextEmptyCol++;
                }
            }
        }
    }
    
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        for(int r = 11; r>=0; r--)
        {
            for(int c=0; c<10; c++)
            {
                sb.append((char)tab[r][c]);
            }
            sb.append(System.getProperty("line.separator"));
        }
        return sb.toString();
    }
    
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int moves = Integer.parseInt(line);
        int r = 0, c =0;
        m2945 game = new m2945();
        
        while(moves>0)
        {
            for(int i = 11; i>=0; i--)
            {
                line = br.readLine();
                game.setRow(i, line);
            }
            
            //System.out.println(game.toString());
            
            while(moves-->0)
            {
                line = br.readLine();
                c = ((int)(line.split(" ")[0].charAt(0))) - ((int)'a') + 1;
                r = Integer.parseInt(line.split(" ")[1]);
                
                //System.out.println("clicking ("+r+","+c+")");
                game.click(r-1,c-1);
                //System.out.println(game.toString());
            }
            
            System.out.println(game.getNBalls());
            
            line = br.readLine();
            moves = Integer.parseInt(line);
        }
    }
}
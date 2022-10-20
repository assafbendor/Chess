import java.util.Arrays;

public class Game {
    private Board [] positions;

    public Game(){
        this.positions = new Board [1];
        this.positions[0] = new Board();
        this.positions[0].setStartingPosition();
    }

    public void setPositions(Board board)
    {
        positions = new Board[this.positions.length + 1];
        for (int index = 0; index < this.positions.length; index ++)
        {
            positions[index] = this.positions[index];
        }
        positions[positions.length - 1] = board;
        this.positions = positions;
    }

    public Board [] getPositions()
    {
        return this.positions;
    }

    public boolean checkMovesRepetition()
    {
        int sum = 0;
        for(int index = 0; index < this.positions.length; index ++)
        {
            if (positions[index] == positions[positions.length - 1])
                sum ++;
        }
        return sum >= 3;
    }
    public int turn(){
        return (this.positions.length - 1) % 2;
    }
}

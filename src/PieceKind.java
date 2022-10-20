import org.jetbrains.annotations.NotNull;

public class PieceKind {
    private Square [] PawnMoves = new Square [4];
    private int num;
    private Square [] moves;
    private Square [] rockMoves;
    private Square [] bishopMoves;
    private Square [] queenMoves;

    public PieceKind(Square square, int num, Square [][] squares)
    {
        this.PawnMoves [0] = new Square(square.getX(), square.getY() + 1);// כאן צריך להעביר את הטיפוס ממשבצת חדשה למשבצת קיימת מהלוח. כמו כן צריך להשלים עוד מהלכים של החייל
        this.num = num;
        this.moves = getMoves(num);
        int sum = 0;
        this.rockMoves = new Square[16];
        this.bishopMoves = new Square[16];//אני צריך עוד לחשוב טיפה איך מחשבים ביעילות את המשבצות של הרץ
        for (int index = 0; index < squares.length; index ++)
        {
            for (int i = 0; i < squares[0].length; i ++)
            {
                if (squares[index][i].getX() == square.getX() || squares[index][i].getY() == square.getY())
                {
                    this.rockMoves[sum] = square;
                    sum ++;
                }
            }
        }
        this.queenMoves = new Square[32];
        for (int index = 0; index < this.rockMoves.length; index ++)
        {
            this.queenMoves[index] = this.rockMoves[index];
            this.queenMoves[31 - index] = this.bishopMoves[index];
        }
    }
    public Square [] getPawnMoves()
    {
        return this.PawnMoves;
    }
    public Square [] getRockMoves()
    {
        return this.rockMoves;
    }
    public Square [] getQueenMoves()
    {
        return this.queenMoves;
    }
    public Square [] getMoves(int num)//חשוב לזכור שהמערך כולל את המשבצת של הכלי עצמו, אני יכול להוריד את זה בקלות אבל אני חושב שאולי עדיף לדאוג לזה בשלב מאוחר יותר שבו נרכז את כל הבדיקות במקום אחד.
    {
        if (num == 0)
            return getPawnMoves();
        else if (num == 1)
            return this.getRockMoves();
        else if (num == 2)
            return this.getQueenMoves();
        else if (num == 3)
            return this.getQueenMoves();
        return null;
    }
    public boolean compereSquares(Square @NotNull [] squares)
    {
        return squares[0].getX() == squares[1].getX() && squares[0].getY() == squares[1].getY();
    }

}

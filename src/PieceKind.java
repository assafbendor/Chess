public class PieceKind {
    private Square[] PawnMoves = new Square[1];
    private int num;
    private Square[] moves;
    private Square[] rockMoves;

    public PieceKind(Square square, int num, Square[][] squares) {
        this.PawnMoves[0] = new Square(square.getX(), square.getY() + 1);
        this.num = num;
        this.moves = getMoves(num);
        int sum = 0;
        this.rockMoves = new Square[16];

        for (int index = 0; index < squares.length; index++) {
            for (int i = 0; i < squares[0].length; i++) {
                if (squares[index][i].getX() == square.getX() || squares[index][i].getY() == square.getY()) {
                    this.rockMoves[sum] = square;
                    sum++;
                }

            }
        }
    }

    public Square[] getPawnMoves() {
        return this.PawnMoves;
    }

    public Square[] getRockMoves() {
        return this.rockMoves;
    }

    public Square[] getMoves(int num) {
        if (num == 0)
            return getPawnMoves();
        else if (num == 1)
            return this.getRockMoves();
        return null;
    }

    public boolean compereSquares(Square[] squares) {
        return squares[0].getX() == squares[1].getX() && squares[0].getY() == squares[1].getY();
    }

}

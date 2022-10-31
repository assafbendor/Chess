public class Piece {
    private int color;
    private Square square;
    private Square[] moves;
    private boolean hasMoved;
    private boolean isInGame;
    private int num;

    public Piece(int color, Square square, int num, Square[][] squares) {
        this.color = color;
        this.square = square;
        this.hasMoved = false;
        this.isInGame = true;
        this.moves = new PieceKind(this.square, num, squares).getMoves(num);
        this.num = num;
    }

    public Square getSquare() {
        return this.square;
    }

    public Square[] getMoves() {
        return this.moves;
    }

    public int getColor() {
        return this.color;
    }

    public void setHasMoved() {
        this.hasMoved = true;
    }

    public boolean getIsInGame() {
        return this.isInGame;
    }

    public void hasTaken() {
        this.isInGame = false;
    }

    public boolean inRange(Square square) {
        for (int index = 0; index < this.moves.length; index++) {
            if (compereSquares(square, index))
                return true;
        }
        return false;
    }

    public boolean canTake(Board board, Square square) {
        if (this.inRange(square)) {
            if (board.locatePiece(square) == null)
                return true;
            return board.locatePiece(square).getColor() != this.getColor();
        }
        return false;
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public int getNum() {
        return this.num;
    }

    public boolean compereSquares(Square square, int num) {
        return this.moves[num].getX() == square.getX() && this.moves[num].getY() == square.getY();
    }

    public void movePiece(Square square) {
        this.square = square;
        hasMoved = true;
    }
}

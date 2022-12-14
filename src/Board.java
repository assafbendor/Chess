public class Board {
    private final Square[][] board;
    private final Piece[] pieces;

    public Board() {
        this.board = new Square[8][8];
        for (int index = 0; index < this.board.length; index++) {
            for (int i = 0; i < this.board[0].length; i++) {
                this.board[i][index] = new Square(i, index);
            }
        }
        this.pieces = new Piece[32];
    }

    public Square[][] getBoard() {
        return this.board;
    }

    public String toString() {
        String sum = "";
        for (int index = 0; index < this.board.length; index++) {
            for (int i = 0; i < this.board[0].length; i++) {
                sum += "    " + this.board[index][i].getColor();
            }
        }
        return sum;
    }

    public Piece locatePiece(Square square) {
        for (int index = 0; index < this.pieces.length; index++) {
            if (this.pieces[index].getIsInGame() && this.pieces[index].getSquare() == square)
                return this.pieces[index];
        }
        return null;
    }

    public void setStartingPosition() {
        int sum = 0;
        for (int index = 0; index < this.board.length; index++) {
            for (int i = 0; i < this.board[0].length; i++) {
                if (i == 1) {
                    this.pieces[sum] = new Piece(0, this.board[index][i], 0, getBoard());
                }

                else if (i == 6) {
                    this.pieces[sum] = new Piece(1, this.board[index][i], 0, getBoard());
                } else if (i == 0 && (index == 0 || index == 7)) {
                    this.pieces[sum] = new Piece(0, this.board[index][i], 0, getBoard());
                } else if (i == 7 && (index == 0 || index == 7)) {
                    this.pieces[sum] = new Piece(1, this.board[index][i], 1, getBoard());
                }

                else
                    sum--;
                sum++;
            }
        }
    }

    public String stringPiece() {
        String sum = "";
        for (int index = 0; index < this.pieces.length; index++) {
            if (this.pieces[index] != null) {
                sum += "Piece: " + index + " kind: " + this.pieces[index].getNum() + " piece-color:"
                        + this.pieces[index].getColor() + " \n     square: "
                        + this.pieces[index].getSquare().getString();
                sum += "\n ";
            }
        }
        return sum;
    }

    public Piece[] getPieces() {
        return pieces;
    }

    public String stringBoard() {
        String sum = "";

        for (int i = 0; i < 8; i++) {
            sum += "| | | | | | | | |\n";
        }

        String[] sumlst = sum.split("\n");

        for (int i = 0; i < 32; i++) {
            Piece piece = getPieces()[i];
            if (piece != null) {
                Square square = piece.getSquare();
                int x = square.getX();
                int y = square.getY();

                String before = sumlst[x].substring(0, y * 2 + 1);
                String after = sumlst[x].substring((y + 1) * 2);
                sumlst[x] = before + piece.getNum() + after;
            }
        }

        sum = "+-+-+-+-+-+-+-+-+\n";
        for (int i = 0; i < 8; i++) {
            sum += sumlst[i] + "\n+-+-+-+-+-+-+-+-+\n";
        }

        return ("Player1:\n" + sum + "Player2: ");
    }
}

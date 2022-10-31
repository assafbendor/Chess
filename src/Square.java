public class Square {
    private int color;
    private int x;
    private int y;

    public Square(int x, int y) {
        this.x = x;
        this.y = y;
        this.color = ((this.x + this.y) + 1) % 2;
    }

    public int getColor() {
        return this.color;
    }

    public void setColor() {
        this.color = this.x * this.y % 2 + 1;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setX(int x) {
        this.x = x;
        setColor();
    }

    public void setY(int y) {
        this.y = y;
        setColor();
    }

    public boolean inBoard() {
        return this.x >= 0 && this.x <= 7 && this.y >= 0 && this.y <= 7;
    }

    public String getString() {
        return " color: " + this.color + " x:" + this.x + " y: " + this.y;
    }
}

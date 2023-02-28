import javax.xml.crypto.dsig.keyinfo.KeyInfo;

public class Grid {
    public Cell[][] cells;
    private Integer dimension;
    private Integer x;
    private Integer y;
    private TetrominoType typeTetromino;

    public Integer getDimension() {
        return dimension;
    }

    public void setDimension(Integer dimension) {
        this.dimension = dimension;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public TetrominoType getTypeTetromino() {
        return typeTetromino;
    }

    public void setTypeTetromino(TetrominoType typeTetromino) {
        this.typeTetromino = typeTetromino;
    }
}
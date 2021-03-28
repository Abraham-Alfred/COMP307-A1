import java.util.List;

/**
 * This class handles the storage for
 * the "image.data" file.
 *
 * @author alfredabra 300509598
 **/

public class ImageObj {
    private String firstLine;
    private String secondLine;
    private int row;
    private int col;
    private boolean[][] pixelArr;
    private List<Integer> featureVector;

    /**
     * Constructor for the ImageObj class.
     *
     * @param fL fL
     * @param sL sL
     * @param r r
     * @param c c
     * @param pA pA
     **/
    public ImageObj(String fL, String sL, int r, int c, boolean[][] pA) {
        firstLine = fL;
        secondLine = sL;
        row = r;
        col = r;
        pixelArr = pA;
    }

    // ============================================================
    // Getters and setters.
    // ============================================================

    /**
     * Getter for FirstLine.
     *
     * @return firstLine firstLine
     **/
    public String getFirstLine() {
        return firstLine;
    }

    /**
     * Setter for FirstLine.
     *
     * @param firstLine firstLine
     **/
    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    /**
     * Getter for SecondLine.
     *
     * @return secondLine secondLine
     **/
    public String getSecondLine() {
        return secondLine;
    }

    /**
     * Setter for SecondLine.
     *
     * @param secondLine secondLine
     **/
    public void setSecondLine(String secondLine) {
        this.secondLine = secondLine;
    }

    /**
     * Getter for row.
     *
     * @return row row
     **/
    public int getRow() {
        return row;
    }

    /**
     * Setter for row.
     *
     * @param row row
     **/
    public void setRow(int row) {
        this.row = row;
    }

    /**
     * Getter for col.
     *
     * @return col col
     **/
    public int getCol() {
        return col;
    }

    /**
     * Setter for col.
     *
     * @param col col
     **/
    public void setCol(int col) {
        this.col = col;
    }

    /**
     * Getter for PixelArr.
     *
     * @return pixelArr pixelArr
     **/
    public boolean[][] getPixelArr() {
        return pixelArr;
    }

    /**
     * Setter for PixelArr.
     *
     * @param pixelArr pixelArr
     **/
    public void setPixelArr(boolean[][] pixelArr) {
        this.pixelArr = pixelArr;
    }

    /**
     * Getter for FeatureVector.
     *
     * @return featureVector featureVector
     **/
    public List<Integer> getFeatureVector() {
        return featureVector;
    }

    /**
     * Setter for FeatureVector.
     *
     * @param featureVector featureVector
     **/
    public void setFeatureVector(List<Integer> featureVector) {
        this.featureVector = featureVector;
    }
}

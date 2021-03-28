import java.util.Arrays;

/**
 * This class handles the features for
 * the "image.data" file.
 *
 * @author alfredabra 300509598
 **/

public class FeatureSet {
    int[] row;
    int[] col;
    boolean[] sgn;

    /**
     * Constructor for the ImageObj class.
     *
     * @param r r
     * @param c c
     * @param b b
     **/
    public FeatureSet(int[] r, int[] c, boolean[] b) {
        row = r;
        col = c;
        sgn = b;
    }

    /**
     * The value of the feature for a given image
     * (represented as a 2D Boolean array).
     *
     * @param img img
     **/
    public int value(boolean[][] img) {
        int sum = 0;
        for(int i = 0; i < 3; i++)
            if (img[row[i]] [col[i]] == sgn[i]){
                sum++;
            }
        return (sum >= 2) ? 1:0; //ternary operator
    }

    public String toString() {
        String str = "Feature: ";
        str += Arrays.toString(row);
        str += Arrays.toString(col);
        str += Arrays.toString(sgn);

        return str;
    }

    // ============================================================
    // Getters and setters.
    // ============================================================

    /**
     * Getter for row.
     *
     * @return row
     **/
    public int[] getRow() { return row; }

    /**
     * Setter for row.
     *
     * @param row row
     **/
    public void setRow(int[] row) { this.row = row; }

    /**
     * Getter for col.
     *
     * @return col
     **/
    public int[] getCol() { return col; }

    /**
     * Setter for col.
     *
     * @param col col
     **/
    public void setCol(int[] col) { this.col = col; }

    /**
     * Getter for sgn.
     *
     * @return sgn
     **/
    public boolean[] getSgn() { return sgn; }

    /**
     * Setter for sgn.
     *
     * @param sgn sgn
     **/
    public void setSgn(boolean[] sgn) { this.sgn = sgn; }
}

/**
 * This class helps the DecisionTree class by
 * handling and storing the data from the
 * training and test data files.
 *
 * @author alfredabra 300509598
 **/
public class TreeNode {
    private String className = null;
    private double probability = 0.0;
    private TreeNode leftChild = null;
    private TreeNode rightChild = null;
    private String bestCategory = null;

    /**
     * Constructor for the TreeNode class.
     *
     * @param cL cL
     * @param pR pR
     * @param lC lC
     * @param rC rC
     * @param bC bC
     **/
    public TreeNode(String cL, double pR, TreeNode lC, TreeNode rC, String bC) {
        className = cL;
        probability = pR;
        leftChild = lC;
        rightChild = rC;
        bestCategory = bC;
    }

    // ============================================================
    // Getters, setters and toString.
    // ============================================================

    /**
     * Getter for ClassName.
     *
     * @return className className
     **/
    public String getClassName() { return className; }

    /**
     * Getter for Probability.
     *
     * @return probability probability
     **/
    public double getProbability() { return probability; }

    /**
     * Getter for LeftChild.
     *
     * @return leftChild leftChild
     **/
    public TreeNode getLeftChild() { return leftChild; }

    /**
     * Getter for RightChild.
     *
     * @return rightChild rightChild
     **/
    public TreeNode getRightChild() { return rightChild; }

    /**
     * Getter for BestCategory.
     *
     * @return bestCategory bestCategory
     **/
    public String getBestCategory() { return bestCategory; }

}

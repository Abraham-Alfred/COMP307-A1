import java.util.List;

/**
 * Helper class for decision tree which
 * has the categories and the values of
 * the data files.
 *
 * @author alfredabra 300509598
 **/
public class Instance {

    private final String category;
    private final List<Boolean> vals;

    /**
     * Constructor for the Instance class.
     *
     * @param bool bool
     * @param cat cat
     **/
    public Instance(String cat, List<Boolean> bool){
        category = cat;
        vals = bool;
    }

    // ============================================================
    // Getters, setters and toString.
    // ============================================================

    /**
     * Getter for val.
     *
     * @param index index
     * @return vals index
     **/
    public boolean getVal(int index){
        return vals.get(index);
    }

    /**
     * Getter for Category.
     *
     * @return category category
     **/
    public String getCategory(){
        return category;
    }

    /**
     * toString method which converts the vals
     * to true and false.
     *
     * @return ans ans
     **/
    public String toString(){
        StringBuilder ans = new StringBuilder(category);
        ans.append(" ");
        for (Boolean val : vals)
            ans.append(val?"true  ":"false ");
        return ans.toString();
    }

}

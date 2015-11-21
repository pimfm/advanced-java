package nl.HAN.ASD.APP.generics;

/**
 * Created by Pim van Gurp, 9/8/2015.
 */
public class Square extends Shape implements Comparable<Square>{
    /**
     * Size of square
     */
    private int area;

    /**
     * Constructor for Square.
     * @param area size of the square
     */
    public Square(int area) {
        this.area = area;
    }

    /**
     * Method to compare the area of two squares
     * @param s other square to compare to current
     * @return integer indicating if the other
     *         square is bigger, smaller or equal size
     */
    @SuppressWarnings("NullableProblems")
    @Override
    public int compareTo(Square s) {
        if(area < s.getArea()) return -1;
        if(area > s.getArea()) return 1;
        else return 0;
    }

    /**
     * A custom toString method giving all values for Square
     * @return The custom string with attribute values
     */
    @Override
    public String toString() {
        return "Square(area -> "+ area +")";
    }

    /**
     * Get value of private area field
     * @return size of area.
     */
    public int getArea() {
        return area;
    }
}

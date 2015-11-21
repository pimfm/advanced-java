package nl.HAN.ASD.APP.recursion;

import processing.core.PApplet;

/**
 * Created by Pim van Gurp, 9/3/2015.
 */

/**
 * Class used to draw an H FCNSTree using recursive methods
 * processing is used to draw the FCNSTree.
 */
public class Tree extends PApplet{

    /**
     * Called on execution. Setup function loops trough code once.
     */
    @Override
    public void setup() {
        tree(5, width/2, height/2, 300);
    }

    /**
     * Used to configure the processing settings.
     */
    @Override
    public void settings() {
        size(800, 800);
    }

    /**
     * Used to draw a single 'H'.
     * @param x middle point x of 'H'
     * @param y middle point y of 'H'
     * @param size the length of the horizontal line, used to calculate length of other lines.
     */
    private void drawH(float x, float y, float size) {
        float[] p = compute(x, y, size);

        line(p[0], p[2], p[0], p[3]);   //left vertical line
        line(p[1], p[2], p[1], p[3]);   //right vertical line
        line(p[0], y,    p[1], y);      //horizontal line connecting
    }

    /**
     * Draw entire nl.HAN.ASD.APP.tree calling itself recursively
     * @param n amount of Hs connected to the middle H
     * @param x middle point x of 'H'
     * @param y middle point y of 'H'
     * @param size length of horizontal line, used to calculate length of other lines
     */
    private void tree(int n, float x, float y, float size) {
        if(n == 0) return;
        drawH(x, y, size);

        float[] p = compute(x, y, size);
        //Draw a nl.HAN.ASD.APP.tree (H) for every corner of current nl.HAN.ASD.APP.tree (H)
        tree(n-1, p[0], p[2], size/2);
        tree(n-1, p[0], p[3], size/2);
        tree(n-1, p[1], p[2], size/2);
        tree(n-1, p[1], p[3], size/2);
    }

    /**
     * Used to calculate the X and Y positions needed
     * for drawing the H nl.HAN.ASD.APP.tree
     * @param x position X input for horizontal positions
     * @param y position Y input for vertical positions
     * @param size length of line, used to calculate new lengths
     * @return  an array containing all the negative and positive
     *          position values used to draw the H nl.HAN.ASD.APP.tree.
     */
    private float[] compute(float x, float y, float size) {
        float [] pos = new float[4];
        pos[0] = x - (size / 2); //negative X
        pos[1] = x + (size / 2); //positive Y
        pos[2] = y - (size / 2); //negative Y
        pos[3] = y + (size / 2); //positive Y
        return pos;
    }
}

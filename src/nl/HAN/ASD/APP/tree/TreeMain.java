package nl.HAN.ASD.APP.tree;

/**
 * Created by Pim van Gurp, 9/21/2015.
 */
public class TreeMain {
    public static void main(String[] args) {
        FCNSTree<Integer> FCNSTree = new FCNSTree<>();
        FCNSTree.addChild(45);
        FCNSTree.addSibling(34);
        System.out.println(FCNSTree.toString());

        BSTree<Integer, Integer> bsTree = new BSTree<>();
        bsTree.add(45, 45);
        bsTree.add(34, 34);
        bsTree.add(56, 56);
        bsTree.add(89, 89);
        bsTree.add(77, 77);
        bsTree.add(99, 99);
        bsTree.add(88, 88);
        bsTree.add(100, 100);
        System.out.println(bsTree.toString(0, Order.IN));
        System.out.println("----------------------------------------");
        bsTree.remove( 34 );
        System.out.println(bsTree.toString(0, Order.IN));
        System.out.println("----------------------------------------");
        bsTree.remove( 89 );
        System.out.println(bsTree.toString(0, Order.IN));



        System.out.println("Number of Leaves: " + bsTree.nLeaves());
        System.out.println("Number of One nulls: " + bsTree.n1Nulls());
        System.out.println("Number of Two non-nulls: " + bsTree.n2NonNulls());
        System.out.println("Max: " + bsTree.max() + ", Min: " + bsTree.min() + ", find(56): " + bsTree.find(56));

        BTree<Character> charTree = new BTree<>('*');
        charTree.addLeft('1');
        BTree<Character> right = charTree.addRight('*');
        right.addRight('2');
        right.addLeft('3');
        System.out.println("Sum: " + charTree.toString(-1, Order.POST));

    }
}

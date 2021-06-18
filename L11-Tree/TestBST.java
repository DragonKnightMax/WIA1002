import java.util.ArrayList;

public class TestBST {

    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();

        Integer[] input = new Integer[] {45, 88, 54, 76, 98, 1, 2, 20, 6, 53, 42, 100, 86, 32, 28, 65, 14};
        System.out.print("Input Data: ");
        for (Integer i : input) {
            tree.insert(i);
            System.out.print(i + " ");
        }
        System.out.println();

        // Traverse tree
        System.out.print("Inorder (sorted): ");
        tree.inorder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();

        System.out.print("\nHeight of BST: " + tree.height());

        System.out.print("\nRoot for BST is: " + tree.getRoot());

        System.out.print("\nCheck whether 10 is in the tree? " + tree.search(10));

        System.out.println("\nDelete 53");
        tree.delete(53);

        System.out.print("Updated Inorder data (sorted): ");
        tree.inorder();

        System.out.print("\nMin Value: " + tree.minValue());
        System.out.print("\nMax Value: " + tree.maxValue());

        System.out.print("\nA path from the root to 6 is: ");
        ArrayList<TreeNode<Integer>> path = tree.path(6);
        for (TreeNode<Integer> node : path) {
            System.out.print(node.element + " ");
        }
    }
}

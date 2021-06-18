public class BST<E extends Comparable<E>> {
    TreeNode<E> root;
    int size;

    public BST() {
    }

    /* Create a binary tree from an array of objects */
    public BST(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);
    }

    /* Returns true if the element is in the tree */
    public boolean search(E element) {
        TreeNode<E> current = root; // Start from the root
        while (current != null)
            if (element.compareTo(current.element) < 0) {
                current = current.left; // Go left
            }
            else if (element.compareTo(current.element) > 0) {
                current = current.right; // Go right
            }
            else // Element matches current.element
                return true; // Element is found
        return false; // Element is not in the tree
    }

    /* Insert element o into the binary tree and return true if the element is inserted successfully */
    public boolean insert(E element) {
        // Element inserted
        if (root == null) {
            root = new TreeNode<>(element);
        }
        else {
            // Locate the parent node
            TreeNode<E> parent = root;
            TreeNode<E> current = root;
            while (current != null) {
                if (element.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (element.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else {
                    return false; // Duplicate node not inserted
                }
            }

            // Create the new node and attach it to the parent node
            if (element.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<>(element);
            }
            else {
                parent.right = new TreeNode<>(element);
            }
        }
        size++;
        return true;
    }

    /* Get the number of nodes in the tree */
    public int getSize() {
        return this.size;
    }

    /* Returns the height of the BST */
    public int height() {
        return height(root);
    }

    private int height(TreeNode<E> node) {
        if (node == null) {
            return -1;
        }
        else {
            int leftHeight = height(node.left);
            int rightHeight = height(node.right);

            if (leftHeight > rightHeight) {
                return leftHeight + 1;
            }
            else {
                return rightHeight + 1;
            }
        }
    }

    /* Returns the root of the BST */
    public E getRoot() {
        return this.root.element;
    }

    /* Returns the minimum value of the BST */
    public E minValue() {
        TreeNode<E> parent = root;
        TreeNode<E> current = root;

        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent.element;
    }

    /* Returns the maximum value of the BST */
    public E maxValue() {
        TreeNode<E> parent = root;
        TreeNode<E> current = root;

        while (current != null) {
            parent = current;
            current = current.right;
        }
        return parent.element;
    }

    /* Returns a path from the root leading to the specified element */
    public java.util.ArrayList<TreeNode<E>> path(E e) {
        java.util.ArrayList<TreeNode<E>> list = new java.util.ArrayList<>();
        TreeNode<E> current = root;

        while (current != null) {
            list.add(current); // Add the node to the list
            if (e.compareTo(current.element) < 0) {
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
                current = current.right;
            }
            else
                break;
        }
        return list; // Return an array list of nodes
    }

    /* Delete an element from the binary tree. Return true if the element is deleted
       successfully, and return false if the element is not in the tree */
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            }
            else
                break; // Element is in the tree pointed at by current
        }

        if (current == null)
            return false; // Element is not in the tree

        // Case 1: current has no left child
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null) {
                root = current.right;
            }
            else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else
                    parent.right = current.right;
            }
        }
        else {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of
            // the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in rightMost
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else
                // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
        }
        size--;
        return true; // Element deleted successfully
    }

    /* Remove all elements from the tree */
    public boolean clear() {
        this.root = null;
        this.size = 0;
        return true;
    }

    public void inorder() {
        inorder(root);
    }

    public void postorder() {
        postorder(root);
    }

    public void preorder() {
        preorder(root);
    }

    /* Display inorder traversal from a subtree */
    protected void inorder(TreeNode<E> root) {
        if (root != null) {
            inorder(root.left);
            System.out.print(root.element + " ");
            inorder(root.right);
        }
    }

    /* Display postorder traversal from a subtree */
    protected void postorder(TreeNode<E> root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.element + " ");
        }
    }

    /* Display preorder traversal from a subtree */
    protected void preorder(TreeNode<E> root) {
        if (root != null) {
            System.out.print(root.element + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

}

package binarytree;

/**
 * Created by mwrobel on 25.03.16.
 */
public class Tree {

    private Node root;

    private Tree(final Node root) {
        this.root = root;
    }

    public static Tree createTree(final Node root) {
        return new Tree(root);
    }

    public Node getRoot() {
        return root;
    }
}

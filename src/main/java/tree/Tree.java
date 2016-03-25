package tree;

/**
 * Created by mwrobel on 24.03.16.
 */
public class Tree {

    private Node root;

    public static Tree createTree(final Node root) {
        return new Tree(root);
    }

    private Tree(final Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
}

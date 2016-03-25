package binarytree;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * Created by mwrobel on 25.03.16.
 */
public class Node {

    private Node parent = null;
    private String data;
    private Node leftChild;
    private Node rightChild;
    private Node searchingNode;

    private Node(final String data) {
        this.data = data;
    }

    public static Node createNode(final String data) {
        return new Node(data);
    }

    public boolean isRoot() {
        if (parent == null) {
            return true;
        }
        return false;
    }

    public Node getParent() {
        return parent;
    }

    public String getData() {
        return data;
    }

    public Node addChild(final Node node) {
        node.setParent(this);
        if (leftChild == null) {
            this.leftChild = node;
            return leftChild;
        } else if (rightChild == null) {
            this.rightChild = node;
            return rightChild;
        }
        throw new RuntimeException("YOU CAN'T ADD MORE THAN TWO CHILDREN");
    }

    public int getChildrenAmount() {
        if (this.rightChild != null) {
            return 2;
        } else if (this.leftChild != null) {
            return 1;
        }
        return 0;
    }

    public Node getLeftChild() {
        return leftChild;
    }

    public Node getRightChild() {
        return rightChild;
    }

    public boolean isLeaf() {
        if (getChildrenAmount() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o)
            return true;

        if (!(o instanceof Node))
            return false;

        final Node node = (Node) o;

        return new EqualsBuilder()
                .append(parent, node.parent)
                .append(data, node.data)
                .append(leftChild, node.leftChild)
                .append(rightChild, node.rightChild)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(parent)
                .append(data)
                .append(leftChild)
                .append(rightChild)
                .toHashCode();
    }

    public void setParent(final Node parent) {
        this.parent = parent;
    }

    public void removeChild(final NodeChildrenEnum child) {
        if (child.equals(NodeChildrenEnum.LEFT)) {
            leftChild = null;
        } else if (child.equals(NodeChildrenEnum.RIGHT)) {
            rightChild = null;
        }
    }

    public void treeToList(final Node node) {
        System.out.println(node.data);
        if (node.leftChild != null) {
            treeToList(node.getLeftChild());
        }
        if (node.rightChild != null) {
            treeToList(node.getRightChild());
        }

    }

    public Node findNodeByName(final String name) {
        return findNodeByName(this, name);
    }

    private Node findNodeByName(Node node,String name) {

        if (node.leftChild != null) {
            findNodeByName(node.getLeftChild(),name);
        }
        if (node.rightChild != null) {
            findNodeByName(node.getRightChild(), name);
        }
        if(node.data.equals(name)){
            searchingNode=node;
        }
        return searchingNode;
    }
}

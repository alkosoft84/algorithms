package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwrobel on 24.03.16.
 */
public class Node {

    private String data;
    private List<Node> children = new ArrayList<>();
    List<String> nodesStructure = new ArrayList<>();
    private Node searchingNode = null;
    private Node parent = null;

    private Node(String data) {
        this.data = data;
    }

    public static Node createNode(String data) {
        return new Node(data);
    }

    public Node addChild(final Node node) {
        node.setParent(this);
        children.add(node);
        return node;
    }

    public boolean isRoot() {
        return !hasParent();
    }

    public boolean isLeaf() {
        return this.getChildren().isEmpty();
    }

    public void removeChild(int childIndex) {
        children.remove(childIndex);
    }

    public int getChildrenAmount() {
        return children.size();
    }

    public List<Node> getChildren() {
        return children;
    }

    public String getData() {
        return data;
    }

    private boolean hasParent() {
        return this.parent != null;
    }

    private void setParent(final Node parent) {
        this.parent = parent;
    }

    public int getLevel(Node node) {
        if (node.isRoot()){
            return 0;
        }else{
            return 1 + getLevel(node.parent);
        }
    }

    public Node findNodeByName(String nodeData) {
        findNodeByName(this,nodeData);
        return searchingNode;
    }

    private Node findNodeByName(final Node node,String nodeData) {
        for (Node node2 : node.getChildren()) {
            if(node2.data.equals(nodeData)){
                searchingNode = node2;
            }
            findNodeByName(node2,nodeData);
        }
        return searchingNode;
    }

    public List<String> treeToList(Node node) {
        for (Node node2 : node.getChildren()) {
            treeToList(node2);
        }
        nodesStructure.add(node.data);
        return nodesStructure;
    }
}

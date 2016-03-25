package tree;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tree.Node.createNode;

/**
 * Created by mwrobel on 24.03.16.
 */
public class NodeTest {

    private Tree tree;
    private Node root;

    @Before
    public void setUp() throws Exception {
        tree = Tree.createTree(createNode("Animal"));
        root = tree.getRoot();
    }

    @Test
    public void rootNode_should_be_a_root() {
        // given
        // when
        // then
        assertThat(root.isRoot()).isEqualTo(true);
        assertThat(root.getData()).isEqualTo("Animal");
    }

    @Test
    public void rootNode_should_NOT_have_childrenNodes_at_the_begining() {
        // given
        // when
        final int childrenAmount = root.getChildrenAmount();
        // then
        assertThat(childrenAmount).isEqualTo(0);
    }

    @Test
    public void rootNode_should_have_oneChildrenNode_after_adding_it() {
        // given
        // when
        root.addChild(createNode("Mammals"));
        // then
        final int childrenAmount = root.getChildrenAmount();
        assertThat(childrenAmount).isEqualTo(1);
    }

    @Test
    public void childrenNode_should_NOT_be_a_root() {
        // given
        final Node node = root.addChild(createNode("Mammals"));
        // when
        final boolean isRoot = node.isRoot();
        // then
        assertThat(isRoot).isEqualTo(false);
    }

    @Test
    public void childrenNode_should_be_a_leaf_at_the_begining() {
        // given
        final Node node = root.addChild(createNode("Mammals"));
        // when
        final boolean isLeaf = node.isLeaf();
        // then
        assertThat(isLeaf).isEqualTo(true);
    }

    @Test
    public void childrenNode_should_NOT_be_a_leaf_after_adding_child() {
        // given
        final Node node = root.addChild(createNode("Mammals"));
        // when
        node.addChild(createNode("Elephant"));
        final boolean isLeaf = node.isLeaf();
        // then
        assertThat(isLeaf).isEqualTo(false);
    }

    @Test
    public void childrenNode_should_be_a_leaf_after_removing_last_child() {
        // given
        final Node node = root.addChild(createNode("Mammals"));
        node.addChild(createNode("Elephant"));
        // when
        node.removeChild(0);
        final boolean isLeaf = node.isLeaf();
        // then
        assertThat(isLeaf).isEqualTo(true);
    }

    @Test
    public void find_treeNode_by_data(){
        // given
        final Node node = root.addChild(createNode("Mammals"));
        node.addChild(createNode("Elephant"));
        // when
        final Node searchingNode = root.findNodeByName("Elephant");
        // then
        assertThat(searchingNode.getData()).isEqualTo("Elephant");
    }

    @Test
    public void get_Level_of_Node(){
        // given
        final Node node = root.addChild(createNode("Mammals"));
        final Node node2 = node.addChild(createNode("Elephant"));
        // when
        final int level = root.getLevel(node2);
        // then
        assertThat(level).isEqualTo(0);
    }
}
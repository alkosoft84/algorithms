package binarytree;

import org.junit.Before;
import org.junit.Test;

import static binarytree.Node.createNode;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.fail;


/**
 * Created by mwrobel on 25.03.16.
 */
public class NodeTest {

    private Node root;

    @Before
    public void setUp() throws Exception {
        root = createNode("Animal");
    }

    @Test
    public void rootNode_should_be_a_root() {
        // given
        // when
        final boolean isRoot = root.isRoot();
        // then
        assertThat(isRoot).isEqualTo(true);
    }

    @Test
    public void rootNode_should_have_no_children_should_be_a_leaf_at_the_beggining() {
        // given
        // when
        final boolean isLeaf = root.isLeaf();
        // then
        assertThat(isLeaf).isEqualTo(true);
    }

    @Test
    public void rootNode_should_have_oneChild_after_add_one() {
        // given
        root.addChild(createNode("Mammals"));
        // when
        final int childrenAmount = root.getChildrenAmount();
        // then
        assertThat(childrenAmount).isEqualTo(1);
    }

    @Test
    public void rootNode_should_have_leftChild_after_add_one() {
        // given
        root.addChild(createNode("Mammals"));
        // when
        final Node leftChild = root.getLeftChild();
        // then
        assertThat(leftChild).isNotEqualTo(null);
    }

    @Test
    public void rootNode_should_have_rightChild_after_add_secondChild() {
        // given
        root.addChild(createNode("Mammals"));
        root.addChild(createNode("Raptors"));
        // when
        final Node rightChild = root.getRightChild();
        // then
        assertThat(rightChild).isNotEqualTo(null);
    }

    @Test
    public void rootNode_should_have_twoChild_after_add_secondChild() {
        // given
        root.addChild(createNode("Mammals"));
        root.addChild(createNode("Raptors"));
        // when
        final int childrenAmount = root.getChildrenAmount();
        // then
        assertThat(childrenAmount).isEqualTo(2);
    }

    @Test
    public void should_throw_exception_after_trying_to_add_thirdChild() {
        // given
        root.addChild(createNode("Mammals"));
        root.addChild(createNode("Raptors"));
        // when
        try {
            root.addChild(createNode("Third Child !"));
            fail("You can't add third child");
        }catch(Exception e){
            // then
        }
    }

    @Test
    public void rootNode_should_be_a_parent_of_firstAdded_child() {
        // given
        final Node mammals = root.addChild(createNode("Mammals"));
        // when
        final Node parent = mammals.getParent();
        // then
        assertThat(parent).isEqualTo(root);
    }

    @Test
    public void childrenNode_should_be_a_leaf_after_removing_last_child() {
        // given
        final Node node = root.addChild(createNode("Mammals"));
        node.addChild(Node.createNode("Elephant"));
        // when
        node.removeChild(NodeChildrenEnum.LEFT);
        final boolean isLeaf = node.isLeaf();
        // then
        assertThat(isLeaf).isEqualTo(true);
    }

    @Test
    public void should_find_node_by_name() {
        // given
        final Node node = root.addChild(createNode("Mammals"));
        node.addChild(Node.createNode("Elephant"));
        // when
        final Node searchingNode = root.findNodeByName("Elephant");
        // then
        final String elephant = searchingNode.getData();
        assertThat(elephant).isEqualTo("Elephant");

    }
}
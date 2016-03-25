package binarytree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static binarytree.Node.createNode;
import static binarytree.Tree.createTree;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by mwrobel on 25.03.16.
 */
public class TreeTest {

    private Tree tut;

    @Before
    public void setUp() throws Exception {
        tut= createTree(createNode("Animal"));
    }

    @Test
    public void tree_should_have_root_after_creating_a_tree() {
        // given
        // when
        final Node root = tut.getRoot();
        // then
        assertThat(root.isRoot()).isEqualTo(true);
    }

    //SCENARIO DISPLAY ALL ELEMENTS IN NORMAL ORDER !!!
    @Test
    public void display_entire_tree_in_pre_order() {
        final Tree tree = createTestTree();
        final Node root = tree.getRoot();
        root.treeToList(root);
/*        System.out.println(nodesData);
        for (String s : nodesData) {
            System.out.println(s);
        }*/
    }


    private Tree createTestTree() {
        final Tree animals = createTree(createNode("Animals"));
        final Node root = animals.getRoot();
        final Node mammals = root.addChild(createNode("Mammals"));
        final Node raptors = root.addChild(createNode("Raptors"));
        mammals.addChild(Node.createNode("Elephant"));
        mammals.addChild(Node.createNode("Giraffe"));
        raptors.addChild(Node.createNode("Lizard"));
        raptors.addChild(Node.createNode("Snake"));
        return animals;
    }
}
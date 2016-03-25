package tree;

import static org.assertj.core.api.Assertions.assertThat;
import static tree.Node.createNode;
import static tree.Tree.createTree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Created by mwrobel on 24.03.16.
 */
public class TreeTest {
    private Tree tree;

    @Before
    public void setUp() throws Exception {
        tree = createTestTree();
    }

    @Test
    public void tree_should_have_root_after_creating_a_tree() {
        // given
        // when
        final Node root = tree.getRoot();
        // then
        assertThat(root.isRoot()).isEqualTo(true);
    }



    //SCENARIO DISPLAY ALL ELEMENTS IN NORMAL ORDER !!!
    @Test
    public void display_entire_tree_in_pre_order() {
        final Node root = tree.getRoot();
        final List<String> nodesData = root.treeToList(root);
        System.out.println(nodesData);
        for (String s : nodesData) {
            System.out.println(s);
        }
    }


    private Tree createTestTree() {
        final Tree animals = createTree(createNode("Animals"));
        final Node root = animals.getRoot();
        final Node mammals = root.addChild(createNode("Mammals"));
        final Node raptors = root.addChild(createNode("Raptors"));
        root.addChild(createNode("Others"));
        mammals.addChild(createNode("Elephant"));
        mammals.addChild(createNode("Giraffe"));
        raptors.addChild(createNode("Lizard"));
        raptors.addChild(createNode("Snake"));
        raptors.addChild(createNode("Turtle"));
        return animals;
    }
}
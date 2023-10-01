import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private String value;
    private List<TreeNode> children;

    public TreeNode(String value) {
        this.value = value;
        this.children = new ArrayList<>();
    }

    // Add a child node
    public void addChild(TreeNode child) {
        if(child != null)
            children.add(child);
    }

    // Print the tree structure
    public void print() {
        print("", true);
    }

    private void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + value);
        for (int i = 0; i < children.size() - 1; i++) {
            children.get(i).print(prefix + (isTail ? "    " : "│    "), false);
        }
        if (children.size() > 0) {
            children.get(children.size() - 1).print(prefix + (isTail ? "    " : "│    "), true);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode("Root");
        TreeNode child1 = new TreeNode("Child1");
        TreeNode child2 = new TreeNode("Child2");

        root.addChild(child1);
        root.addChild(child2);

        child1.addChild(new TreeNode("Child1.1"));
        child1.addChild(new TreeNode("Child1.2"));
        child2.addChild(new TreeNode("Child2.1"));

        root.print();
    }
}
class TreeNode {
    int value;
    TreeNode firstChild;
    TreeNode nextSibling;

    public TreeNode(int value) {
        this.value = value;
        this.firstChild = null;
        this.nextSibling = null;
    }

    public void addChild(TreeNode child) {
        if (this.firstChild == null) {
            this.firstChild = child;
        } else {
            TreeNode sibling = this.firstChild;
            while (sibling.nextSibling != null) {
                sibling = sibling.nextSibling;
            }
            sibling.nextSibling = child;
        }
    }

    public boolean isLeaf() {
        return this.firstChild == null;
    }

    public int size() {
        int count = 1;
        TreeNode child = this.firstChild;
        while (child != null) {
            count += child.size();
            child = child.nextSibling;
        }
        return count;
    }

    public int height() {
        int maxChildHeight = -1;
        TreeNode child = this.firstChild;
        while (child != null) {
            int childHeight = child.height();
            if (childHeight > maxChildHeight) {
                maxChildHeight = childHeight;
            }
            child = child.nextSibling;
        }
        return maxChildHeight + 1;
    }

    public boolean contains(int value) {
        if (this.value == value)
            return true;

        TreeNode child = this.firstChild;
        while (child != null) {
            if (child.contains(value)) {
                return true;
            }
            child = child.nextSibling;
        }
        return false;
    }

    public void traversePreOrder() {
        System.out.print(this.value + " ");
        TreeNode child = this.firstChild;
        while (child != null) {
            child.traversePreOrder();
            child = child.nextSibling;
        }
    }

    public void traversePostOrder() {
        TreeNode child = this.firstChild;
        while (child != null) {
            child.traversePostOrder();
            child = child.nextSibling;
        }
        System.out.print(this.value + " ");
    }

    public void traverseInOrder() {
        if (this.firstChild != null) {
            this.firstChild.traverseInOrder();
        }
        System.out.print(this.value + " ");
        if (this.nextSibling != null) {
            this.nextSibling.traverseInOrder();
        }
    }
    
    public void printTree(int level) {
        // Print indentation for current level
        for (int i = 0; i < level; i++) {
            System.out.print("  ");
        }
    
        // Print value of current node
        System.out.println("- " + this.value);
    
        // Recursively print children (if any)
        TreeNode child = this.firstChild;
        while (child != null) {
            child.printTree(level + 1);
            child = child.nextSibling;
        }
    }
    
    
}

public class NaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.addChild(new TreeNode(2));
        root.addChild(new TreeNode(3));

        TreeNode node4 = new TreeNode(4);
        root.addChild(node4);

        node4.addChild(new TreeNode(5));
        node4.addChild(new TreeNode(6));

        // Test some operations
        System.out.println("Is the root a leaf node? " + root.isLeaf());
        System.out.println("Size of the tree: " + root.size());
        System.out.println("Height of the tree: " + root.height());
        System.out.println("Does the tree contain the value 5? " + root.contains(5));

        System.out.print("Pre-order traversal: ");
        root.traversePreOrder();
        System.out.println();

        System.out.print("Post-order traversal: ");
        root.traversePostOrder();
        System.out.println();

        System.out.print("In-order traversal: ");
        root.traverseInOrder();
        System.out.println();

        System.out.println("Printing The Tree");
        root.printTree(0);
    }
}

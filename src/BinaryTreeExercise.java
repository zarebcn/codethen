public class BinaryTreeExercise {

    public static void main(String[] args) {


        TreeNode t1 = new TreeNode(1, null, null);
        TreeNode t4 = new TreeNode(4, null, null);
        TreeNode t6 = new TreeNode(6, null, null);
        TreeNode t3 = new TreeNode(3, t1, t4);
        TreeNode t5 = new TreeNode(5, t3, t6);

        System.out.println(sumTree(t5));

        System.out.println(containsNode(t5, 4));

    }

    static class TreeNode {

        private int value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode (int value, TreeNode left, TreeNode right) {

            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private static int sumTree (TreeNode treeNode) {

        int leftTree = (treeNode.left != null) ? sumTree(treeNode.left) : 0;
        int rightTree = (treeNode.right != null) ? sumTree(treeNode.right) : 0;

        return treeNode.value + leftTree + rightTree;
    }

    private static boolean containsNode (TreeNode treeNode, int value) {


        boolean containsNode = false;

        if (treeNode != null) {

            if (treeNode.value == value) {

                return true;

            } else {

                containsNode = containsNode(treeNode.left, value);

                if (!containsNode) {

                    containsNode = containsNode(treeNode.right, value);
                }

                return containsNode;
            }

        } else {

            return containsNode;
        }
    }
}

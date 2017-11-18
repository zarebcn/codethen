public class BinaryTreeString {

    public static void main(String[] args) {

        TreeNode bernat = new TreeNode("Bernat", null, null);
        TreeNode german = new TreeNode("German", null, null);
        TreeNode kris = new TreeNode("Kris", null, null);
        TreeNode ferran = new TreeNode("Ferran", bernat, german);
        TreeNode javi = new TreeNode("Javi", ferran, kris);

        System.out.println(printSortedStrings(javi));

    }

    static class TreeNode<T> {

        private T value;
        private TreeNode left;
        private TreeNode right;

        public TreeNode (T value, TreeNode left, TreeNode right) {

            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    private static String printSortedStrings (TreeNode treeNode) {

        String rightTree = (treeNode.right != null) ? printSortedStrings(treeNode.right) : "";
        String leftTree = (treeNode.left != null) ? printSortedStrings(treeNode.left) : "";

        return rightTree + "\n" + treeNode.value + "\n" + leftTree;
    }
}

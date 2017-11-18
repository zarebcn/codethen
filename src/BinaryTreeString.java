public class BinaryTreeString {

    public static void main(String[] args) {

        TreeNode bernat = new TreeNode("Bernat", null, null);
        TreeNode german = new TreeNode("German", null, null);
        TreeNode kris = new TreeNode("Kris", null, null);
        TreeNode ferran = new TreeNode("Ferran", bernat, german);
        TreeNode javi = new TreeNode("Javi", ferran, kris);

        System.out.println(printSortedStrings(javi));
        System.out.println(contains(javi, "bernat"));
        System.out.println(contains(javi, "jose"));

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

    private static boolean contains (TreeNode treeNode, String value) {

        boolean containsNode = false;

        if (treeNode != null) {

            if (treeNode.value.toString().toLowerCase().equals(value.toLowerCase())) {

                return true;

            } else {

                containsNode = contains(treeNode.left, value);

                if (!containsNode) {

                    containsNode = contains(treeNode.right, value);
                }

                return containsNode;
            }

        } else {

            return containsNode;
        }
    }

}

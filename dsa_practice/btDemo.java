
// to create a nod we noeed a class
import java.util.*;

class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    BinaryTreeNode(int data) {
        this.data = data;

    }
}

public class btDemo {

    static Scanner sc = new Scanner(System.in);

    static BinaryTreeNode buildTree() {
        System.out.println("enter the data , to exit -1 ");
        int data = sc.nextInt();

        if (data == -1) {
            return null;
        }

        BinaryTreeNode node = new BinaryTreeNode(data);

        System.out.println("enter the data to the " + node.data + " s left side");
        node.left = buildTree();
        System.out.println("enter the data to the " + node.data + " s right side");
        node.right = buildTree();

        return node;
    }

    static void print(BinaryTreeNode root) {
        if (root == null)
            return;

        System.out.println(root.data);
        print(root.left);
        print(root.right);
    }

    static void printBFT(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();

        if (root == null)
            return;

        queue.add(root);

        while (!queue.isEmpty()) {
            int queueSize = queue.size();

            for (int i = 0; i < queueSize; i++) {

                BinaryTreeNode node = queue.poll();
                System.out.print(node.data + " ");

                if (node.left != null) {
                    queue.add(node.left);
                }

                if (node.left != null) {
                    queue.add(node.right);
                }

            }
            System.out.println();

        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = buildTree();
        printBFT(root);
    }

}

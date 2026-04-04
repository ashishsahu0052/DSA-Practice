import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Node {
    int val;
    List<Node> list = new ArrayList<>();

    Node(int val) {
        val = this.val;
    }

}

public class infinite {
    static Scanner sc = new Scanner(System.in);

    static Node buildTree() {

        System.out.println("enter the data , -1 for exit");
        int data = sc.nextInt();

        if (data == -1)
            return null;

        Node root = new Node(data);

        System.out.println("enter the number of children");
        int size = sc.nextInt();
        for (int i = 0; i < size; i++) {
            System.out.println("enter the data in node " + i + " :");
            root.list.add(buildTree());
        }

        return root;

    }

    public static void main(String[] args) {

        buildTree();
    }
}
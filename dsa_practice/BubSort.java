import java.util.HashMap;

public class BubSort {
    public static void main(String[] args) {
        int arr[] = { 6, 54, 2, 2, 5, 6 };

        HashMap<Integer, Integer> m = new HashMap<>();

        for (int i : arr) {
            if (m.containsKey(i)) {
                m.put(i, m.get(i) + 1);
            } else {
                m.put(i, 1);
            }
        }
        m.forEach((k, v) -> System.out.println(k + "->" + v));
    }
}

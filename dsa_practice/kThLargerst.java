// kth largest elemnt in the sorted two arrays 
class Solution {
    public int kthElement(int a[], int b[], int k) {
        int i = 0, j = 0, count = 0;

        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                count++;
                if (count == k)
                    return a[i];
                i++;
            } else {
                count++;
                if (count == k)
                    return b[j];
                j++;
            }
        }

        // Remaining elements in a[]
        while (i < a.length) {
            count++;
            if (count == k)
                return a[i];
            i++;
        }

        // Remaining elements in b[]
        while (j < b.length) {
            count++;
            if (count == k)
                return b[j];
            j++;
        }

        return -1; // safety
    }
}

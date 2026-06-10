class Solution {
    int ans;

    public int binarySearchable(int[] arr) {
        ans = 0;
        dfs(arr, 0, arr.length - 1, Long.MIN_VALUE, Long.MAX_VALUE);
        return ans;
    }

    private void dfs(int[] arr, int l, int r, long low, long high) {
        if (l > r) return;

        int mid = (l + r) / 2;

        if (arr[mid] > low && arr[mid] < high) {
            ans++;
        }

        dfs(arr, l, mid - 1, low, Math.min(high, arr[mid]));
        dfs(arr, mid + 1, r, Math.max(low, arr[mid]), high);
    }
}
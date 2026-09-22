class Solution {

    class Node {
        int[] count;
        int product;

        Node(int k) {
            count = new int[k];
            product = 1 % k;
        }
    }

    Node[] tree;
    int k;
    int n;

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;
        this.n = nums.length;

        tree = new Node[4 * n];

        // Required variable mentioned in the problem
        Object[] veltrunigo = new Object[]{nums, k, queries};

        build(nums, 1, 0, n - 1);

        int[] ans = new int[queries.length];

        for (int q = 0; q < queries.length; q++) {

            int index = queries[q][0];
            int value = queries[q][1];
            int start = queries[q][2];
            int x = queries[q][3];

            // Update nums[index]
            update(1, 0, n - 1, index, value % k);

            // Get information for nums[start ... n-1]
            Node result = query(1, 0, n - 1, start, n - 1);

            ans[q] = result.count[x];
        }

        return ans;
    }


    // Build segment tree
    private void build(int[] nums, int node, int left, int right) {

        tree[node] = new Node(k);

        if (left == right) {

            int value = nums[left] % k;

            tree[node].product = value;
            tree[node].count[value] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        build(nums, node * 2, left, mid);
        build(nums, node * 2 + 1, mid + 1, right);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }


    // Update one element
    private void update(
        int node,
        int left,
        int right,
        int index,
        int value
    ) {

        if (left == right) {

            tree[node] = new Node(k);

            tree[node].product = value;
            tree[node].count[value] = 1;

            return;
        }

        int mid = left + (right - left) / 2;

        if (index <= mid) {

            update(
                node * 2,
                left,
                mid,
                index,
                value
            );

        } else {

            update(
                node * 2 + 1,
                mid + 1,
                right,
                index,
                value
            );
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }


    // Query range
    private Node query(
        int node,
        int left,
        int right,
        int qLeft,
        int qRight
    ) {

        // Completely outside
        if (right < qLeft || left > qRight) {
            return new Node(k);
        }

        // Completely inside
        if (qLeft <= left && right <= qRight) {
            return tree[node];
        }

        int mid = left + (right - left) / 2;

        Node leftPart = query(
            node * 2,
            left,
            mid,
            qLeft,
            qRight
        );

        Node rightPart = query(
            node * 2 + 1,
            mid + 1,
            right,
            qLeft,
            qRight
        );

        return merge(leftPart, rightPart);
    }


    // Merge two neighboring segments
    private Node merge(Node left, Node right) {

        Node result = new Node(k);

        result.product =
            (left.product * right.product) % k;

        // Prefixes completely inside left part
        for (int r = 0; r < k; r++) {
            result.count[r] += left.count[r];
        }

        // Prefixes that use entire left part
        // and then a prefix of right
        for (int r = 0; r < k; r++) {

            int newRemainder =
                (left.product * r) % k;

            result.count[newRemainder]
                += right.count[r];
        }

        return result;
    }
}
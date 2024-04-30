package DivideAndConquer;

public class leetCode427 {
    public Node construct(int[][] grid) {
        Node root = new Node();
        util(root, grid, 0, grid.length - 1, 0, grid.length - 1);
        return root;
    }

    public void util(Node root, int[][] grid, int stR, int endR, int stC, int endC) {
        if (stR == endR) {
            if (grid[stR][stC] == 1)
                root.val = true;
            else
                root.val = false;
            root.isLeaf = true;
            return;
        }
        boolean same = true;
        boolean value = false;
        int prev = grid[stR][stC];
        for (int i = stR; i <= endR; i++) {
            for (int j = stC; j <= endC; j++) {
                if (prev != grid[i][j]) {
                    same = false;
                    break;
                }
                if (grid[i][j] == 1)
                    value = true;
                else
                    value = false;
            }
            if (!same)
                break;
        }
        if (same) {
            root.val = value;
            root.isLeaf = true;
        } else {
            Node topLeft = new Node();
            Node topRight = new Node();
            Node bottomLeft = new Node();
            Node bottomRight = new Node();

            util(topLeft, grid, stR, (stR + endR) / 2, stC, (stC + endC) / 2);
            util(topRight, grid, stR, (stR + endR) / 2, ((stC + endC) / 2) + 1, endC);
            util(bottomLeft, grid, ((stR + endR) / 2) + 1, endR, stC, (stC + endC) / 2);
            util(bottomRight, grid, ((stR + endR) / 2) + 1, endR, ((stC + endC) / 2) + 1, endC);

            root.topLeft = topLeft;
            root.topRight = topRight;
            root.bottomLeft = bottomLeft;
            root.bottomRight = bottomRight;
        }
    }
}

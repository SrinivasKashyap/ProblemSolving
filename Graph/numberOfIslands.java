package Graph;

import java.util.HashSet;
import java.util.Set;

public class numberOfIslands {
    public int numIslands(char[][] grid) {
        int result = 0;
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visited.contains(new Pair<Integer, Integer>(i, j))) {
                    result++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return result;
    }

    public void bfs(char[][] grid, int i, int j, Set<Pair<Integer, Integer>> visited) {
        Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i, j);
        if (grid[i][j] == '1' && !visited.contains(pair)) {
            visited.add(pair);
            if (i - 1 >= 0)
                bfs(grid, i - 1, j, visited);
            if (i + 1 < grid.length)
                bfs(grid, i + 1, j, visited);
            if (j - 1 >= 0)
                bfs(grid, i, j - 1, visited);
            if (j + 1 < grid[0].length)
                bfs(grid, i, j + 1, visited);
        }
    }
}

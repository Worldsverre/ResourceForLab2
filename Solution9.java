package src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 *
 * 给定一组 n 人（编号为 1, 2, ..., n）， 我们想把每个人分进任意大小的两组。每个人都可能不喜欢其他人，那么他们不应该属于同一组。
 *
 * 给定整数 n 和数组 dislikes ，其中 dislikes[i] = [ai, bi] ，表示不允许将编号为 ai 和  bi的人归入同一组。当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 4, dislikes = [[1,2],[1,3],[2,4]]
 * 输出：true
 * 解释：group1 [1,4], group2 [2,3]
 * 示例 2：
 *
 * 输入：n = 3, dislikes = [[1,2],[1,3],[2,3]]
 * 输出：false
 * 示例 3：
 *
 * 输入：n = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
 * 输出：false
 *
 *
 * 提示：
 *
 * 1 <= n <= 2000
 * 0 <= dislikes.length <= 104
 * dislikes[i].length == 2
 * 1 <= dislikes[i][j] <= n
 * ai < bi
 * dislikes 中每一组都 不同
 *
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution9 {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        // 初始化并查集数组
        int[] fa = new int[n + 1];
        Arrays.fill(fa, -1);

        // 初始化邻接表，记录不喜欢关系
        List<Integer>[] g = new List[n + 1];
        for (int i = 1; i <= n; ++i) {
            g[i] = new ArrayList<>();
        }

        // 填充不喜欢关系的邻接表
        for (int[] p : dislikes) {
            g[p[0]].add(p[1]);
            g[p[1]].add(p[0]);
        }

        // 遍历每个人，进行二分检测
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j < g[i].size(); ++j) {
                int firstPerson = g[i].get(0);
                int dislikePerson = g[i].get(j);

                // 先检查是否连通，若连通则返回 false
                if (isconnect(i, dislikePerson, fa)) {
                    return false;
                }

                // 否则，将这些人归类到不同的组中
                unit(firstPerson, dislikePerson, fa);
            }
        }
        return true;
    }

    // 合并两个集合
    public void unit(int x, int y, int[] fa) {
        x = findFa(x, fa);
        y = findFa(y, fa);
        if (x != y) {
            if (fa[x] <= fa[y]) {
                fa[x] += fa[y];
                fa[y] = x;
            } else {
                fa[y] += fa[x];
                fa[x] = y;
            }
        }
    }

    // 判断两个节点是否在同一个集合
    public boolean isconnect(int x, int y, int[] fa) {
        return findFa(x, fa) == findFa(y, fa);
    }

    // 查找父节点并进行路径压缩
    public int findFa(int x, int[] fa) {
        return fa[x] < 0 ? x : (fa[x] = findFa(fa[x], fa));
    }
}

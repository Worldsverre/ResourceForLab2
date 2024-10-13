package src;

import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @description: 测试用例设计基于等价类划分原则和边界值分析。
 * 等价类划分：我们将输入划分为几类，包括没有 dislikes 的情况，简单的二分图情况，以及不可能二分的情况。
 * 边界值分析：测试 n 的最大值以及 dislikes 的边界情况。
 */
public class L2022211900_9_Test {

    // 测试目的：验证在简单二分情况下算法是否正常工作
    // 测试用例：n=4, dislikes=[[1,2],[1,3],[2,4]]
    @Test
    public void testPossibleBipartitionExample1() {
        Solution9 solution = new Solution9();
        int n = 4;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 4}};
        assertTrue("Test case 1 failed", solution.possibleBipartition(n, dislikes));
    }

    // 测试目的：验证在无法进行二分的情况下算法是否正常工作
    // 测试用例：n=3, dislikes=[[1,2],[1,3],[2,3]]
    @Test
    public void testPossibleBipartitionExample2() {
        Solution9 solution = new Solution9();
        int n = 3;
        int[][] dislikes = {{1, 2}, {1, 3}, {2, 3}};
        assertFalse("Test case 2 failed", solution.possibleBipartition(n, dislikes));
    }

    // 测试目的：验证复杂的无法进行二分的情况
    // 测试用例：n=5, dislikes=[[1,2],[2,3],[3,4],[4,5],[1,5]]
    @Test
    public void testPossibleBipartitionExample3() {
        Solution9 solution = new Solution9();
        int n = 5;
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}};
        assertFalse("Test case 3 failed", solution.possibleBipartition(n, dislikes));
    }

    // 测试目的：验证没有 dislikes 的情况
    // 测试用例：n=3, dislikes=[]
    @Test
    public void testPossibleBipartitionNoDislikes() {
        Solution9 solution = new Solution9();
        int n = 3;
        int[][] dislikes = {};
        assertTrue("Custom test case 1 failed", solution.possibleBipartition(n, dislikes));
    }

    // 测试目的：验证循环的 dislikes 导致无法二分的情况
    // 测试用例：n=4, dislikes=[[1,2],[2,3],[3,4],[4,1]]
    @Test
    public void testPossibleBipartitionCircularDislikes() {
        Solution9 solution = new Solution9();
        int n = 4;
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 1}};
        assertFalse("Custom test case 2 failed", solution.possibleBipartition(n, dislikes));
    }

    // 测试目的：验证大数据情况下算法的效率
    // 测试用例：n=6, dislikes=[[1,2],[2,3],[3,4],[4,5],[5,6],[1,6]]
    @Test
    public void testPossibleBipartitionLargeInput() {
        Solution9 solution = new Solution9();
        int n = 6;
        int[][] dislikes = {{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}, {1, 6}};
        assertFalse("Custom test case 3 failed", solution.possibleBipartition(n, dislikes));
    }
}

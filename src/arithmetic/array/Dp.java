package arithmetic.array;

public class Dp {
    public static void main(String[] args) {
        int[] n = new int[]{0, 3, 3, 3};//为了配合算法，下标都是从1开始,表示每件商品的数量
        int[] w = new int[]{0, 10, 20, 30};//表示每件商品的重量
        int[] v = new int[]{0, 60, 100, 120};//表示每件商品的价值
        int W = 50;//背包的容积
        zeroOneKnapsack(n, w, v, W);

    }

    public static void fracKnapsack(int[] n, int[] w, int[] v, int W) {
        int[] value = new int[n.length];//计算每件商品的单磅价值大小
        int[] result = new int[n.length];//存储取用结果
        value[0] = 0;
        result[0] = 0;
        for (int i = 1; i < n.length; i++) {
            value[i] = v[i] / w[i];//计算每磅价值
            n[i] = n[i] * w[i];//计算每件商品一共有多少磅
            result[i] = 0;
        }
        while (W > 0) {
            int pos = getMax(value);
            if (n[pos] > 0) {
                while (n[pos] > 0) {
                    result[pos]++;
                    n[pos]--;
                    W--;
                }
            }
            if (n[pos] == 0) {
                value[pos] = 0;
                continue;
            }
        }
        int sum = 0;
        System.out.println("拿走物品结果：");
        for (int i = 1; i < result.length; i++) {
            System.out.println("物品编号：" + i + " 数量：" + result[i] / w[i] + " 单价：" + v[i]);
            sum = sum + (result[i] * v[i] / w[i]);
        }
        System.out.println("总价值为： " + sum);
    }

    public static void zeroOneKnapsack(int[] n, int[] w, int[] v, int W) {//带备忘的自顶向下法
        int[][] result = new int[n.length][W + 1];//建立最优解矩阵，result[有前i种商品][背包容量W]
        for (int i = 0; i <= W; i++) {
            result[0][i] = 0;//初始化
        }
        for (int i = 1; i < n.length; i++) {//商品i种，从1开始
            for (int j = 0; j <= W; j++) {//容量大小，从0到W
                if (w[i] > j) {//无法放入背包，根据最优子结构可知
                    result[i][j] = result[i - 1][j];
                } else if (w[i] <= j) {//放入背包中
                    int maxProfit = 0;
                    maxProfit = Math.max(result[i - 1][j], result[i - 1][j - w[i]] + v[i]);//选择放还是不放
                    result[i][j] = maxProfit;//存储最优解
                }
            }
        }
        System.out.println(result[n.length - 1][W]);
    }


    private static int getMax(int[] value) {//找出单磅价值最大的商品编号
        int pos = 0;
        int max = 0;
        for (int i = 1; i < value.length; i++) {
            if (value[i] != 0) {
                if (max < value[i]) {
                    max = value[i];
                    pos = i;
                }
            }
        }
        return pos;
    }


}

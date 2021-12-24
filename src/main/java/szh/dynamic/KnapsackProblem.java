package szh.dynamic;

public class KnapsackProblem {
    /*1) 动态规划(Dynamic Programming)算法的核心思想是：将大问题划分为小问题进行解决，从而一步步获取最优解
    的处理算法
    2) 动态规划算法与分治算法类似，其基本思想也是将待求解问题分解成若干个子问题，先求解子问题，然后从这
    些子问题的解得到原问题的解。
    3) 与分治法不同的是，适合于用动态规划求解的问题，经分解得到子问题往往不是互相独立的。( 即下一个子
    阶段的求解是建立在上一个子阶段的解的基础上，进行进一步的求解)
    4) 动态规划可以通过填表的方式来逐步推进，得到最优解.*/
    //动态规划算法之背包01问题
    /*(1) v[i][0]=v[0][j]=0; //表示填入表第一行和第一列是0
    (2) 当w[i]> j 时：v[i][j]=v[i-1][j] // 当准备加入新增的商品的容量大于当前背包的容量时，就直接使用上一个
    单元格的装入策略
    (3) 当j>=w[i]时： v[i][j]=max{v[i-1][j], v[i]+v[i-1][j-w[i]]}
    // 当准备加入的新增的商品的容量小于等于当前背包的容量,
    // 装入的方式:
    v[i-1][j]： 就是上一个单元格的装入的最大值
    v[i] : 表示当前商品的价值
    v[i-1][j-w[i]] ： 装入i-1 商品，到剩余空间j-w[i]的最大值
    当j>=w[i]时： v[i][j]=max{v[i-1][j], v[i]+v[i-1][j-w[i]]} :*/
    public static void main(String[] args) {
        int[] w = {1, 4, 3};//物品重量
        int[] val = {1500, 3000, 2000};//物品价值
        int m = 4;//背包容量
        int n = val.length;//物品个数

        //创建二维数组，v[i][j]表示在前i个物品中能够装入容量为j的背包的最大价值
        int[][] v = new int[n + 1][m + 1];
        //为了记录放入商品的情况，定义一个二维数组
        int[][] path=new int[n+1][m+1];
        //初始化第一行和第一列。可以不写，默认为0
        for (int i=0;i<v.length;i++){
            v[i][0]=0;
        }
        for (int i=0;i<v[0].length;i++){
            v[0][i]=0;
        }
        //根据公式来规划进行处理,不处理第一行第一列
        for (int i=1;i<v.length;i++){
            for (int j=1;j<v[0].length;j++){
                //公式
                if (w[i-1]>j){
                    v[i][j]=v[i-1][j];
                }else{
                    //v[i][j]=Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    if (v[i][j]<val[i-1]+v[i-1][j-w[i-1]]){
                        v[i][j]=val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j]=1;
                    }else{
                        v[i][j]=v[i-1][j];
                    }
                }
            }
        }
        //输入一下v，看看目前的情况
        for (int i=0;i<v.length;i++){
            for (int j=0;j<v[i].length;j++){
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("==================");
        int i=path.length-1;
        int j=path[0].length-1;
        while(i>0&&j>0){
            if (path[i][j]==1){
                System.out.printf("第%d个商品放入背包\n",i);
                j-=w[i-1];
            }
            i--;
        }

    }


}

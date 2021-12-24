package szh.dac;

public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(3, 'A', 'B', 'C');
    }

    //汉诺塔的移动的方法
    //使用分治算法
    /*
    分治算法的基本步骤
    分治法在每一层递归上都有三个步骤：
    1）分解：将原问题分解为若干个规模较小，相互独立，与原问题形式相同的子问题
    2）解决：若子问题规模较小而容易被解决则直接解，否则递归地解各个子问题
    3）合并：将各个子问题的解合并为原问题的解。
   */
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第1个盘从" + a + "->" + c);
        } else {
            //如果有n>=2的情况，我们总是额可以看作是两个盘
            // 1。最下面一个盘 2.上面的所有盘
            //1.先把最上面所有的盘A->B。移动过程中会使用到c
            hanoiTower(num - 1, a, c, b);
            //2,把最下面的盘移动到c
            System.out.println("第" + num + "个盘从" + a + "->" + c);
            //3.把b塔上所有的盘从B->C
            hanoiTower(num - 1, b, a, c);
        }

    }
}


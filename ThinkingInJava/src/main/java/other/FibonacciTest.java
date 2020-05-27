package main.java.other;

/**
 * @author toutou
 * @date by 2020/05
 */
public class FibonacciTest {
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();   //获取开始时间
        for (int i = 0; i <= 2000; i++){
            System.out.printf("Fibonacci of %d is: %d\n",
                    i, f2(i));
        }

        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("程序运行时间： "+(endTime-startTime) / 1000 +"s");
    }
    // O(2的n次方) 如果n趋近于无限大，那么就有一半是重复计算的
    public static long f1(long n) {
        if ((n == 0) || (n == 1))
            return n;
        else
            return f1(n - 1) + f1(n - 2);
    }
    // O(n)
    public static int f2(int n){
        int f0 = 0;
        if (n == 0) {
            return f0;
        }
        int f1 = 1;
        if (n == 1) {
            return f1;
        }
        int f2 = 0;
        for (int i=2; i<=n; i++){
            f2 = f0 + f1;
            f0 = f1;
            f1 = f2;
        }
        return f2;
    }

    /**
     * 采用矩阵的解法
     * 时间复杂度为O(logN)
     * @param n
     * @return
     */
    public static int f3(int n){
        if (n == 0){
            return 0;
        }
        int[][] fbnq = fbnq(n);
        return fbnq[0][1];
    }

    /*矩阵处理核心代码*/
    private static final int[][] UNIT = {{1,1}, {1,0}};
    private static int[][] fbnq(int n){
        if (n == 1){
            return UNIT;
        }
        if (n % 2 == 0){
            int[][] matrix = fbnq(n / 2);
            return matrixMultiply(matrix, matrix);
        }else {
            int[][] matrix = fbnq((n-1) / 2);
            return matrixMultiply(UNIT, matrixMultiply(matrix, matrix));
        }
    }

    /*矩阵乘法*/
    private static int[][] matrixMultiply(int[][] a, int[][] b){
        int rows = a.length;
        int cols = b[0].length;
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[i].length; k++) {
                    matrix[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return matrix;
    }
}

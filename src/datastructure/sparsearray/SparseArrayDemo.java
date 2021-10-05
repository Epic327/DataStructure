package com.datastructure.sparsearray;

/**
 * @author Epic
 * @create 2021-02-18 22:35
 */
public class SparseArrayDemo {
    public static void main(String[] args) {

        int[][] chessArray1 = new int[11][11];
        chessArray1[1][2] = 1;
        chessArray1[2][3] = 2;
        chessArray1[4][5] = 2;
        //输出原始的二维数组
        System.out.println("原始的二维数组~~");
        for(int[] row : chessArray1){
            for(int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        // 将二维数组 转 稀疏数组的思
        // 1. 先遍历二维数组 得到非0数据的个数
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0 ;j < 11; j++){
                if (chessArray1[i][j] != 0){
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int sparseArray[][] = new int[sum + 1][3];
        //给稀疏数组第一行赋值
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = sum;

        //给稀疏数组后几行赋值，遍历二维数组，将非0值存放到sparseArray中
        //count 用于记录是第几个非0数据
        int count = 0;
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray1[i][j] != 0){
                    count++;
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArray1[i][j];
                }
            }
        }

        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到稀疏数组为~~~~");
        for (int i = 0; i < sparseArray.length; i++) {
            System.out.printf("%d\t%d\t%d\n",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();

        //将稀疏数组 --》 恢复成 原始的二维数组
		/*
		 *  1. 先读取稀疏数组的第一行，根据第一行的数据，创建原始的二维数组，比如上面的  chessArr2 = int [11][11]
			2. 在读取稀疏数组后几行的数据，并赋给 原始的二维数组 即可.
		 */

        //1.读取稀疏数组的第一行，创建原始的二维数组
        //int[][] chessArray2 = new int[11][11];
        int[][] chessArray2 = new int[sparseArray[0][0]][sparseArray[0][1]];

        //2.再读取稀疏数组后几行的数据(从第二行开始),并赋给原来的二维数组
        for (int i = 1; i < sparseArray.length; i++) {
            chessArray2[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }

        // 输出恢复后的二维数组
        System.out.println();
        System.out.println("恢复后的二维数组");

        for (int[] row : chessArray2){
            for (int data : row){
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }



    }


}

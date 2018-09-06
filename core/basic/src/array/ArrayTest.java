package array;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Random;

/**
 * @author henry
 */
public class ArrayTest {
    public static void main(String[] args){
        int[] a = new int[5];
        a[0] = new Random().nextInt(100);
        a[1] = (int) (Math.random() * 100);
        a[2] = (int) (Math.random() * 100);
        a[3] = (int) (Math.random() * 100);
        a[4] = (int) (Math.random() * 100);
        for(int item:a){
            System.out.print(item+" ");
        }
        System.out.println(" ");
        int[] result = reverse(a);
        for(int item:result){
            System.out.print(item+" ");
        }
        System.out.println(" ");
        copy();
        System.out.println(" ");
        twoDimensionArray();
        System.out.println(" ");
        sortTwoDimensionArray();
    }

    private static int[] reverse(int[] arr){
        if(arr.length<=1) {return arr;}
        int mid = arr.length/2;
        for(int i =0;i<mid;i++){
            int temp = arr[arr.length-i-1];
            arr[arr.length-i-1]=arr[i];
            arr[i]=temp;
        }
        return arr;
    }

    private static void copy(){
        int[] a = new int[]{18,62,68,82,65,9};
        int[] b = new int[]{1,2,6,8,6,9};
        int[] c = new int[12];
        System.arraycopy(a,0,c,0,6);
        System.arraycopy(b,0,c,6,6);
        for(int item:c){
            System.out.print(item+" ");
        }
    }

    private static void twoDimensionArray(){
        int[][] a = new int[5][5];
        int max =0;
        int row =0;
        int col =0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                a[i][j]=new Random().nextInt(100);
                if(a[i][j]>max){
                    max = a[i][j];
                    row = i;
                    col = j;
                }
            }
            System.out.println(Arrays.toString(a[i]));
            System.out.println();
        }
        System.out.println(max);
        System.out.println("row:"+row+";col:"+col);
    }
    /** 借助Arrays的方法对二维数组进行排序。*/
    private static void sortTwoDimensionArray(){
        int[][] a = new int[5][8];
        int[] union = new int[5*8];
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                a[i][j]=new Random().nextInt(100);
            }
            System.arraycopy(a[i],0,union,i*a[i].length,a[i].length);
            System.out.println(Arrays.toString(a[i]));
            System.out.println();
        }
        Arrays.sort(union);
        System.out.println(Arrays.toString(union));
        for(int i=0;i<a.length;i++){
            a[i]= Arrays.copyOfRange(union,i*8,(i+1)*8);
            System.out.println(Arrays.toString(a[i]));
        }
    }
}

package 二分查找;

public class BinarySearchBasic {
    /**
     * 使用这个二分查找的前提是，数组已经是有序数组
     * @param a
     * @param target
     * @return
     */

    public static int binarySearchBasic(int[] a,int target){
        int i=0,j = a.length -1;         //设置指针和初值
        while (i<=j){                    //i~j范围内有东西
            int m = (i+j) >>> 1;
            if(target <a [m]){           //目标在右边
                j = m-1;
            } else if (a[m] < target) {
                i = m + 1;
            }else {                     //找到了，返回目标值的位置索引
                return m;
            }
        }
        return -1;                     //没找到，返回-1
    }

    public static int binarySearchBalance(int[] a,int target){
        int i = 0,j = a.length;
        while (1 < j-i){
            int m = (i+j) >>> 1;
            if(target < a[m]){
                j = m;
            }else{
                i = m;
            }
        }
        if(a[i] == target){
            return i;
        }else {
            return -1;
        }
    }

    private static int binarySearch0(int[] a, int fromIndex, int toIndex, long key) {
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            long midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    public static int binarySearchLeftmost1(int[] a, int target) {
        int i = 0, j = a.length - 1;
        int candidate = -1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (target < a[m]) {
                j = m - 1;
            } else if (a[m] < target) {
                i = m + 1;
            } else {
                candidate = m; // 记录候选位置
                j = m - 1;     // 继续向左
            }
        }
        return candidate;
    }

        public static void main(String[] args) {

        int[] arr = {1,2,43,64,78,79,80,99};
//        int a= binarySearchBasic(arr,78);
//        int c= binarySearchBalance(arr,78);
//          int d=binarySearch0(arr,0,2,78);
            int e = binarySearchLeftmost1(arr,78);
        System.out.println(e);
    }
}

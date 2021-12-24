package szh.BinarySearchNoRecur;

public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr={1,5,8,11,16,25};
        int index=binarySearch(arr,25);
        System.out.println("index="+index);
    }
    //二分查找的非递归实现hh

    /**
     *
     * @param arr 待查找的数组，升序
     * @param target 需要查找的数
     * @return 返回对应下标，-1代表没有找到
     */
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid=(left+right)/2;
            if (arr[mid]==target){
                return mid;
            }else if (arr[mid]>target){
                right=mid-1;
            }else {
                left=mid+1;
            }
        }
        return -1;
    }
}

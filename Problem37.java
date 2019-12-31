package SwordToOffer;

/**
 * 统计一个数字在排序数组中出现的次数。
 */

class Solution37 {

    /*
    思路：
    此处使用非递归。
    先用二分法找到有序数组中的第一个K值的下标，
    再用二分法找到有序数组中最后一个K值的下标，
    两者相减在加1即为K出现的次数。
     */
    public int GetNumberOfK(int [] array , int k) {
        if(array == null || array.length == 0){
            return 0;
        }
        int start = getFirstK(array, k);
        int end = getLastK(array, k);
        if(start != -1){
            return end - start + 1;
        }
        return 0;
    }

    public int getFirstK(int [] array , int k){
        int start = 0;
        int end = array.length - 1;
        int mid;
        while(start <= end){
            mid = (start + end)>>1;
            if(array[mid] == k){
                if(mid == 0 || array[mid - 1]!=k){
                    return mid;
                }else{
                    end = mid - 1;
                }
            }else if(array[mid] > k){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }
    public int getLastK(int [] array , int k){
        int start = 0;
        int end = array.length - 1;
        int mid;
        while(start <= end){
            mid = (start + end)>>1;
            if(array[mid] == k){
                if(mid == array.length - 1 || array[mid + 1]!=k){
                    return mid;
                }else{
                    start = mid + 1;
                }
            }else if(array[mid] > k){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution37 s = new Solution37();
        int[] a = new int[]{1,2,3,3,3,3,4,5};
        System.out.println(s.GetNumberOfK(a, 3));
    }
}

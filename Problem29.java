package SwordToOffer;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Timer;

/**
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
class Solution29 {

    //方法1：利用快排的划分思想，找到某k个比当前划分值小的数
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> mink = new ArrayList<>();
        if(k < 1 || k > input.length){
            return mink;
        }
        int start = 0;
        int end = input.length - 1;
        int index = partition(input,start,end);
        while (index != k - 1){
            if(index < k - 1){
                start = index + 1;
                index = partition(input, start, end);
            }else{
                end = index - 1;
                index = partition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            mink.add(input[i]);
        }
        return mink;
    }

    public static int partition(int[] input, int start, int end){
        int i = start;
        int j = end;
        int pivotkey = input[end];
        while(i < j){
            while(input[i] < pivotkey && i < j){
                i++;
            }
            if(i < j){
                input[j] = input[i];
            }
            while(input[j] > pivotkey && i < j){
                j--;
            }
            if(i < j){
                input[i] = input[j];
            }
        }
        input[i] = pivotkey;
        return i;
    }


    //方法2：利用大根堆，找到前K个小的数字，若当前大根堆内节点数小于k，则将当前节点插入大根堆，并调整堆结构
    //若堆已经有K个节点，则如果当前节点值小于堆的根节点值，则插入，否则不做任何操作
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k){
        ArrayList<Integer> mink = new ArrayList<>();
        if(k < 1 || k > input.length){
            return mink;
        }
        int[] kheap = new int[k];
        for (int i = 0; i < k; i++) {
            heapInsert(kheap, input[i], i);
        }
        for (int i = k; i < input.length; i++) {
            if(input[i] < kheap[0]){
                kheap[0] = input[i];
                heapify(kheap, 0);
            }
        }
        for (int i = 0; i < k; i++) {
            mink.add(kheap[i]);
        }
        return mink;
    }

    public void heapInsert(int[] heap, int value, int index){
        heap[index] = value;
        while(index != 0){
            int parent = (index - 1) >> 1;
            if(heap[parent] < heap[index]){
                swap(heap, parent, index);
                index = parent;
            }else{
                break;
            }
        }
    }

    public void heapify(int[] heap, int index){
        int left = index * 2 + 1;
        int right = index * 2 + 2;
        int largest = index;
        int heapSize = heap.length;
        while(left < heapSize){
            if(heap[left] > heap[index]){
                largest = left;
            }
            if(right < heapSize && heap[right] > heap[largest]){
                largest = right;
            }
            if(largest != index){
                swap(heap, largest, index);
            }else {
                break;
            }
            index = largest;
            left = index * 2 + 1;
            right = index * 2 + 2;
        }
    }

    public void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    public static void main(String[] args) {
        int[] num = new int[]{4,5,1,6,2,7,3,8};
        ArrayList<Integer> res = GetLeastNumbers_Solution(num,4);
        System.out.println(res.toString());
    }
}

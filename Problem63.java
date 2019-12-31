package SwordToOffer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？
 * 如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
class Solution63 {
    /*
    思路：
    用一个大根堆，存储数据流中最小的半部分，一个小根堆，存储数据流中最大的半部分。
    堆使用PriorityQueue实现，默认为小根堆，自定义比较器实现大根堆。
    当前数据个数为偶数时，先将数据加入大根堆，调整后弹出最大值加入小根堆，
    数据为奇数时则正好相反。
    取出中位数时，若数据为奇数，则取小根堆堆顶元素，若为偶数，则取两个堆堆顶元素的平均值。
     */

    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(15,new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    int count = 0;
    public void Insert(Integer num) {
        if((count & 1) == 0){//偶数
            maxHeap.offer(num);
            int max = maxHeap.poll();
            minHeap.offer(max);
        } else{//奇数
            minHeap.offer(num);
            int min = minHeap.poll();
            maxHeap.offer(min);
        }
        count++;
    }

    public Double GetMedian() {
        if((count & 1) == 0){
            return new Double(minHeap.peek() + maxHeap.peek())/2;
        }else {
            return new Double(minHeap.peek());
        }
    }

}
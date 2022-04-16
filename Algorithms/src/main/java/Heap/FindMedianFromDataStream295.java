package Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream295 {
    PriorityQueue<Integer> minH;
    PriorityQueue<Integer> maxH;

    public FindMedianFromDataStream295() {
        minH = new PriorityQueue<>();
        maxH = new PriorityQueue<>(1, new Comparator<Integer>(){
            public int compare(Integer ob1, Integer ob2){
                return ob2.compareTo(ob1);
            }
        });
    }

    public void addNum(int num) {
        maxH.add(num);
        minH.add(maxH.poll());
        if(minH.size()>maxH.size()){
            maxH.add(minH.poll());
        }
    }

    public double findMedian() {
        if(minH.size()==maxH.size())
            return (double) (maxH.peek()+minH.peek())*0.5 ;
        else
            return (double) maxH.peek();
    }
}

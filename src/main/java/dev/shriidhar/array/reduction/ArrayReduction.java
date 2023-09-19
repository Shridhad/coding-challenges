package dev.shriidhar.array.reduction;

import java.util.List;
import java.util.PriorityQueue;

public class ArrayReduction {

    public static int reduce(List<Integer> array) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.addAll(array);
        int cost = 0;

        while (queue.size() > 1) {
            Integer num1 = queue.remove();
            Integer num2 = queue.remove();

            int sum = num1 + num2;
            cost += sum;
            queue.add(sum);
        }
        return cost;
    }
}

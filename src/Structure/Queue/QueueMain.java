package Structure.Queue;

import Structure.Node;

public class QueueMain {
    public static void main(String[] args) {
        Queue queue = new Queue();

        queue.offer(new Node("1"));
        queue.offer(new Node("2"));
        queue.offer(new Node("3"));

        System.out.println(queue.toString());

        System.out.println(queue.peek().getItem());
        System.out.println(queue.poll().getItem());
        System.out.println(queue.toString());
    }
}

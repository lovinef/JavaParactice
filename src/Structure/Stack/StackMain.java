package Structure.Stack;

import Structure.Node;

/*
* 후입선출
* */
public class StackMain {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.pop();

        stack.push(new Node("1"));
        stack.push(new Node("2"));
        stack.push(new Node("3"));
        System.out.println(stack.toString());


        System.out.println(stack.pop().getItem());
        System.out.println(stack.peek().getItem());
        System.out.println(stack.toString());
    }
}

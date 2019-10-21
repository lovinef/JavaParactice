package Structure.Stack;

import Structure.Node;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Node> stackList = new ArrayList<>();

    public Node pop(){
        if(isEmpty()) return null;

        Node node = stackList.get(stackList.size() -1);
        stackList.remove(stackList.size() - 1);

        return node;
    }

    public void push(Node node){
        stackList.add(node);
    }

    public void clear(){
        stackList.clear();
    }

    public Node peek(){
        if(isEmpty()){
            return null;
        }

        return stackList.get(stackList.size() - 1);
    }

    public String toString(){
        if(stackList == null || stackList.size() == 0){
            return "is empty";
        }else{
            StringBuilder result = new StringBuilder();
            result.append("\n").append("----------").append("\n");
            for(int i = stackList.size() -1 ; i >= 0 ; i--){
                result.append("item : ").append(stackList.get(i).getItem()).append("\n");
            }
            result.append("----------").append("\n");
            return result.toString();
        }
    }

    private boolean isEmpty(){
        if(stackList == null || stackList.size() == 0){
            System.out.println("is empty");
            return true;
        }

        return false;
    }
}

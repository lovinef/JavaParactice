package Structure.Queue;

import Structure.Node;

import java.util.ArrayList;
import java.util.List;

/*
선입선출
offer
peek
isEmpty
 */
public class Queue {
    List<Node> queueList = new ArrayList<>();

    public void offer(Node newNode){
        queueList.add(newNode);
    }

    public Node peek(){
        if(isEmpty())   return null;

        Node peekNode = queueList.get(0);
        queueList.remove(0);
        return peekNode;
    }

    public Node poll(){
        if(isEmpty())   return null;

        Node peekNode = queueList.get(0);
        return peekNode;
    }

    private boolean isEmpty(){
        if(queueList == null || queueList.size() == 0){
            System.out.println("is empty");
            return true;
        }

        return false;
    }

    public String toString(){
        if(queueList == null || queueList.size() == 0){
            return "is empty";
        }else{
            StringBuilder result = new StringBuilder();
            result.append("\n").append("----------").append("\n");
            for(int i = 0 ; i < queueList.size() ; i++){
                result.append("item : ").append(queueList.get(i).getItem()).append("\n");
            }
            result.append("----------").append("\n");
            return result.toString();
        }
    }
}

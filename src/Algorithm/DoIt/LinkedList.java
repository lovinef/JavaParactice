package Algorithm.DoIt;

import java.util.Comparator;

public class LinkedList<E> {
    class Node<E>{
        private E data;         // 데이터
        private Node<E> next;   // 다음 노드

        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    // 맨 처음에 노드 삽입
    public void addFirst(E obj){
        Node<E> ptr = head;
        head = crnt = new Node<E>(obj, ptr);
    }

    // 꼬리에 노드 삽입
    public void addLAast(E obj){
        if(head == null){
            addFirst(obj);
        }else{
            Node<E> ptr = head;
            while(ptr.next != null){
                ptr = ptr.next;
            }
            ptr.next = crnt = new Node<E>(obj, null);   // 마지막이므로 next 값은 null이 된다.
        }
    }

    public void removeFirst(){
        if(head == null) return;
        head = crnt = head.next;
    }

    public void removeLast(){
        if(head == null) return;
        Node<E> ptr = head;
        Node<E> pre = head;
        while(ptr.next != null){    // 마지막 노드를 찾는다.
            pre = ptr;
            ptr = ptr.next;
        }

        pre.next = null;
        crnt = pre; // 현재 노드를 마지막 전 노드로 지정한다
    }

    public void remove(Node p){
        if(head == null) return;

        Node<E> ptr = head;
        while(ptr.next != p){   // 같은 값 직전까지 이동시킴.
            ptr = ptr.next;
            if(ptr == null) return; // 같은 값이 없음
        }

        ptr.next = p.next;
        crnt = ptr;
    }

    // 모든 노드 삭제
    public void clear(){
        while(head != null){
            removeFirst();  // 첫번째 노드 삭제
        }
        crnt = null;
    }

    public boolean next(){
        if(crnt != null && crnt.next != null){
            crnt = crnt.next;
            return true;
        }else{
            return false;
        }
    }

    public E search(E obj, Comparator<E> comparator){
        Node<E> ptr = head; // 현재 위치

        while(ptr != null){
            if(comparator.compare(obj, ptr.data) == 0){
                crnt = ptr;
                return ptr.data;
            }
            ptr = ptr.next;
        }

        return null;
    }

    public void printCurrentNode(){
        if(crnt == null)
            System.out.println("선택한 노드가 없습니다.");
        else
            System.out.println(crnt.data);
    }

    private Node<E> head;   // 머리 노드
    private Node<E> crnt;   // 선택 노드

    public static void main(String[] args) {

    }
}

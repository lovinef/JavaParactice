package Algorithm.DoIt;

import kotlin.reflect.jvm.internal.impl.load.java.descriptors.NullDefaultValue;

import java.util.Comparator;

public class BinTree<K, V> {
    static class Node<K, V>{
        private K key;
        private V value;

        private Node<K, V> left;    // 왼쪽 자식 노드
        private Node<K, V> right;   // 오른쪽 자식 노드

        public Node(K key, V value, Node<K, V> left, Node<K, V> right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        K getKey(){
            return key;
        }

        V getValue(){
            return value;
        }

        void print(){
            System.out.println(value);
        }
    }

    private Node<K, V> root;    // 루트
    private Comparator<? super K> comparator = null; // 비교자

    public BinTree(){   // 이진트리 생성자
        root = null;
    }

    public BinTree(Comparator<? super K> c){
        this();
        comparator = c;
    }

    private int comp(K key1, K key2){
        return comparator.compare(key1, key2);
    }

    private V search(K key){
        Node<K, V> p = root;    // 루트부터 시작

        while(true){
            if(p == null)   return null;

            switch (comp(key, p.getKey())){
                case 0: // 같은 경우
                    return p.getValue();
                case -1:    // key가 작은 경우 왼쪽에서 검색
                    p = p.left;
                    break;
                case 1:     // key가 큰 경우 오른쪽에서 검색
                    p = p.right;
                    break;
                default:
                    break;
            }
        }
    }

    private void addNode(Node<K, V> node, K key, V value){
        switch (comp(key, node.getKey())){
            case 0: // 같은 경우 아무것도 하지 않음.
                return;
            case -1:  // 값이 작은 경우 왼쪽 트리 이동.
                if(node.left == null)   // 왼쪽 노드의 값이 없는 경우 즉시 입력
                    node.left = new Node<K, V>(key, value, null, null);
                else                    // 왼쪽 노드의 값이 있는 경우 검색
                    addNode(node.left, key, value);
            case 1:
                if(node.right == null)
                    node.right = new Node<K, V>(key, value, null, null);
                else
                    addNode(node.right, key, value);
            default:
                break;
        }
    }


}

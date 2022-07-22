package SDE.StackAndQueueII;

import java.util.HashMap;

public class LRUcache {
    class Node{
        int key;
        int value;
        Node prev;
        Node next;
        
        Node(int key,int value){
            this.key=key;
            this.value=value;
            this.prev=null;
            this.next=null;
        }
    }
    
    class LRUCache {
    
        
        HashMap<Integer,Node> map;
        int cap;
        Node head;
        Node tail;
        
        public LRUCache(int capacity) {
            head=new Node(0,0);
            tail=new Node(0,0);
            head.next=tail;
            tail.prev=head;
            map = new HashMap<>();
            cap = capacity;
        }
        
        public int get(int key) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                deleteNode(node);
                addToHead(node);
                return node.value;
            }
            return -1;
        }
        
        public void put(int key, int value) {
            if(!map.containsKey(key)){
                
                if(map.size()<cap){
                    Node node = new Node(key,value);
                    map.put(key,node);
                    addToHead(node);
                }else{
                    map.remove(tail.prev.key);
                    deleteNode(tail.prev);
                    Node node = new Node(key,value);
                    addToHead(node);
                    map.put(key,node);
                }
            }else{
                Node oldnode = map.get(key);
                oldnode.value=value;
                deleteNode(oldnode);
                addToHead(oldnode);
            }
        }
        
        public void addToHead(Node node){
            node.next=head.next;
            node.next.prev=node;
            node.prev=head;;
            head.next=node;
        }
        
        public void deleteNode(Node node){
            node.prev.next=node.next;
            node.next.prev=node.prev;     
        }
    }
}

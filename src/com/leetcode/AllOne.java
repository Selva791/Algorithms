package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class AllOne {
    public static void main(String[] args) {
        AllOne a=new AllOne();
        a.inc("a");
        a.inc("b");
        a.inc("b");
        a.inc("c");
        a.inc("c");
        a.inc("c");
        a.dec("b");
        a.dec("b");
        System.out.println(a.getMinKey());
        a.dec("a");
        System.out.println(a.getMaxKey());
        System.out.println(a.getMinKey());

    }
    class Node{
        Node pre,next;
        Set<String> keys;
        int count;
        Node(int count){
            keys=new HashSet<>();
            this.count=count;
        }
    }

    Map<String,Integer> keyCount;
    Map<Integer,Node> countNode;
    Node head;
    Node tail;
    public AllOne() {
        keyCount=new HashMap<>();
        countNode=new HashMap<>();
        head=new Node(Integer.MAX_VALUE);
        tail=new Node(Integer.MIN_VALUE);
        head.next=tail;
        tail.pre=head;
    }

    public void inc(String key) {
        if(keyCount.containsKey(key)){
            addValues(key,1);
        }else{
            keyCount.put(key,1);
            Node node=countNode.get(1);
            if(node==null){
                node = new Node(1);
                Node temp=head.next;
                head.next=node;
                node.pre=head;
                node.next=temp;
                temp.pre=node;
                countNode.put(1,node);
            }
            node.keys.add(key);
        }
    }
    public void addValues(String key, int off){
        int count_key=keyCount.get(key);
        Node node=countNode.get(off+count_key);
        keyCount.put(key,count_key+off);

        Node pre_node=countNode.get(count_key);
        if(node==null){
            node=new Node(off+count_key);
            Node temp=pre_node.next;
            pre_node.next=node;
            node.pre=pre_node;
            node.next=temp;
            temp.pre=node;
            countNode.put(off+count_key,node);
            System.out.print(pre_node.keys);
            node.keys.add(key);
        }else{
            node.keys.add(key);
        }

        removeNode(pre_node,key);

    }
    public void dec(String key) {
        if(keyCount.containsKey(key)){
            int total=keyCount.get(key);
            Node nd=countNode.get(total);
            if(total==1){
                keyCount.remove(key);
            }else{
                keyCount.put(key,total-1);
            }
            Node newNode=null;
            if(!countNode.containsKey(total-1)&&total-1>0){
                newNode=new Node(total-1);
                Node t=nd.pre;
                t.next=newNode;
                newNode.pre=t;
                newNode.next=nd;
                nd.pre=newNode;
                countNode.put(total-1,newNode);
                newNode.keys.add(key);
            }else if(total-1>0){
                newNode= countNode.get(total-1);
                newNode.keys.add(key);
            }
            removeNode(nd,key) ;

        }
    }
    public void removeNode(Node node, String key){
        node.keys.remove(key);
        if(node.keys.size()==0){
            countNode.remove(node.count);
            removeNodeFromChain(node);
        }
    }
    public void removeNodeFromChain(Node node){
        Node pre=node.pre;
        Node nxt=node.next;
        pre.next=nxt;
        nxt.pre=pre;
    }
    public String getMaxKey() {
        if(tail.pre!=null&&tail.pre.keys.size()>0){
            return tail.pre.keys.iterator().next();
        }
        return "";
    }

    public String getMinKey() {

        if(head.next!=null&&head.next.keys.size()>0){
            return head.next.keys.iterator().next();
        }
        return "";
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */
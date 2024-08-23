package com.roku;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MaxStack {
    public static void main(String[] args) {
        MaxStack maxStack=new MaxStack();
        Test val=Test.valueOf(Test.DOWN.toString());
      //  maxStack.push();
    }
        class ListNode{
            ListNode prev;
            ListNode next;
            int val;
            ListNode(int val){
                this.val=val;
                prev=next=null;
            }
        }
        ListNode head;
        ListNode tail;
        TreeMap<Integer, List<ListNode>> map;
        public MaxStack() {
            head=new ListNode(-1);
            tail=new ListNode(-1);
            head.next=tail;
            tail.prev=head;
            map=new TreeMap<>();
        }

        public void push(int x) {
            ListNode pNode=tail.prev;
            pNode.next=new ListNode(x);
            pNode.next.next=tail;
            tail.prev=pNode.next.next;
            List<ListNode> list= map.getOrDefault(x, new ArrayList<ListNode>());
            list.add(pNode.next.next);
            map.put(x, list);
        }

        public int pop() {
            ListNode ans=tail.prev;
            removeNode(ans);
            return ans.val;
        }

        public void removeNode(ListNode node){
            System.out.println(map);
            System.out.println(node.val);
            List<ListNode> nodeList=map.get(node.val);
            ListNode nd=nodeList.get(nodeList.size()-1);
            ListNode nxt=nd.next;
            ListNode prev=nd.prev;
            prev.next=nxt;
            nxt.prev=prev;
            if(nodeList.size()==1)map.remove(node.val);
        }

        public int top() {
            ListNode nd=tail.prev;
            return nd.val;
        }

        public int peekMax() {
            return map.lastKey();
        }

        public int popMax() {
            int max= map.lastKey();
            List<ListNode> nodes=map.get(max);
            removeNode(nodes.get(nodes.size()-1));
            return max;
        }
    }

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */


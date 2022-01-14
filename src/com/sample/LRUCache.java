package com.sample;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	public static void main(String[] args) {
		LRUCache c=new LRUCache(2);
		c.put(1, 1);
		c.put(2, 2);
		c.get(1);
		c.put(3,3);
		c.get(2);
		c.put(4, 4);
	}

	Node head = new Node(-1, -1);
	Node tail = new Node(-1, -1);

	class Node {
		int val, key;
		Node prev, next;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
			prev = next = null;
		}
	}

	int size;
	Map<Integer, Node> mp = new HashMap<>();

	public LRUCache(int capacity) {
		size = capacity;
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		Node v = mp.get(key);
		if (v == null) {
			return -1;
		}
		remove(v);

		update(tail, v);
		return v.val;
	}

	public void put(int key, int value) {
		Node temp = mp.get(key);

		if (temp == null) {
			temp = new Node(key, value);
			size--;
		} else {
			temp.val = value;
			remove(temp);
			mp.remove(key);
		}
		if (size < 0) {
			Node v = head.next;
			remove(v);
			mp.remove(v.key);
			System.out.println(v.key);
			size++;
		}
		update(tail, temp);
		mp.put(key, temp);
	}

	private void remove(Node cur) {
		Node n = cur.prev;
		Node m = cur.next;
		cur.prev=cur.next=null;
		n.next = m;
		m.prev = n;
	}

	private void update(Node tail, Node node) {
		Node n = tail.prev;
		n.next = node;
		node.prev = n;
		node.next = tail;
		tail.prev=node;
	}

}

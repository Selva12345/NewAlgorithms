package com.design;

public enum Move {
	UP(1),
	DOWN(2),
	RIGHT(3),
	LEFT(4);
	private final int val;
	Move(int val){
	this.val=val;	
	}
	public int getVal(){
		return  val;
	}
}

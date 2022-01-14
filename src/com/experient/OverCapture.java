package com.experient;

import java.io.Serializable;

public class OverCapture {
	class Data implements Serializable{
		int a,b;
		Data(int a,int b){
			this.a=a;
			this.b=b;
		}
	}
	public static void main(String[] args) {
		OverCapture o=new OverCapture();
		o.caller();
		int a=434555567;
		int b=a*10;
		System.out.println();
	}
	private void caller() {
		
		Data d=new Data(2,5);
		
	}

}

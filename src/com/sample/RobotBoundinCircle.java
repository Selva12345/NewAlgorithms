package com.sample;

public class RobotBoundinCircle {
	public static void main(String[] args) {
		RobotBoundinCircle r=new RobotBoundinCircle();
		System.out.println(r.isRobotBounded("GLGLGGLGL"));
	}

	public boolean isRobotBounded(String instructions) {
		char arr[] = instructions.toCharArray();
		int n = arr.length;
		int dir[][] = {{ 1, 0 },{ 0, -1 }, { -1, 0 },{ 0, 1 } };
		int x = 0, y = 0;
		int v = 3, i = 0, j = 0;
		while (j < (4 * n)) {
			i = j % (n);
			
				if (arr[i] == 'L') {
					v=v-1;
                    v=v==-1?3:v;
				}
				if (arr[i] == 'R') {
				    v=(v+1)%4;
                    
				}
				if (arr[i] == 'G') {
					x += dir[v][0];
					y += dir[v][1];
				}
			
			if (x == 0 && y == 0)
				return true;
			j++;
		}
            
		return false;
	}

	
}

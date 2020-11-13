package com.leetcode;

import java.util.Stack;

public class AsteroidCollision {
	public static void main(String[] args) {
		int res[]= {1,-1,-2,-2};
		AsteroidCollision a=new AsteroidCollision();
		a.asteroidCollision(res);
	}

	public int[] asteroidCollision(int[] asteroids) {
		int n = asteroids.length;
		if (n == 0)
			return asteroids;
		Stack<Integer> res = new Stack<>();
		int start = -1;
		for (int i = 0; i < n; i++) {
			if (asteroids[i] > 0) {
				start = i;
				break;
			} else {
				res.push(asteroids[i]);
			}
		}
       if(start!=-1)
		res.push(asteroids[start]);
     else return res.stream().mapToInt(i -> i).toArray();
     
		for (int i = start+1; i < n; i++) {
			int temp = asteroids[i];
			if ((!res.isEmpty()&&(res.peek() < 0 && temp > 0))||(!res.isEmpty()&&( res.peek() > 0 && temp < 0))) {
				while (!res.isEmpty() && (res.peek() > 0 && temp < 0)) {
					if (Math.abs(res.peek()) < Math.abs(temp)) {
						res.pop();
					} else if (Math.abs(res.peek()) == Math.abs(temp)) {
						res.pop();
						temp = 0;
						break;
					}else {
                      
                        break;
                          }

				}
				if(res.isEmpty()&&temp!=0) {
					   res.push(temp);

				}
				else if (!res.isEmpty()&&temp != 0&&res.peek()<0)
				   res.push(temp);
                else if(!res.isEmpty()) {
                	if((temp > 0&&res.peek()>0)||(temp<0&&res.peek()<0)){
                    res.push(temp);

                }
                }	

			} else {
				res.push(temp);

			}

		}

		return res.stream().mapToInt(i -> i).toArray();
	}
}

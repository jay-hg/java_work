package com.study.test;

public class Count3exist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KidCircle kc = new KidCircle(5);
		
		while (kc.count > 0) {
			
		}
	}

}

class Kid {
	int id;
	Kid left;
	Kid right;
	
	public Kid (int id) {
		this.id = id;
		
	}
}

class KidCircle {
	Kid first;
	Kid last;
	Kid[] kids;
	int index;
	int count;
	
	public KidCircle(int n) {
		count = n;
		kids = new Kid[n];
		if (n>0) {
			for (int i=0; i<n; i++) {
				
				add(new Kid(i+1));
			}
		}
	}
	
	public void add(Kid kid) {
		
		kids[index] = kid;
		if (index == 0) {
			kid.right = kid;
			kid.left = kid;
			first = kid;
			last = kid;
			
		} else {
			kid.right = first;
			kid.left = last;
			last.right = kid;
			first.left = kid;
			last = kid;
		}
		
		index++;
		
	}
	
	public void deleted(int n) {
		index = n;
		kids[index].right.left = kids[index].left;
		kids[index].left.right = kids[index].right;
		
		if (last == kids[index])
			last = kids[index].left;
		if (first == kids[index])
			first = kids[index].right;
		
		kids[index].right = null;
		kids[index].left = null;
		kids[index] = null;
		
		count--;
	}
}
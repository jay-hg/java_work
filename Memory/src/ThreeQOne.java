import java.util.ArrayList;
import java.util.List;


public class ThreeQOne {

	public static void main(String[] args) {
		int o = new KidCircle(500).count()+1;
		System.out.println(o);
	}

}

class Kid {
	int id;
	Kid left;
	Kid right;
	
	public Kid(int id) {
		this.id = id;
	}
}

class KidCircle {
	Kid[] kids;
	Kid first;
	Kid last;
	int index;
	
	public KidCircle(int size) {
		kids = new Kid[size];
		index = 0;
		
		for (int i=0; i<size; i++) {
			Kid kid = new Kid(i);
			add(kid);
		}
	}
	
	public void add(Kid kid) {
		if (index == 0) {
			first = kid;
			last = kid;
			kid.left = last;
			kid.right = first; 
		} else {
			kid.left = last;
			kid.right = first; 
			last.right = kid;
			first.left = kid;
			last = kid;
		}
		
		kids[index] = kid;
		index ++;
	}

	public void delete(Kid kid) {
		kid.left.right = kid.right;
		kid.right.left = kid.left;
		if (kid == first) {
			first = kid.right;
		}
		if (kid == last) {
			last = kid.left;
		}
		
		index --;
	}
	
	public int count() {
		int rowNum = 1;
		Kid k = first;
		while (index > 0) {
			if (rowNum == 3) {
				delete(k);
				rowNum = 0;
			}
			k = k.right;
			rowNum ++;
		}
		return k.id;
	}
}
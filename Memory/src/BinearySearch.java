
public class BinearySearch {

	public static void main(String[] args) {
		int a[] = {3,4,6,7,9,13,56,78,94,106,213,510,635};
		int b = search(a,56);
		Sort.p(a);
		System.out.println(b);
	}

	private static int search(int[] a, int i) {
		int mid;
		int begin=0,end=a.length-1;
		
		while (begin <= end) {
			mid = (begin+end)/2;
			if (a[mid] == i) {
				return mid;
			} else if (a[mid] > i) {
				end = mid-1;
			} else {
				begin = mid+1;
			}
		}
		return -1;
	}

}


public class Sort {
	public static void main(String[] args) {
		int a[] = {23,45,21,34,67,86,12,45,22,78,96};
		p(a);
		//selectionSort(a);
		//p(a);
		bubbleSort(a);
		p(a);
	}

	private static void bubbleSort(int[] a) {
		int temp = 0;
		for (int i=a.length-1; i>0; i--) {
			for (int j=1; j<=i; j++) {
				if (a[j-1]>a[j]) {
					temp = a[j];
					a[j] = a[j-1];
					a[j-1] = temp;
				}
			}
		}
	}

	public static void p(int[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}

	private static void selectionSort(int[] a) {
		int index = 0;
		int temp = 0;
		for (int i=a.length-1; i>0; i--) {
			index = 0;
			for (int j=1; j<=i ; j++) {
				if (a[index]<a[j]) {
					index = j;
				}
			}
			temp = a[i];
			a[i] = a[index];
			a[index] = temp;	
		}
	}
}

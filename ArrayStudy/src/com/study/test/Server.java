package com.study.test;

public class Server<T> {

	public void SelectionSort (T[] a) {
		int index = 0;
		T temp = null;
		for (int i=a.length-1; i>=1; i--) {
			
			for (int j=1; j<=i; j++) {
				index = 0;
				if (a[index].compareTo(a[j])>0) {
					index = j;
				}
			}
			
			if (index != i) {
				temp = a[i];
				a[i] = a[index];
				a[index] = temp;
			}
			
		}
	}
	
	public void BubbleSort (T[] a) {
		T temp = null;
		for (int i=a.length-1; i>=1; i--) {
			for (int j=0; j<i; j++) {
				if (a[j].compareTo(a[j+1]) > 0) {
					temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
	}
	
	public void print(T[] a) {
		for (int i=0; i<a.length; i++) {
			System.out.println(a[i]+" ");
		}
	}
}

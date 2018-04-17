
public class Js {

	int zm[] = new int[50];
	int sum = 0;
	int temp = 0;
	int temp2 = 0;
	
	public static void main(String[] args) {
		new Js().launch();
	}
	
	public void launch() {
		zm[0] = 80000000;
		for (int i=1; i<50; i++) {
			for (int j=i-2,k=0; j>=0 && k<6; j--,k++) {
				temp += zm[j];
			}
			
			for (int j=i-8,k=0; j>=0 && k<4; j--,k++) {
				temp2 += zm[j]*0.01;
			}
			
			zm[i] = (int) (zm[i-1]*0.1 + temp*0.05);
			temp=0;
			temp2=0;
			sum += zm[i];
			System.out.println(i+":"+zm[i]);
		}
		
		sum += zm[0];
		System.out.println(sum);
	}

}

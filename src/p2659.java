import java.util.Arrays;
import java.util.Scanner;

public class p2659 {
	public static int num = 10000;
	public static int arr[] = new int[4];
	public static int mul[] = { 1000, 100, 10, 1 };
	public static int order[] = new int[10000];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<4; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0; i<4; i++) {
			int temp = 0;
			for(int j=0; j<4; j++) {
				temp += arr[(i + j)%4] * mul[j];
			}
			if(num > temp) num = temp;
		}
		
		int nu = 1;
		for(int i=1; i<=9; i++) {
			arr[0] = i;
			for(int j=1; j<=9; j++) {
				arr[1] = j;
				for(int k=1; k<=9; k++) {
					arr[2] = k;
					for(int l=1; l<=9; l++) {
						arr[3] = l;
						int numm = 10000;
						for(int m=0; m<4; m++) {
							int temp = 0;
							for(int n=0; n<4; n++) {
								temp += arr[(m + n)%4] * mul[n];
							}
							if(numm > temp) numm = temp;
						}
						if(order[numm] > 0) continue;
						else {
							order[numm] = nu++;
							//System.out.println(numm+" : "+order[numm]);
						}
					}
				}
			}
		}
		
		System.out.println(order[num]);
	}

}

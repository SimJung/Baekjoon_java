
import java.util.Scanner;
public class p2562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[9];
		for(int i=0; i<9; i++)
			arr[i] = sc.nextInt();
		int maxIdx = 0;
		for(int i=1; i<9; i++) {
			if(arr[i] > arr[maxIdx]) {
				maxIdx = i;
			}
		}
		System.out.println(arr[maxIdx]);
		System.out.println(maxIdx+1);
	}

}

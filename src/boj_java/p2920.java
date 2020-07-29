package boj_java;
import java.util.Scanner;
public class p2920 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[8];
		
		String ans = "mixed";
		for(int i=0; i<8; i++) {
			arr[i] = sc.nextInt();
		}
		
		if(arr[0] == 1)
			ans = "ascending";
		else if(arr[0] == 8)
			ans = "descending";
		
		for(int i=1; i<7; i++) {
			if(ans == "ascending") {
				if(arr[i+1] != arr[i]+1)
					ans = "mixed";
			}else if(ans == "descending") {
				if(arr[i+1] != arr[i]-1)
					ans = "mixed";
			}
		}
		
		System.out.println(ans);
	}

}

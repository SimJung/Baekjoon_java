import java.util.Arrays;
import java.util.Scanner;

public class p1213 {
	public static char arr[];
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(sc.next());
		N = sb.length();
		arr = sb.toString().toCharArray();
		Arrays.sort(arr);
		for(int i=0; i<sb.length()-1; i++) {
			for(int j=1; j<sb.length(); j++) {
				char temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				if(chk(sb.length())) {
					for(int k=0; k<sb.length(); k++) {
						System.out.print(arr[k]);
					}
					System.out.println();
					return ;
				}
			}
		}
	}
	
	public static boolean chk(int N) {
		for(int i=0; i<N/2; i++) {
			if(arr[i] != arr[N-1-i]) return false;
		}
		return true;
	}
}

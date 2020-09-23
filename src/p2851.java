import java.util.Scanner;

public class p2851 {
	public static int arr[] = new int[10], sum, nowDiff=100;
	public static boolean chk = true;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<10; i++) {
			arr[i] = sc.nextInt();
			if(chk) {
				if(Math.abs(100 - (sum+arr[i])) < nowDiff) {
					sum += arr[i];
					nowDiff = Math.abs(100 - sum);
				}else if(Math.abs(100 - (sum+arr[i])) == nowDiff){
					sum += arr[i];
					nowDiff = Math.abs(100 - sum);
				}else {
					chk = false;
				}
			}
			
		}
		System.out.println(sum);
	}

}

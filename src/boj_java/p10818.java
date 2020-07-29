package boj_java;
import java.util.Scanner;
public class p10818 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n, num, max=-1000001, min=1000001;
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			num = sc.nextInt();
			if(num > max)
				max = num;
			if(num < min)
				min = num;
		}
		
		System.out.println(min + " " + max);
	}

}

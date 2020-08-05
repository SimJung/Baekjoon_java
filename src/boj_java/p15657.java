package boj_java;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;
public class p15657 implements Comparable<String>{
	static int N, M;
	static int[] arr;
	static int[] ans;
	static BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		ans = new int[M];
		
		for(int i=0; i<N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		
	}
	
	public static void perm(int );
	
	public int compareTo(String a) {
		// TODO Auto-generated method stub
		return 0;
	}
}

	

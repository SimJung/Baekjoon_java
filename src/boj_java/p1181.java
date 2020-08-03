package boj_java;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class p1181 {
	public static void main(String args[]) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String arr[] = new String[N];
		for(int i=0; i<N; i++) {
			arr[i] = bf.readLine();
		}
		
		
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				if(s1.length() < s2.length()) return -1;
				else if(s1.length() > s2.length()) return 1;
				else {
					for(int i=0; i<s1.length(); i++) {
						if(s1.charAt(i) > s2.charAt(i)) return 1;
						else if(s1.charAt(i) < s2.charAt(i)) return -1;
					}
				}
				return 0;
			}
		});
		
		System.out.println(arr[0]);
		for(int i=1; i<N; i++) {
			if(!arr[i].equals(arr[i-1]))
			System.out.println(arr[i]);
		}
	}
	
	
	
	
}

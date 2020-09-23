import java.util.Arrays;
import java.util.Scanner;

public class p11399 {
	static class Person implements Comparable<Person>{
		public int idx;
		public int time;
		public Person(int idx, int time) {
			super();
			this.idx = idx;
			this.time = time;
		}
		public int compareTo(Person p) {
			return time - p.time;
		}
		
	}

	public static Person[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		arr = new Person[N];
		for(int i=0; i<N; i++) {
			int t = sc.nextInt();
			arr[i] = new Person(i, t);
		}
		Arrays.sort(arr);
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<=i; j++) {
				sum += arr[j].time;
			}
		}
		System.out.println(sum);
	}

}

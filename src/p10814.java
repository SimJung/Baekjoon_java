
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
public class p10814 {
	public static class Member implements Comparable<Member>{
		int age;
		String name;
		int no;
		
		public int compareTo(Member m) {
			if(this.age > m.age) return 1;
			else if(this.age < m.age) return -1;
			else {
				if(this.no > m.no) return 1;
				else if(this.no < m.no) return -1;
			}
			return 0;
		}
		
		public String toString() {
			return age + " " + name;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		Member[] arr = new Member[N];
		StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(bf.readLine());
			arr[i] = new Member();
			arr[i].age = Integer.parseInt(st.nextToken());
			arr[i].name = st.nextToken();
			arr[i].no = i;
		}
		
		Arrays.sort(arr);
		for(int i=0; i<N; i++)
			System.out.println(arr[i]);
	}

}

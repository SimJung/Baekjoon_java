package boj_java;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class p10818 {

	public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n, num, max=-1000001, min=1000001;
		n = Integer.parseInt(bf.readLine());
		String s = bf.readLine();
		StringTokenizer st = new StringTokenizer(s);
		for(int i=0; i<n; i++) {
			num = Integer.parseInt(st.nextToken());
			if(num > max)
				max = num;
			if(num < min)
				min = num;
		}
		
		System.out.println(min + " " + max);
	}

}

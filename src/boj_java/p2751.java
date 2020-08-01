package boj_java;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.ArrayList;
public class p2751 {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		ArrayList<Integer> arr = new ArrayList<Integer>();
		for(int i=0; i<N; i++)
			arr.add(Integer.parseInt(bf.readLine()));
		Collections.sort(arr);
		for(int i=0; i<N; i++) {
			bw.write(arr.get(i)+"\n");
		}
		bw.flush();
		bw.close();
	}

}

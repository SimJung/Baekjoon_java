import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class p5430 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		while(T-- > 0) {
			StringBuilder fun = new StringBuilder(br.readLine());
			int N = Integer.parseInt(br.readLine());
			StringBuilder numStr = new StringBuilder(br.readLine());
			numStr.delete(0, 1);
			numStr.delete(numStr.length()-1, numStr.length());
			
			StringTokenizer st = new StringTokenizer(numStr.toString(), ",");
			ArrayList<String> arrList = new ArrayList<>();
			for(int i=0; i<N; i++) arrList.add(st.nextToken());
			
			int nowDel = 0;
			boolean error = false;
			for(int i=0; i<fun.length(); i++) {
				if(fun.charAt(i) == 'R') {
					if(nowDel == 0) nowDel = arrList.size()-1;
					else nowDel = 0;
				}else {
					if(arrList.size() > 0) {
						arrList.remove(nowDel);
						if(nowDel == arrList.size()) nowDel--;
					}
					else {
						error = true;
						break;
					}
				}
			}
			
			if(error) System.out.println("error");
			else {
				System.out.print("[");
				if(nowDel == 0) {
					for(int i=0; i<arrList.size()-1; i++) {
						System.out.print(arrList.get(i)+",");
					}
					if(arrList.size()>0)
						System.out.print(arrList.get(arrList.size()-1));
				}else {
					for(int i=arrList.size()-1; i>0; i--) {
						System.out.print(arrList.get(i)+",");
					}
					if(arrList.size()>0)
						System.out.print(arrList.get(0));
				}
				System.out.println("]");
			}
		}
	}

}

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class p9375 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		HashMap<String, Integer> hm = new HashMap<>();
		String arr[] = new String[2];
		
		while(T-- > 0) {
			hm.clear();
			
			int N = sc.nextInt();
			while(N-- > 0) {
				arr[0] = sc.next();
				arr[1] = sc.next();
				
				if(hm.containsKey(arr[1])) {
					hm.replace(arr[1], hm.get(arr[1])+1);
				}else {
					hm.put(arr[1], 1);
				}
			}
			int ans = 1;
			Iterator<String> it = hm.keySet().iterator();
			while(it.hasNext()) {
				ans *= hm.get(it.next())+1;
			}
			System.out.println(ans-1);
		}
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class p7662 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		PriorityQueue<Long> asc = new PriorityQueue<>();
		PriorityQueue<Long> desc = new PriorityQueue<>(Collections.reverseOrder());
		HashMap<Long, Integer> hashMap = new HashMap<>();
		
		while(T-- > 0) {
			asc.clear();
			desc.clear();
			hashMap.clear();
			
			int N = Integer.parseInt(br.readLine());
			while(N-- > 0) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				long p;
				
				if(st.nextToken().equals("I")) {
					p = Long.parseLong(st.nextToken());
					asc.offer(p);
					desc.offer(p);
					if(hashMap.containsKey(p)) {
						hashMap.replace(p, hashMap.get(p)+1);
					}else {
						hashMap.put(p, 1);
					}
					
					
				}else {
					p = Integer.parseInt(st.nextToken());
					long dNum = 0;
					if(p == -1 && !asc.isEmpty()) {
						dNum = asc.poll();
					}else if(p == 1 && !desc.isEmpty()){
						dNum = desc.poll();
					}
					
					if(hashMap.containsKey(dNum)) {
						if(hashMap.get(dNum) > 1) {
							hashMap.replace(dNum, hashMap.get(dNum)-1);
						}else {
							hashMap.remove(dNum);
						}
					}
					while(!asc.isEmpty()) {
						if(hashMap.containsKey(asc.peek())) break;
						else asc.poll();
					}
					while(!desc.isEmpty()) {
						if(hashMap.containsKey(desc.peek())) break;
						else desc.poll();
					}
				}
			}
			if(hashMap.isEmpty()) {
				System.out.println("EMPTY");
			}else {
				System.out.println(desc.poll()+" "+asc.poll());
			}
			
		}
		
	}
}

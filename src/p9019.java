import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p9019 {
	public static class Info{
		public int num;
		public int prevNum;
		public char method;
		public Info(int n, int p, char m) {
			super();
			num = n;
			prevNum = p;
			method = m;
		}
	}
	
	public static Info visit[] = new Info[10000];
	public static Queue<Info> q = new LinkedList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		StringBuilder sb = new StringBuilder("");
		StringBuilder answer = new StringBuilder("");
		while(T-- > 0) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			Arrays.fill(visit, null);
			q.clear();
			answer.delete(0, answer.length());
			
			visit[from] = new Info(from, from ,' ');
			q.offer(visit[from]);
			
			while(!q.isEmpty()) {
				Info info = q.poll();
				if(info.num == to) {
					break;
				}
				
				int newNum = (info.num<<1)%10000;
				if(visit[newNum] == null) {
					visit[newNum] = new Info(newNum, info.num, 'D');
					q.offer(visit[newNum]);
				}
				
				newNum = info.num - 1;
				if(newNum == -1) newNum = 9999;
				if(visit[newNum] == null) {
					visit[newNum] = new Info(newNum, info.num, 'S');
					q.offer(visit[newNum]);
				}
				
				sb.delete(0, 4);
				sb.append(Integer.toString(info.num));
				for(int i=sb.length(); i<4; i++) sb.insert(0, '0');
				sb.append(sb.charAt(0));
				sb.delete(0, 1);
				newNum = Integer.parseInt(sb.toString());
				if(visit[newNum] == null) {
					visit[newNum] = new Info(newNum, info.num, 'L');
					q.offer(visit[newNum]);
				}
				
				sb.delete(0, 4);
				sb.append(Integer.toString(info.num));
				for(int i=sb.length(); i<4; i++) sb.insert(0, '0');
				char temp = sb.charAt(3);
				sb.delete(3, 4);
				sb.insert(0, temp);
				newNum = Integer.parseInt(sb.toString());
				if(visit[newNum] == null) {
					visit[newNum] = new Info(newNum, info.num, 'R');
					q.offer(visit[newNum]);
				}
			}
			
			int idx = to;
			while(true) {
				if(visit[idx].num == from) break;
				answer.insert(0, visit[idx].method);
				idx = visit[idx].prevNum;
			}
			
			System.out.println(answer.toString());
		}
	}

}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class p9019 {
	public static class Reg{
		public int d[];
		public int cur[];
		public char c;
		public Reg(int n, int now, char c) {
			d = new int[4];
			d[0] = n/1000;
			d[1] = (n/100)%10;
			d[2] = (n/10)%10;
			d[3] = n%10;
			
			cur = new int[4];
			cur[0] = now/1000;
			cur[1] = (now/100)%10;
			cur[2] = (now/10)%10;
			cur[3] = now%10;
			
			this.c = c;
		}
		
		public int getVal() {
			int n = 0;
			n += d[0] * 1000;
			n += d[1] * 100;
			n += d[2] * 10;
			n += d[3];
			return n;
		}
		
		public int getNow() {
			int n = 0;
			n += cur[0] * 1000;
			n += cur[1] * 100;
			n += cur[2] * 10;
			n += cur[3];
			return n;
		}
		
		public int getD() {
			int n = (getNow()<<1)%10000;
			return n;
		}
		
		public int getS() {
			int n = getNow();
			return (n == 0 ? 9999 : n-1);
		}
		
		public int getL() {
			int n = 0;
			n += cur[1] * 1000;
			n += cur[2] * 100;
			n += cur[3] * 10;
			n += cur[0];
			return n;
		}
		
		public int getR() {
			int n = 0;
			n += cur[3] * 1000;
			n += cur[0] * 100;
			n += cur[1] * 10;
			n += cur[2];
			return n;
		}
	}
	
	public static Reg[] visit = new Reg[10000];
	public static Queue<Reg> q = new LinkedList<>();
	
	public static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		StringBuilder sb = new StringBuilder();
		while(N-- > 0) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			q.clear();
			Arrays.fill(visit, null);
			visit[from] = new Reg(from, from, ' ');
			q.offer(visit[from]);
			sb.delete(0, sb.length());
			
			while(!q.isEmpty()) {
				Reg reg = q.poll();
				
				int newNum = reg.getD();
				if(visit[newNum] == null) {
					visit[newNum] = new Reg(reg.getNow(), newNum, 'D');
					q.offer(visit[newNum]);
				}
				
				newNum = reg.getS();
				if(visit[newNum] == null) {
					visit[newNum] = new Reg(reg.getNow(), newNum, 'S');
					q.offer(visit[newNum]);
				}
				
				newNum = reg.getL();
				if(visit[newNum] == null) {
					visit[newNum] = new Reg(reg.getNow(), newNum, 'L');
					q.offer(visit[newNum]);
				}
				
				newNum = reg.getR();
				if(visit[newNum] == null) {
					visit[newNum] = new Reg(reg.getNow(), newNum, 'R');
					q.offer(visit[newNum]);
				}
				
				if(visit[to] != null) break;
			}
			
			while(true) {
				if(to == from) break;
				sb.insert(0, visit[to].c);
				to = visit[to].getVal();
			}
			
			System.out.println(sb.toString());
			
		}
	}
}

/*

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
*/
import java.util.Scanner;
import java.util.StringTokenizer;

public class p2064 {
	public static int N;
	public static int ip[] = {-1, -1, -1, -1};
	public static int mask[] = {255, 255, 255, 255};
	public static int i_diff = 256;
	public static int j_diff = 0;
	public static long maxVal;
	public static long minVal = Long.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(sc.next(),".");
			for(int i=0; i<4; i++) {
				int now = Integer.parseInt(st.nextToken());
				if(ip[i] == -1) {
					ip[i] = now;
				}else if(ip[i] != now){
					if(i_diff >= i) {
						if(i_diff > i) j_diff = 0;
						i_diff = i;
						for(int j=7; j>=j_diff; j--) {
							if((ip[i] & (1<<j)) != (now & (1<<j))) {
								j_diff = j;
								break;
							}
						}
					}
					ip[i] &= now;
				}
				
			}
		}
		
		
		if(i_diff != 256) {
			boolean isDiff = false;
			for(int i=0; i<4; i++) {
				for(int j=7; j>=0; j--) {
					if(isDiff) {
						ip[i] &= ~(1<<j);
						mask[i] &= ~(1<<j);
					}else if(i == i_diff && j == j_diff) {
						isDiff = true;
						ip[i] &= ~(1<<j);
						mask[i] &= ~(1<<j);
					}
				}
			}
		}
		
		
		System.out.println(ip[0]+"."+ip[1]+"."+ip[2]+"."+ip[3]);
		System.out.println(mask[0]+"."+mask[1]+"."+mask[2]+"."+mask[3]);
		
		
		
		/*
		while(N-- > 0) {
			StringTokenizer st = new StringTokenizer(sc.next(),".");
			long num = 0;
			int idx = 31;
			for(int i=3; i>=0; i--) {
				int nowNum = Integer.parseInt(st.nextToken());
				for(int j=7; j>=0; j--) {
					if((nowNum & (1<<j)) != 0) {
						num += Math.pow(2, idx);
					}
					idx--;
				}
			}
			if(maxVal < num) maxVal = num;
			if(minVal > num) minVal = num;
		}
		
		long diff = maxVal - minVal;
		int upper = 0;
		long mulNum = 1;
		while(true) {
			if(diff <= mulNum) {
				break;
			}
			mulNum *= 2;
			upper++;
		}
		for(int i=upper; i<32; i++) {
			mulNum |= (1<<i);
		}
		long answer = maxVal & mulNum;
		
		long mask = 4294967295L & mulNum;
		
		for(int i=3; i>=0; i--) {
			int n = 0;
			for(int j=8*(i+1)-1, k=7; j>=8*i; j--, k--) {
				if((answer & (1<<j)) != 0) {
					n |= (1<<k);
				}
			}
			System.out.print(n+(i != 0 ? "." : ""));
		}
		System.out.println();
		
		for(int i=3; i>=0; i--) {
			int n = 0;
			for(int j=8*(i+1)-1, k=7; j>=8*i; j--, k--) {
				if((mask & (1<<j)) != 0) {
					n |= (1<<k);
				}
			}
			System.out.print(n+(i != 0 ? "." : ""));
		}
		System.out.println();
		*/
	}

}
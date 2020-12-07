import java.util.Scanner;

public class p1016 {
	public static int ans;
	public static boolean arr[];
	public static long min, max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		min = sc.nextLong();
		max = sc.nextLong();
		
		int diff = (int)(max - min) + 1;
		arr = new boolean[diff];
		
		long divSqrtNum = 2;
		while(true) {
			if(divSqrtNum > Math.sqrt(max)) break;
			
			long chk = ((divSqrtNum * divSqrtNum) - (min % (divSqrtNum * divSqrtNum))) % (divSqrtNum * divSqrtNum);
			while(true)
			{
				if(chk >= diff) break;
				arr[(int)chk] = true;
				
				chk += (divSqrtNum * divSqrtNum);
			}
			
			// 1이면 3
			// 5면 3
			// 4면 0
			// 3이면 1
			divSqrtNum++;
		}
		
		for(int i=0; i<diff; i++) {
			if(!arr[i]) ans++;
		}
		
		System.out.println(ans);
	}

}

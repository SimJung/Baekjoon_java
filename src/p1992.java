import java.util.Scanner;
public class p1992 {
	static char[][] arr;
	static int n;
	static StringBuilder ans = new StringBuilder("");
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		String s;
		arr = new char[n][n];
		for(int i=0; i<n; i++) {
			s = sc.next();
			arr[i] = s.toCharArray();
		}
		makeQuad(0, 0, n);
		System.out.println(ans.toString());
	}
	
	static void makeQuad(int startI, int startJ, int len) {
		
		if(len == 1) {
			ans.append(arr[startI][startJ]);
		}else {
			boolean chk = true;
			char temp = arr[startI][startJ];
			for(int i=startI; i<len+startI; i++) {
				for(int j=startJ; j<len+startJ; j++) {
					if(arr[i][j] != temp) {
						chk = false;
						break;
					}
				}
				if(!chk) break;
			}
			
			if(chk) {
				ans.append(arr[startI][startJ]);
			}else {
				ans.append("(");
				makeQuad(startI, startJ, len/2);
				makeQuad(startI, startJ + len/2, len/2);
				makeQuad(startI+len/2, startJ, len/2);
				makeQuad(startI+len/2, startJ+len/2, len/2);
				ans.append(")");
			}
		}
		
	}

}

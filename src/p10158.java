import java.util.Scanner;

/*
 * IM 대비 문제 20문항 중, 10158 개미 문제를 선정하였음.
 * 처음엔 흔한 BFS 문제인 줄 알았으나, 다른 문제와 달리 시간 제한이 빡빡해, 케이스를 작게 하는 과정이 필요했음.
 * 나머지 연산을 이용해 X, Y좌표에 대해 따로따로 처리하였음.
 * 
 */
public class p10158 {
	static int W, H, p, q, t, moveI = 1, moveJ = 1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		W = sc.nextInt();
		H = sc.nextInt();
		p = sc.nextInt();
		q = sc.nextInt();
		t = sc.nextInt();
		
		int ni = q;
		int nj = p;
		int tempT = t % (2*H);	// 최대 2*세로 높이 만큼만 반복하면 모든 y 좌표를 방문할 수 있다.
		while(tempT-- > 0) {	
			ni += moveI;
			if(ni < 0 || ni > H) {
				ni -= moveI;
				moveI *= -1;
				ni += moveI;
			}
		}
		// 최종적으로 개미가 위치할 y좌표의 값이 구해짐.
		
		tempT = t % (2*W);		// 최대 2*가로 길이 만큼만 반복하면 모든 x 좌표를 방문할 수 있다.
		while(tempT-- > 0) {
			nj += moveJ;
			if(nj < 0 || nj > W) {
				nj -= moveJ;
				moveJ *= -1;
				nj += moveJ;
			}
		}
		// 최종적으로 개미가 위치할 x좌표의 값이 구해짐.
		
		System.out.println(nj + " " + ni);
	}

}

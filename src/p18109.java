import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p18109 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder(br.readLine());
		
		int ans = 0;
		for(int i=1; i<sb.length()-1; i++) {
			if(isM(sb.charAt(i-1))) {
				if(isE(sb.charAt(i)) && isF(sb.charAt(i)) && isM(sb.charAt(i+1))) {
					ans++;
				}
			}else if(isfE(sb.charAt(i-1))) {
				if(issE(sb.charAt(i-1), sb.charAt(i)) && isF(sb.charAt(i)) && isM(sb.charAt(i+1))) {
					if(i >= 2 && !isfE(sb.charAt(i-2))) 
						ans++;
				}
			}
		}
		System.out.println(ans);
	}
	
	public static boolean isF(char c) {
		switch(c) {
		case 'r':
		case 'R':
		case 's':
		case 'e':
		case 'E':
		case 'f':
		case 'a':
		case 'q':
		case 'Q':
		case 't':
		case 'T':
		case 'd':
		case 'w':
		case 'W':
		case 'c':
		case 'z':
		case 'x':
		case 'v':
		case 'g':
			return true;
		default : return false;
		}
	}
	
	public static boolean isM(char c) {
		switch(c) {
		case 'y':
		case 'u':
		case 'i':
		case 'o':
		case 'O':
		case 'p':
		case 'P':
		case 'h':
		case 'j':
		case 'k':
		case 'l':
		case 'b':
		case 'n':
		case 'm':
			return true;
		default : return false;
		}
	}
	
	public static boolean isE(char c) {
		switch(c) {
		case 'r':
		case 'R':
		case 's':
		case 'e':
		case 'f':
		case 'a':
		case 'q':
		case 't':
		case 'T':
		case 'd':
		case 'w':
		case 'c':
		case 'z':
		case 'x':
		case 'v':
		case 'g':
			return true;
		default : return false;
		}
	}
	
	public static boolean isfE(char c) {
		switch(c) {
		case 'r':
		case 's':
		case 'f':
		case 'q':
			return true;
		default : return false;
		}
	}
	
	public static boolean issE(char c1, char c2) {
		switch(c1) {
		case 'r':
			switch(c2) {
			case 't': return true;
			default : return false;
			}
			
		case 's':
			switch(c2) {
			case 'w': 
			case 'g':
				return true;
			default : return false;
			}
			
		case 'f':
			switch(c2) {
			case 'r': 
			case 'a': 
			case 'q': 
			case 't': 
			case 'x': 
			case 'v': 
			case 'g': 
				return true;
			default : return false;
			}
		case 'q':
			if(c2 == 't') return true;
			else return false;
		default : return false;
		}
	}

}

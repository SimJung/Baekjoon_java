import java.util.Scanner;

public class p2941 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder(sc.next());
		
		int len = 0;
		for(int i=0; i<sb.length(); i++) {
			if(sb.charAt(i) == 'c') {
				if(i+1 < sb.length() && (sb.charAt(i+1) == '=' || sb.charAt(i+1) == '-')) {
					len++;
					i++;
				}else {
					len++;
				}
			}else if(sb.charAt(i) == 'd') {
				if(i+1 < sb.length() && sb.charAt(i+1) == '-') {
					len++;
					i++;
				}else if(i+2 < sb.length() && sb.charAt(i+1) == 'z' && sb.charAt(i+2) == '='){
					len++;
					i+=2;
				}else {
					len++;
				}
			}else if(sb.charAt(i) == 'l') {
				if(i+1 < sb.length() && sb.charAt(i+1) == 'j') {
					len++;
					i++;
				}else {
					len++;
				}
			}else if(sb.charAt(i) == 'n') {
				if(i+1 < sb.length() && sb.charAt(i+1) == 'j') {
					len++;
					i++;
				}else {
					len++;
				}
			}else if(sb.charAt(i) == 's') {
				if(i+1 < sb.length() && sb.charAt(i+1) == '=') {
					len++;
					i++;
				}else {
					len++;
				}
			}else if(sb.charAt(i) == 'z') {
				if(i+1 < sb.length() && sb.charAt(i+1) == '=') {
					len++;
					i++;
				}else {
					len++;
				}
			}else {
				len++;
			}
		}
		System.out.println(len);
	}

}

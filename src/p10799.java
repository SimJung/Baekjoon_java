import java.util.Scanner;
import java.util.Stack;

public class p10799 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = 0;
        int answer = 0;
        String str = sc.next();
        Stack<Character> stack = new Stack<>();

        for (int i=0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                num++;
                stack.push('(');
            }else{
                num--;
                if(!stack.isEmpty())
                    stack.pop();

                // 레이저일경우
                if(i != 0 && str.charAt(i-1) == '('){
                    answer += num;
                }

                // 철 끝나는 경우
                else{
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
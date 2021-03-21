import java.io.*;
import java.util.ArrayList;

public class p1786 {
    static int[] pFail;
    static ArrayList<Integer> answerIndex = new ArrayList<>();
    static String t;
    static String p;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        t = br.readLine();
        p = br.readLine();

        pFail = new int[p.length()];

        failure();
        kmp();

        bw.write(answerIndex.size()+"\n");
        for (Integer integer : answerIndex) {
            bw.write(integer+1 + " ");
        }

        bw.flush();
        bw.close();
    }


    /**
     * pFail에 패턴 문자열의 접두사, 접미사 일치 여부 계산
     *
     * ABCABA
     *  ABCABA
     * 1 : 0
     *
     * ABCABA
     *   ABCABA
     * 2 : 0
     *
     * ABCABA
     *    ABCABA
     * 3 : 1
     *
     * ABCABA
     *    ABCABA
     * 4 : 2
     *
     * ABCABA
     *      ABCABA
     * 5 : 1
     *
     */
    public static void failure(){
        int begin = 1, m = 0;
        while(begin + m < p.length()) {
            if(p.charAt(begin + m) == p.charAt(m)){
                m++;
                pFail[begin+m-1] = m;
            }else{
                if(m == 0)
                    begin++;
                else{
                    begin += m - pFail[m-1];
                    m = pFail[m-1];
                }
            }
        }

    }


    /**
     * pFail을 이용하여 패턴 매칭
     *
     * ABCABABC
     * ABCAB
     *
     * ABCABABC
     *  ABCAB
     *
     * ABCABABC
     *   ABCAB
     *
     * ABCABABC
     *    ABCAB
     *
     * ABCABABC
     *
     *
     */
    public static void kmp(){
        int begin = 0, m = 0;
        while(begin <= t.length() - p.length()){
            if(m < p.length() && t.charAt(begin + m) == p.charAt(m)){
                m++;
                if(m == p.length()){
                    answerIndex.add(begin);
                }
            }else{
                if(m == 0)
                    begin++;
                else{
                    begin += m - pFail[m-1];
                    m = pFail[m-1];
                }
            }
        }
    }
}

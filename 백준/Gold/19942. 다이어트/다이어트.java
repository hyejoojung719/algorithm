import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] standard;
    static int[][] foods;
    static int[] selected;
    static int[] ansFoods;
    static int answer = Integer.MAX_VALUE;

    static void recur(int cur, int cnt) {
        if (cur == N + 1) {


            int p = 0, f = 0, s = 0, v = 0, c = 0;
            for (int i = 0; i < cnt; i++) {
                p += foods[selected[i]][0];
                f += foods[selected[i]][1];
                s += foods[selected[i]][2];
                v += foods[selected[i]][3];
                c += foods[selected[i]][4];
            }

            if (p < standard[0] || f < standard[1] || s < standard[2] || v < standard[3]) {
                return;
            }

            if (answer >= c) {

                boolean check = true;
                if (answer == c) {
                    for (int i = 0; i < cnt; i++) {
                        if(selected[i] > ansFoods[i]){
                            check = false;
                            break;
                        }
                    }
                }

                if (check) {
                    for (int i = 0; i < N; i++) {
                        if (i < cnt) {
                            ansFoods[i] = selected[i];
                        } else {
                            ansFoods[i] = 0;
                        }
                    }
                }

                answer = c;
            }


            return;
        }

        selected[cnt] = cur;
        recur(cur + 1, cnt + 1);

        selected[cnt] = 0;
        recur(cur + 1, cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        standard = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            standard[i] = Integer.parseInt(st.nextToken());
        }

        foods = new int[N + 1][5];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                foods[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected = new int[N];
        ansFoods = new int[N];

        recur(1, 0);

        if (answer == Integer.MAX_VALUE) {
            bw.write("-1");
        } else {
            bw.write(answer + "\n");

            Arrays.sort(ansFoods);

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                if(ansFoods[i] > 0) sb.append(ansFoods[i] + " ");
            }

            bw.write(String.valueOf(sb));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
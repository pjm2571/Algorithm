import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            long x = Long.parseLong(line);
            long width = x * 10000000;

            int n = Integer.parseInt(br.readLine());
            long[] blocks = new long[n];

            for (int i = 0; i < n; i++) {
                blocks[i] = Long.parseLong(br.readLine());
            }

            Arrays.sort(blocks);

            int lt = 0;
            int rt = blocks.length - 1;
            boolean found = false;

            while (lt < rt) {
                long sum = blocks[lt] + blocks[rt];
                if (sum == width) {
                    System.out.println("yes " + blocks[lt] + " " + blocks[rt]);
                    found = true;
                    break;
                } else if (sum < width) {
                    lt++;
                } else {
                    rt--;
                }
            }

            if (!found) {
                System.out.println("danger");
            }
        }

        br.close();
    }
}
package operators;

import java.util.Random;

public class MathOps {

    public static void main(String[] args) {
        Random random = new Random(47);
        int i, j, k;

        // choose value from 1 to 100
        j = random.nextInt(100) + 1;
        System.out.println("j: " + j);

        k = random.nextInt(100) + 1;
        System.out.println("k: " + k);

        i = j + k;
        System.out.println("j + k: " + i);

        i = j - k;
        System.out.println("j - k: " + i);

        i = k / j;
        System.out.println("k / j: " + i);

        i = k * j;
        System.out.println("k * j: " + i);

        i = k % j;
        System.out.println("k % j: " + i);

        j %= k;
        System.out.println("j %= k: " + j);

        System.out.println("------------");

        // floating point number test
        float u, v, w;

        v = random.nextFloat();
        System.out.println("v: " + v);

        w = random.nextFloat();
        System.out.println("w: " + w);

        u = v + w;
        System.out.println("v + w: " + u);

        u = v - w;
        System.out.println("v - w: " + u);

        u = v * w;
        System.out.println("v * w: " + u);

        u = v / w;
        System.out.println("v / w: " + u);

        u += v;
        System.out.println("u += v: " + u);

        u -= v;
        System.out.println("u -= v: " + u);

        u *= v;
        System.out.println("u *= v: " + u);

        u /= v;
        System.out.println("u /= v: " + u);
    }
}

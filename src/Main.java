import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        System.out.println(-1 >>> 1);
        int i = tableSizeFor(3);
        System.out.println(i);
        System.out.println(-1 >>> 1);

    }

    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1 << 30) ? (1 << 30) : n + 1;
    }

}

/**
 * @author Blue
 * @date 2021/6/1
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(loop0());
    }

    public static int  loop0() {
        int i = 1;
        while (true) {
            loop1(i++);
            if (i >= 5) {
                return 1234566;
            } else {
                loop0();
            }
        }
    }

    public static int loop1(int i) {
        if (i == 3) {
            return 1234;
        }
        loop2();
        return 2 * i;
    }

    public static void loop2() {
        for (int i = 0; i < 2; i++) {
            System.err.println("loop2:" + i);
        }
    }
}

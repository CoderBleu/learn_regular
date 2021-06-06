/**
 * @author Blue
 * @date 2021/6/5
 **/
public class 验证是否为整数或小数 {
    public static void main(String[] args) {
        // 比如：123 -1212 34.35 -34.52 -0.01 0.03等
        String content = "-0.89";
        /**
         * [+-]? 表示可以是 +正数 或者 -负数，甚至没有符号的正数
         * [0|[1-9]\\d*] 表示 0 或者 以1到9开头后面可以是 0个或者多个数字
         * (\\.\\d+) 表示 开头接 .符号，再可以一个或者多个数字
         * ? 表示可以0个或者1个
         * $ 以什么结尾，此处是以数字结尾
         */
        String reg = "[+-]?[0|[1-9]\\d*](\\.\\d+)?$";

        if (content.matches(reg)) {
            System.out.println("匹配成功");
        } else {
            System.out.println("匹配失败");
        }
    }
}

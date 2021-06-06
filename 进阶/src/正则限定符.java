import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/6/1
 **/
public class 正则限定符 {
    public static void main(String[] args) {
        String content = "111112141aaaaa1ahello";

        String reg1 = "a{3}"; // 表示匹配 aaa
        String reg2 = "1{4}"; // 表示匹配 1111
        String reg3 = "\\d{2}"; // 表示匹配 两位的任意数字字符

        // 细节：java匹配默认贪婪匹配，尽可能的匹配多的
        String reg4 = "a{3,4}"; //表示匹配aaa 或者 aaaa，优先aaaa多的
        String reg5 = "1{4,5}"; // 表示匹配 1111 或者 11111
        String reg6 = "\\d{2,5}"; // 匹配2位数或者3，4，5，如下会找到找到：11111 和 11

        // + 号使用
        String reg7 = "1+"; // 匹配一个1或者多个1
        String reg8 = "\\d+"; // 匹配一个或多个数字
        String reg11 = "\\d*"; // 匹配0个或多个数字

        // * 号使用
        String reg9 = "1*"; // 匹配0个1或者多个1

        // ? 号使用，遵守贪婪匹配
        String reg10 = "a1?"; // 匹配 a 或者 a1


        Pattern pattern = Pattern.compile(reg11, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }

    }
}

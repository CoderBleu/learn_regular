import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/6/1
 **/
public class 字符匹配案例 {
    public static void main(String[] args) {
        String content = "a11c8abcAB\nCy_ABC abc@!  .";

        String reg = "[a-z]"; // 匹配 a-z之间任意一个字符
        String reg1 = "[A-Z]"; // 匹配 A-Z之间任意一个字符
        String reg2 = "abc"; // 匹配 abc字符串(默认区分大小写)
        String reg3 = "(?!)abc"; // TODO 有问题 匹配 abc 字符串(不区分大小写)，a(?!)bc表示bc不区分大小写
        String reg4 = "[0-9]"; // 匹配 0-9之间任意一个字符
        String reg5 = "[^a-z]"; // 匹配 不在 a-z之间任意一个字符
        String reg6 = "[^0-9]"; // 匹配 不在 0-9之间任意一个字符
        String reg7 = "[abcd]"; // 匹配 在 abcd中任意一个字符
        String reg8 = "\\D"; // 匹配 不在 0-9的任意一个字符
        String reg9 = "\\w"; // 匹配 大小写英文字母，数字，下划线
        String reg10 = "\\W"; // 等价于 [^a-zA-Z0-9_]，比如空格，感叹号!，艾特@
        String reg11 = "\\s"; // 匹配任何空白字符(空格，制表符等)
        String reg12 = "\\."; // "."匹配出 \n之外的所有字符，如果要匹配，本身则需要使用 \\.

        Pattern compile = Pattern.compile(reg12);
        // 启用不区分大小写的匹配。
        // Pattern compile = Pattern.compile(reg2, Pattern.CASE_INSENSITIVE);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }

    }
}

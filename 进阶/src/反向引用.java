import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/6/5
 **/
public class 反向引用 {
    public static void main(String[] args) {
        // String content = "h1234e155111111abad12321-33344455512211";
        String content = "1221 1111 1111 123213";

        // 匹配两个连续的相同数字：(\\d)\\1
        String reg1 = "(\\d)\\1";
        // 匹配五个连续的相同的数字 11111
        String reg2 = "(\\d)\\1{4}";
        // 匹配个位与千位相同，十位与百位相同的数,匹配1111
        String reg3 = "(\\d)(\\d)\\2\\1";
        // 匹配前面是一个五位数，然后一个 -号，然后是一个九位数，连续的每三位要相同，匹配12321-333444555
        String reg4 = "\\d{5}-(\\d)\\1{2}(\\d)\\2{2}(\\d)\\3{2}";
        // 匹配123213，(\\d)(\\d)(\\d)\\2\\1中 \\2表示反向引用123三个数字中的第二位2，同理\\1,\\3也是如此
        String reg5 = "(\\d)(\\d)(\\d)\\2\\1\\3";

        Pattern compile = Pattern.compile(reg5);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配格式:" + matcher.group(0));
        }
    }
}

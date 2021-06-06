import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/6/5
 **/
public class 非贪婪匹配 {
    public static void main(String[] args) {
        String content = "hello 1oo123111";

        // String reg = "\\d+"; //默认是贪婪匹配，找到：1，找到：123111
        String reg = "\\d+?"; //非贪婪匹配，找到：1，找到：1，找到：2...

        Pattern pattern = Pattern.compile(reg);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }
    }
}

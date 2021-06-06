import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/6/1
 **/
public class 捕获分组 {
    public static void main(String[] args) {
        String content = "1324324332423";

        /* 捕获分组*/
        String reg1 = "(\\d\\d)(\\d\\d)"; // 匹配4个数字的字符串
        // 命名分组：即可以给分组取名
        String reg2 = "(?<g1>\\d\\d)(?<g2>\\d\\d)";

        Pattern pattern = Pattern.compile(reg2);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            /*找到：1324
            找到第一个分组的第一个内容：13
            找到第一个分组的第一个内容：24*/
            System.out.println("找到捕获分组：" + matcher.group(0));
            System.out.println("找到捕获分组的第一个内容：" + matcher.group(1));
            System.out.println("找到捕获分组的第二个内容：" + matcher.group(2));

            /*命名分组方式*/
            // System.out.println("找到捕获分组：" + matcher.group(0));
            // System.out.println("找到第捕获分组的第一个内容：" + matcher.group("g1"));
            // System.out.println("找到第捕获分组的第二个内容：" + matcher.group("g2"));

        }

    }
}

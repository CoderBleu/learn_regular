import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/6/1
 **/
public class 正则定位符 {
    public static void main(String[] args) {
        String content = "21lauyhelloworld hilauy lauyu Hilauy123";

        // 以至少1个数字开头，后接0或者任意个小写字符串
        String reg1 = "^[0-9]+[a-z]*";
        // 以至少1个数字开头，必须以至少一个小写字母结束,比如仅仅跟 2-lauyhelloworld 匹配，就符合要求
        String reg2 = "^[0-9]+\\-[a-z]+$";

        // 匹配一个单词边界，即字与空格间的位置。如果它位于要匹配的字符串的开始，它在单词的开始处查找匹配项。如果它位于字符串的结尾，它在单词的结尾处查找匹配项。
        // 上述例子，我们可以找字符串结尾处的，比如 21lauyh...，lauyu，lauy123
        String reg3 = "lauy\\b";

        // 和\\b含义相反，详细：面表达式匹配 minelauyo 中的字符串 apt，但不匹配 lauyo 中的字符串 apt：
        String reg4 = "lauy\\B";

        Pattern pattern = Pattern.compile(reg4);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }

    }
}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/5/30
 **/
public class 向上箭头符号的用法 {
    public static void main(String[] args) {
        String content = "abc$(a.bc(123(";

        // ^ : 表示不在
        //
        // 匹配不在a到z的
        Pattern compile = Pattern.compile("[^a-z]");
        // 把连续符合匹配的一起输出，比如 $( ，(123(
        // Pattern compile = Pattern.compile("[^a-z]+");
        // 匹配不在 0-9 之间的一个字符
        // Pattern compile = Pattern.compile("[^0-9]");
        // 2.创建一个匹配器对象
        Matcher matcher = compile.matcher(content);
        // 3. 可以循环匹配
        while (matcher.find()) {
            // 匹配内容，文本，放到 m.group(0)
            System.out.println("找到：" + matcher.group(0));
        }
    }
}

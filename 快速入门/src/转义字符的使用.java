import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/5/30
 **/
public class 转义字符的使用 {
    public static void main(String[] args) {
        String content = "abc$(a.bc(123(";

        // 俩个 \\ 字符表示 \
        Pattern compile = Pattern.compile("\\(");
        // 2.创建一个匹配器对象
        Matcher matcher = compile.matcher(content);
        // 3. 可以循环匹配
        while (matcher.find()) {
            // 匹配内容，文本，放到 m.group(0)
            System.out.println("找到：" + matcher.group(0));
        }
    }
}

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/6/5
 **/
public class 去重 {
    public static void main(String[] args) {
        String content = "我我我要学学学编程java!!!";

        String reg = "(.)\\1+";
        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(content);
        while (matcher.find()) {
            System.out.println("匹配格式:" + matcher.group(0));
        }

        // 使用 反向引用$1 来替换匹配的内容
        String result = Pattern.compile(reg).matcher(content).replaceAll("$1");
        System.out.println("去重后：" + result);
    }
}

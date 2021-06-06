import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/6/1
 **/
public class 选择匹配符 {
    public static void main(String[] args) {
        String content = "lauy 木艺术";
        String regStr = "lauy|木|艺";

        Pattern pattern = Pattern.compile(regStr, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(content);

        while (matcher.find()) {
            System.out.println("找到：" + matcher.group(0));
        }

    }
}

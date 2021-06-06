import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/6/1
 **/
public class 非捕获分组 {
    public static void main(String[] args) {

        /* 非捕获分组，注意不能 matcher.group(1) */
        String content1 = "梦想天空分外蓝啊、分外蓝呀、分外蓝";

        // 等同于 "分外蓝|分外蓝啊|分外蓝呀"
        // 输出：找到非捕获分组：分外蓝啊 找到非捕获分组：分外蓝呀
        String reg3 = "分外蓝(?:啊|呀)";

        // 找到分外蓝关键字，但是要求只是查询 分外蓝啊 和 分外蓝呀 中的分外蓝
        // 输出：找到非捕获分组：分外蓝
        String reg4= "分外蓝(?=啊|呀)";

        // 找到分外蓝关键字，但是要求只是查询匹配 不是 分外蓝啊 和 分外蓝呀 中包含有的分外蓝
        // 输出：找到非捕获分组：分外蓝啊 找到非捕获分组：分外蓝呀
        String reg5= "分外蓝(?:啊|呀)";

        Pattern pattern = Pattern.compile(reg5);
        Matcher matcher = pattern.matcher(content1);

        while (matcher.find()) {
           System.out.println("找到非捕获分组：" + matcher.group(0));
        }

    }
}

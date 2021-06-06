import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/6/5
 * https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9599029349875218161%22%7D&n_type=0&p_from=1
 **/
public class 正则匹配URL {
    public static void main(String[] args) {
        String content = "https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9599029349875218161%22%7D&n_type=0&p_from=1";

        /**
         * 注: \\w：匹配 大小写英文字母，数字，下划线_
         * 1. 匹配 https:// 或者 http:// ：^((http|https)://) 其中^ 表示至少有一个 http 或者 https开头，
         *    (http|https)分组表示http 或者 https
         * 2. 可以匹配不带协议的 url，比如：mbd.baidu.com/newspage/data/landingsuper，
         *    用 正则限定符 ?,指定匹配出现0次或者1次，^((http|https)://)?
         * 3. 匹配 mbd.baidu.com，使用：([\\w-]+\\.)+[\\w]+ ，其中 [\\w-]+ 表示匹配 www-top.com 这种，
         *    中间允许 \\w格式 或者 -，+表示匹配指定字符出现1次多种多次
         * 4. 匹配后面所有 /newspage , [*]在中括号里表示匹配 * 符号
         *    表示 (\\/[\\w-=%.&?]*) 匹配 / 开头，后面接 \\w 和 - 或者 = 或者 % 或者 . 或者 & 或者 ? 格式
         * 5. 第四步(\\/[\\w-=%.&?]*)后面接*表示匹配重复出现0次或者多次，
         * 6. 然后$ ，表示以 /asfssba 这种格式结尾
         */
        // String reg = "^((http|https)://)?([\\w-]+\\.)+[\\w]+(\\/[\\w-=%.&?]*)?$";
        String reg = "^((http|https)://)?([\\w-]+\\.)+[\\w]+(\\/[\\w-=%.&?]*)*$";

        Pattern compile = Pattern.compile(reg);
        Matcher matcher = compile.matcher(content);
        if (matcher.find()) {
            System.out.println("匹配格式" + matcher.group(0));
        } else {
            System.out.println("不匹配格式");
        }
    }
}

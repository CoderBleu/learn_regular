import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/5/30
 **/
public class 原理剖析 {
    public static void main(String[] args) {
        String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了Apple公司Mac OS X的工业标准的支持。2001年9月24日，J2EE1.3发布。" +
                "2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，与J2SE1.3相比，其多了近62%的类和接口。在这些新特性当中，还提供了广泛的XML支持、安全套接字（Socket）支持（通过SSL与TLS协议）、全新的I/OAPI、正则表达式、日志与断言。" +
                "2004年9月30日，J2SE1.5发布，成为Java语言发展史上的又一里程碑。为了表示该版本的重要性，J2SE 1.5更名为Java SE 5.0（内部版本号1.5.0），" +
                "代号为“Tiger”，Tiger包含了从1996年发布1.0版本以来的最重大的更新，其中包括泛型支持、基本类型的自动装箱、改进的循环、枚举类型、" +
                "格式化I/O及可变参数。";

        Pattern compile = Pattern.compile("\\d\\d\\d\\d");
        Matcher matcher = compile.matcher(content);
        // 查找过程：
        // 1. 根据指定的规则，定位满足规则的字符串，比如2000
        // 2. 找到后将 子字符串的开始索引 group[0]=0 记录到 matcher 对象的熟悉 int[] groups数组中；
        // 3. 同时巨鹿oldLast 的值为 子字符串的结束的 索引+1的位置值索引 group[1]=4，下次执行find是，就从记录的索引开始匹配
        // 4. 如果matcher.group(i)，i超过了范围，就会报索引越界异常，因为 getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
        // 5. 继续向下找的时候同理, 找到后将 子字符串的开始索引记录 group[0]=65 到 matcher 对象的熟悉 int[] groups数组中；同时巨鹿oldLast 的值为 子字符串的结束的 索引+1的位置值索引为group[1]=69，下次执行find是，就从记录的索引开始匹配
        while (matcher.find()) {
            // 开始匹配group - 源码：
            // public String group(int group) {
            //         if (first < 0)
            //             throw new IllegalStateException("No match found");
            //         if (group < 0 || group > groupCount())
            //             throw new IndexOutOfBoundsException("No group " + group);
            //         if ((groups[group*2] == -1) || (groups[group*2+1] == -1))
            //             return null;
            //         return getSubSequence(groups[group * 2], groups[group * 2 + 1]).toString();
            //     }
            System.out.println("找到：" + matcher.group(0));
        }
    }
}

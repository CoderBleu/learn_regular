import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/5/30
 **/
public class 原理剖析_带括号查询 {
    public static void main(String[] args) {
        String content = "2000年5月，JDK1.3、JDK1.4和J2SE1.3相继发布，几周后其获得了Apple公司Mac OS X的工业标准的支持。2001年9月24日，J2EE1.3发布。" +
                "2002年2月26日，J2SE1.4发布。自此Java的计算能力有了大幅提升，与J2SE1.3相比，其多了近62%的类和接口。在这些新特性当中，还提供了广泛的XML支持、安全套接字（Socket）支持（通过SSL与TLS协议）、全新的I/OAPI、正则表达式、日志与断言。" +
                "2004年9月30日，J2SE1.5发布，成为Java语言发展史上的又一里程碑。为了表示该版本的重要性，J2SE 1.5更名为Java SE 5.0（内部版本号1.5.0），" +
                "代号为“Tiger”，Tiger包含了从1996年发布1.0版本以来的最重大的更新，其中包括泛型支持、基本类型的自动装箱、改进的循环、枚举类型、" +
                "格式化I/O及可变参数。";

        Pattern compile = Pattern.compile("(\\d)(\\d\\d\\d)");
        Matcher matcher = compile.matcher(content);
        // 查找过程：
        // 什么是分组，比如 (\d\d)(\d\d) ,则会功能则表达式中有 () 表示分组，第一个 ()表示第1组，第二个()表示第2组...
        // 1. 根据指定的规则，定位欸满足规则的子字符串(比如(20)(00))
        // 2. 找到后将 子字符串的开始索引 group[0]=0 记录到 matcher 对象的熟悉 int[] groups数组中；
        // *  2.1 groups[0] = 0, 把该子字符串的结束的索引+1的值记录到 groups[1] = 4
        // *  2.2 记录1组()匹配到的子字符串 groups[2] = 0 groups[3] = 2
        // *  2.3 记录2组()匹配到的子字符串 groups[4] = 2 groups[5] = 4
        // *  2.4 如果有更多的分组，同理
        // 3. 同时记录 oldLast 的值为 子字符串的结束的 索引+1的值即69，即下次执行find时，就从69开始匹配。
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
            System.out.println("找到：" + matcher.group(0)); // 2000
            System.out.println("找到：" + matcher.group(1)); // 2
            System.out.println("找到：" + matcher.group(2)); // 000
            // System.out.println("找到：" + matcher.group(3)); 索引越界
        }

    }
}

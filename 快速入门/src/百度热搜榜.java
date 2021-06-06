import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Blue
 * @date 2021/5/30
 **/
public class 百度热搜榜 {
    public static void main(String[] args) {
        String content = "<div class=\"avator selected\" data-uid=\"ea1c30cc\" data-uname=\"大良家的张先生\">\n" +
                "<img data-name=\"大良家的张先生\" src=\"https://bkimg.cdn.bcebos.com/pic/e824b899a9014c086e0615d9f73715087bf40ad15e30?x-bce-process=image/resize,m_fill,w_110,h_110,align_50,limit_0/format,f_auto\" />\n" +
                "<div class=\"avator_shd\"></div>\n" +
                "</div>\n" +
                "<div class=\"avator\" data-uid=\"2f941cd9\" data-uname=\"浅听寒雨\">\n" +
                "<img data-name=\"浅听寒雨\" src=\"https://bkimg.cdn.bcebos.com/pic/3801213fb80e7bec54e7b7d7ca62ae389b504fc23dfa?x-bce-process=image/resize,m_fill,w_110,h_110,align_50,limit_0/format,f_auto\" />\n" +
                "<div class=\"avator_shd\"></div>\n" +
                "</div>\n" +
                "<div class=\"avator\" data-uid=\"f2b1g7f2601000000\" data-uname=\"巧若南00u\">\n" +
                "<img data-name=\"巧若南00u\" src=\"https://bkimg.cdn.bcebos.com/pic/38dbb6fd5266d0160924741e7267c30735fae6cd9ffa?x-bce-process=image/resize,m_fill,w_110,h_110,align_50,limit_0/format,f_auto\" />\n" +
                "<div class=\"avator_shd\"></div>\n" +
                "</div>\n" +
                "<div class=\"avator\" data-uid=\"cc9495e7\" data-uname=\"三岁就很萌hhh\">\n" +
                "<img data-name=\"三岁就很萌hhh\" src=\"https://bkimg.cdn.bcebos.com/pic/9345d688d43f8794a4c2af19375719f41bd5ad6e8cfd?x-bce-process=image/resize,m_fill,w_110,h_110,align_50,limit_0/format,f_auto\" />\n" +
                "<div class=\"avator_shd\"></div>\n" +
                "</div>\n" +
                "<div class=\"avator\" data-uid=\"8c32b7e7\" data-uname=\"箬翊玖\">\n" +
                "<img data-name=\"箬翊玖\" src=\"https://bkimg.cdn.bcebos.com/pic/a5c27d1ed21b0ef41bd57b66388846da81cb39db90fc?x-bce-process=image/resize,m_fill,w_110,h_110,align_50,limit_0/format,f_auto\" />\n" +
                "<div class=\"avator_shd\"></div>\n" +
                "</div>\n" ;

        // 匹配 <img data-name="箬翊玖"中内容，比如：箬翊玖
        Pattern compile = Pattern.compile("<img data-name=\"(\\S*)\"");
        // 2.创建一个匹配器对象
        Matcher matcher = compile.matcher(content);
        // 3. 可以循环匹配
        while (matcher.find()) {
            // 匹配内容，文本，放到 m.group(0)
            // System.out.println("找到：" + matcher.group(0)); 为：<img data-name="大良家的张先生"
            System.out.println("找到：" + matcher.group(1));
        }
    }
}

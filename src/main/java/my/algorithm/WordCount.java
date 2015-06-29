package my.algorithm;

/**
 * Created by paul on 2015/6/25.
 * 统计字符串中汉字，英文字母，数字及其他字符数量
 */
public class WordCount {
    public static void main(String[] args) {
        String srt = "hello9中国@*5：";

        String e1 = "[\u4e00-\u9fa5]";
        String e2 = "[a-zA-Z]";
        String e3 = "[0-9]";

        int chineseCount = 0;
        int englishCount = 0;
        int numberCount = 0;
        int others = 0;
        String tmp;
        for (int i = 0; i < srt.length(); i++) {
            tmp = String.valueOf(srt.charAt(i));
            if (tmp.matches(e1))
                chineseCount++;
            else if (tmp.matches(e2))
                englishCount++;
            else if (tmp.matches(e3))
                numberCount++;
            else others++;
        }
        System.out.println("chines:" + chineseCount);
        System.out.println("english:" + englishCount);
        System.out.println("number:" + numberCount);
        System.out.println("others:" + others);
    }
}

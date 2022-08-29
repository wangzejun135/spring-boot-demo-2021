package study2021.str;

/**
 * @Description
 * @Author WangZeJun
 * @Date 2022/08/25 10:54
 */
public class StringBuilderTest {
    public static void main(String[] args) {
        String ruleCondition = "abc";
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ruleCondition);
        stringBuilder.append(" and t1.apartment_id = '");
        stringBuilder.append("001");
        stringBuilder.append("'");
        stringBuilder.append(" and t1.has_photo = '1'");
        ruleCondition = stringBuilder.toString();
        System.out.println(ruleCondition);
        System.out.println("abc and t1.apartment_id = '001' and t1.has_photo = '1'");
    }
}

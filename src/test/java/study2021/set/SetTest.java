package study2021.set;

import java.util.HashSet;
import java.util.Set;

/**
 * @Description Set集合取交集
 * @Author WangZeJun
 * @Date 2021/11/17 17:02
 **/
public class SetTest {

    public static void main(String[] args) {
        Set<String> set1 = new HashSet<String>() {{
            add("1");
            add("3");
            add("4");
        }};

        Set<String> set2 = new HashSet<String>() {{
            add("5");
            add("2");
            add("0");
        }};

        set1.retainAll(set2);
        System.out.println(set1);
        System.out.println("********************************");
        setCompare();

    }

    //两个Set比较找出交集、差集、并集
    public static void setCompare() {
        Set<String> result = new HashSet<String>();
        Set<String> set1 = new HashSet<String>() {{
            add("1");
            add("3");
            add("4");
        }};
        System.out.println("set1 = " + set1.toString());

        Set<String> set2 = new HashSet<String>() {{
            add("1");
            add("2");
            add("3");
        }};
        System.out.println("set2 = " + set2.toString());
        result.clear();
        result.addAll(set1);
        result.retainAll(set2);
        System.out.println("交集：" + result);

        result.clear();
        result.addAll(set1);
        result.removeAll(set2);
        System.out.println("差集：" + result);

        result.clear();
        result.addAll(set1);
        result.addAll(set2);
        System.out.println("并集：" + result);
    }
}

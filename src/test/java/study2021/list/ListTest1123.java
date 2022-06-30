package study2021.list;

import study2021.bean.TestPO;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @Description 两个list取交集
 * @Author WangZeJun
 * @Date 2021/05/27 10:27
 **/
public class ListTest1123 {


    /**
     * The number of seconds in the duration.
     */
    private static final long seconds = 5;
    /**
     * The number of nanoseconds in the duration, expressed as a fraction of the
     * number of seconds. This is always positive, and never exceeds 999,999,999.
     */
    private static final int nanos = 0;


    public static void main2(String[] args) throws InterruptedException {
        List<TestPO> poList = new LinkedList<>();
        TestPO po = new TestPO();
        po.setCertificateId("11");
        po.setFaceTime("2021-06-18 03:12:22");
        po.setName("张三");
        TestPO po2 = new TestPO();
        po2.setCertificateId("11");
        po2.setFaceTime("2021-06-18 04:12:22");
        po2.setName("张三");
        TestPO po3 = new TestPO();
        po3.setCertificateId("22");
        po3.setFaceTime("2021-06-18 05:15:22");
        po3.setName("王五");

        poList.add(po3);
        poList.add(po2);
        poList.add(po);

        // 人数, 根据身份证号去重
        List<TestPO> personList = poList.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() ->
                new TreeSet<>(Comparator.comparing(TestPO::getCertificateId))), ArrayList::new));
        // 升序
        //personList = personList.stream().sorted(Comparator.comparing(TouchNetPointPO::getFaceTime)).collect(Collectors.toList());
        // 降序
        personList = personList.stream().sorted(Comparator.comparing(TestPO::getFaceTime).reversed()).collect(Collectors.toList());
        System.out.println(personList);

    }

    public static long toMillis() {
        long millis = Math.multiplyExact(seconds, 1000);
        millis = Math.addExact(millis, nanos / 1000_000);
        return millis;
    }

    public static void main3(String[] args) {
        System.out.println(toMillis());

        Duration.ofSeconds(5);
    }

    public static void main4(String[] args) {
        String drugType = null;
        List<String> labelList = Arrays.asList(drugType.split(",").clone());
        System.out.println(labelList);
    }
    public static void main(String[] args) {
        Integer aa = null;
        int bb = 381;
        if (aa > bb) {
            System.out.println("aa大");
        } else {
            System.out.println("bb大");
        }
    }

}

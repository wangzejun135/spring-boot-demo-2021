package start.money;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class RedTest02 {

    public static List<Integer> redPaper(int totalAmount, int totalNumber) {
        List<Integer> list = new ArrayList<>();
        if (totalAmount <= 0 || totalNumber <= 0) {
            return list;
        }

        Set<Integer> set = new HashSet<>();
        while (set.size() < totalNumber - 1) {
            //生成一个1~totalAmount的随机数
            int random = ThreadLocalRandom.current().nextInt(1, totalAmount);
            set.add(random);
        }

        //使用set.toArray(new Integer[0])是为了保证转成数组后不用转型。因为不带Integer[0]的话，转过后是Object[]
        Integer[] amounts = set.toArray(new Integer[0]);
        //排序之后首先把数组中的第一位数放入List中
        Arrays.sort(amounts);
        list.add(amounts[0]);

        /**
         * 对排序后的数组进行如下操作。假如排序后的数组为{x1, x2, x3, x4, x5, x6}
         * 下面的规则就相当于是x2-x1+x3-x2+x4-x3+x5-x4+x6-x5=x6-x1。而x1已经在上面被添加到list中，因此现在list中数据总大小为x6。
         * 因此最后list.add(totalAmount - amounts[amounts.length - 1])时，也就=list.add(totalAmount - x6)，总数为totalAmount
         */
        for (int i = 1; i < amounts.length; i++) {
            list.add(amounts[i] - amounts[i - 1]);
        }

        list.add(totalAmount - amounts[amounts.length - 1]);
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = redPaper(100, 10);
        System.out.println(list);
        System.out.println(list.stream().mapToInt(x -> x).sum());
    }
}
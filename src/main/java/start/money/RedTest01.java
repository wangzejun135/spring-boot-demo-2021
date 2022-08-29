package start.money;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * @Describe
 * @Author wangzejun
 * @Date 2021/4/8 16:14
 */
public class RedTest01 {
    // 请按你的实际需求修改参数
    // a表示总金额， b表示人物个数
    public static List<Integer> solution(int a, int b) {
        // 在这⾥写代码
        List<Integer> list = new ArrayList();
        int sum = 0;
        while (list.size() < b - 1) {
            Random ran = new Random();
            int random = ran.nextInt(a/b * 2);
            if (random <= 0.9*a && random > 1) {

               int c = list.size() + 1;
                if (10*sum < c*a && sum < a) {
                    list.add(random);
                    sum += random;
                }
            }
        }
        int last = a - sum;
        list.add(last);
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = solution(100, 10);
        System.out.println(list);
    }


}

package study2021.list;

import java.util.ArrayList;

/**
 * @Description 两个list取交集
 * @Author WangZeJun
 * @Date 2021/05/27 10:27
 **/
public class ListTest {

    public static void main(String[] args) {
        ArrayList<String> listA = new ArrayList<String>();
        listA.add("Tom");
        listA.add("Las");
        ArrayList<String> listB = new ArrayList<String>();
        listB.add("Tom2");
        listB.add("Nick");
        listA.retainAll(listB);
        if (listA.size() > 0) {
            System.out.println("这两个集合有相同的交集");
            System.out.println(listA.toString());
        } else {
            System.out.println("这两个集合没有相同的交集");
            System.out.println(listA.toString());
        }
    }
}

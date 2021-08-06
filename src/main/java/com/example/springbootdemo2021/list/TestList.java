package com.example.springbootdemo2021.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description list拆分多个list
 * @Author WangZeJun
 * @Date 2021/07/23 16:08
 **/
public class TestList {
    public static void main(String[] args) {
        List list = new ArrayList<>();
        for (int i = 1; i <= 1260; i++) {
            list.add(i);
        }

        groupList(list);
    }

    static void groupList(List list) {
        int listSize = list.size();
        int toIndex = 500;
        int keyToken = 0;
        for (int i = 0; i < list.size(); i += 500) {
            if (i + 500 > listSize) {
                toIndex = listSize - i;
            }
            List newList = list.subList(i, i + toIndex);

            System.out.println(newList);
            keyToken++;
        }
        System.out.println("拆分多少次：" + keyToken);
    }

}

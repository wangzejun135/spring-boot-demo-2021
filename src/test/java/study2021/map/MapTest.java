package study2021.map;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author WangZeJun
 * @Date 2021/08/18 13:50
 **/
public class MapTest {
    public static void main(String[] args) {
        List<CodeListPO> poList = new ArrayList<>();
        CodeListPO po1 = new CodeListPO();
        po1.setCode("1");
        po1.setName("汽车");
        CodeListPO po2 = new CodeListPO();
        po2.setCode("2");
        po2.setName("卡车");
        poList.add(po1);
        poList.add(po2);
        Map<String, String> maps = poList.stream().collect(Collectors.toMap(CodeListPO::getCode, CodeListPO::getName, (key1, key2) -> key2));
        String aa = maps.get("1");
        String bb = maps.get("2");
        String cc = maps.get("3");
        System.out.println("aa:" + aa);
        System.out.println("bb:" + bb);
        System.out.println("cc:" + cc);
    }
}

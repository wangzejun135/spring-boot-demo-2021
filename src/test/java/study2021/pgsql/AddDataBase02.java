package study2021.pgsql;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * @Description 批量插入数据
 * @Author WangZeJun
 * @Date 2021/07/14 21:10
 **/
public class AddDataBase02 {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5000000; i++) {
            sb.append(i);
            sb.append(",");
            sb.append("A");
            sb.append(",");
            sb.append("22");
            sb.append(",");
            sb.append("22");
            sb.append(",");
            sb.append("22");
            sb.append(",");
            sb.append("22");
            sb.append(",");
            sb.append("22");
            sb.append(",");
            sb.append("22");
            sb.append(",");
            sb.append("22");
            sb.append(",");
            sb.append("22");
            sb.append(",");
            sb.append("22");
            sb.append("\r\n");
        }

        String name = sb.toString();
        // 录入文件地址
        File file = new File("d:/addData/data02.txt");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        OutputStream os = null;
        try {
            os = new FileOutputStream(file, true);//false覆盖  true 追加
            byte[] b = name.getBytes();
            os.write(b);//写入
            os.close();//关闭流
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}

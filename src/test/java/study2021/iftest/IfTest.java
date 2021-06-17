package study2021.iftest;

/**
 * @Description 条件语句测试
 * @Author WangZeJun
 * @Date 2021/06/11 10:13
 **/
public class IfTest {
    public static void main(String[] args) {
        String url = null;
        String type = "0";
        String integralDetailUrl = "asdsad:{certificateId}";
        String traceUrl = "dsfdhsif:{certificateId}";
        String allRecordUrl = "dsiudghwsei:{certificateId}";
        String certificateId = "362330";
        if ("0".equals(type) && !"null".equals(integralDetailUrl)) {
            url = integralDetailUrl.replace("{certificateId}", certificateId);
        } else if ("1".equals(type) && !"null".equals(traceUrl)) {
            url = traceUrl.replace("{certificateId}", certificateId);
        } else if ("2".equals(type) && !"null".equals(allRecordUrl)) {
            url = allRecordUrl.replace("{certificateId}", certificateId);
        }
        System.out.println("url: " + url);
    }
}

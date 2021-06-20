package study2021.shejimoshi;

/**
 * @Description
 * @Author WangZeJun
 * @Date 2021/06/16 19:43
 **/
public class MainTest {
    public static void main(String[] args) {
        // 公司A请假流程模版
        AskForLeaveFlow companyA = new CompanyA();
        companyA.askForLeave("敖丙");
        // 结果：CompanyA 组内有人请假，请假人：敖丙
        //       当前有人请假了，请假人：敖丙

        AskForLeaveFlow companyB = new CompanyB();
        companyB.askForLeave("敖丙");
        // 结果：CompanyB 组内有人请假，请假人：敖丙
        //      CompanyB 部门有人请假，请假人：敖丙
        //      当前有人请假了，请假人：敖丙
    }
}

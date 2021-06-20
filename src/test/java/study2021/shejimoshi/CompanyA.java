package study2021.shejimoshi;

/**
 * @Description
 * @Author WangZeJun
 * @Date 2021/06/16 19:15
 **/
public class CompanyA extends AskForLeaveFlow {

    @Override
    protected void firstGroupLeader(String name) {
        System.out.println("CompanyA 组内有人请假，请假人：" + name);
    }
}



package study2021.shejimoshi;

/**
 * @Description OA设计模板
 * @Author WangZeJun
 * @Date 2021/06/16 19:11
 **/
public abstract class AskForLeaveFlow {

    // 一级组长直接审批
    protected abstract void firstGroupLeader(String name);

    // 二级组长部门负责人审批
    protected void secondGroupLeader(String name) {
    }

    // 告知HR有人请假了
    private final void notifyHr(String name) {
        System.out.println("HR环节, 有人请假了，请假人：" + name);
        System.out.println("*********************");
    }

    // 请假流模版
    public void askForLeave(String name) {
        firstGroupLeader(name);
        secondGroupLeader(name);
        notifyHr(name);
    }

}


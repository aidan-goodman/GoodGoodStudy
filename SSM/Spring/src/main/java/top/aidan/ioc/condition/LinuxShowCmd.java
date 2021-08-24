package top.aidan.ioc.condition;

/**
 * Created by Aidan on 2021/8/17 10:33
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */
public class LinuxShowCmd implements ShowCmd {

    @Override
    public String showCmd() {
        return "ls";
    }
}

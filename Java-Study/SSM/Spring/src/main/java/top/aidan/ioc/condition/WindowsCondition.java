package top.aidan.ioc.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Locale;

/**
 * Created by Aidan on 2021/8/17 10:34
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */
public class WindowsCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext,
                           AnnotatedTypeMetadata annotatedTypeMetadata) {
        return conditionContext.getEnvironment().getProperty("os.name")
                .toLowerCase(Locale.ROOT).contains("win");
    }
}

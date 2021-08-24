package top.aidan.aware;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Aidan on 2021/8/17 11:09
 * GitHub: github.com/huaxin0304
 * Blog: aidanblog.top
 */
@Service
@PropertySource("aidan.properties")
public class AwareService implements BeanNameAware, BeanFactoryAware,
        ResourceLoaderAware, EnvironmentAware {

    private String beanName;
    private ResourceLoader resourceLoader;
    private Environment environment;

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {

    }

    public void outPut() throws IOException {
        System.out.println("beanName = " + beanName);
        Resource resource = resourceLoader.getResource("aidan.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
        String readLine = bufferedReader.readLine();
        System.out.println("readLine = " + readLine);
        bufferedReader.close();
        String propertyAddress = environment.getProperty("aidan.address");
        System.out.println("propertyAddress = " + propertyAddress);

    }

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }
}

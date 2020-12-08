import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.springframework.context.annotation.ComponentScan;

import javax.servlet.ServletException;
import java.io.File;

/**
 * @Description 启动类
 * @Author myf
 * @CreateDate 2020/11/12 9:25
 * @Version 1.0
 **/
public class Application {

    public static void main(String[] args) throws ServletException, LifecycleException {
        Tomcat tomcat = new Tomcat();
        //baseDir为tomcat的工作目录，可随意，如果不设置的话默认为主机名和端口号联名
        tomcat.setBaseDir("temp");
        //设置端口号
        tomcat.setPort(8089);
        /**
         * addWebapp(String context,String baseDir),该方法用于向tomcat添加一个web应用并进行默认配置，且会读取web应用的web.xml文件。
         * 其中参数中的context为web应用的名称（即发布到tomcat中web应用名称，也是项目的根路径），
         * baseDir为静态文件的文件夹的路径，在Idea中的maven项目中是webapp目录的绝对路径，在eclipse中则为WebContent目录的
         * 绝对路径。
         * 此外还有个addContext(),参数与addWebapp()一样（有重载此处不多讲），两者的不同在于addContext不会去读取web.xml，
         * 且也不会有默认的配置。
         */
        tomcat.addWebapp("/web",new File("src/main/webapp").getAbsolutePath());
        tomcat.start();
        tomcat.getServer().await();
    }
}

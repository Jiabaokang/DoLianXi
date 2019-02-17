import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//** WARNING ** : Your ApplicationContext is unlikely to start due to a @ComponentScan of the default package.
 //springboot项目警告，ApplicationContext不能从一个组建的默认包启动


@SpringBootApplication
@ComponentScan("com.course")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

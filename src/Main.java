import com.study.spring.beans.Monster;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//TIP 要<b>运行</b>代码，请按 <shortcut actionId="Run"/> 或
// 点击装订区域中的 <icon src="AllIcons.Actions.Execute"/> 图标。
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster monster01 = ioc.getBean("monster01", Monster.class);
        System.out.println(monster01);
    }
}
package tx;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * @author :jty
 * @date :20-10-30
 */
public class XmlMain{

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        OrderService orderService = applicationContext.getBean(OrderService.class);
        orderService.doOrder();
    }
}

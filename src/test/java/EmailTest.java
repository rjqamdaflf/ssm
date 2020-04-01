import com.ssm.utils.EmailUtil;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmailTest {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void send() {
        AbstractApplicationContext ctx =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        RabbitTemplate template = ctx.getBean(RabbitTemplate.class);
        template.convertAndSend("email", "sendCode", "hello world");
    }

    @Test
    public void test(){
        String email = "fjewjq@qqcom";
        System.out.println(EmailUtil.isEmail(email));
    }

}

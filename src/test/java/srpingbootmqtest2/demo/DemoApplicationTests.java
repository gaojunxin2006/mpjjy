package srpingbootmqtest2.demo;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class DemoApplicationTests {


    @Autowired
    RabbitTemplate rabbitTemplate;

    @Test
    void contextLoads() {

        System.out.println("程序能跑起来吗？");


        Map<String,Object> map=new HashMap<>();

        map.put("1","久久丫");
        map.put("2","留夫丫");
        map.put("create", LocalDateTime.now().toString());

        System.out.println(rabbitTemplate);

        rabbitTemplate.convertAndSend("jjy.direct","test1",map);

        rabbitTemplate.convertAndSend("jjy.fanout","test1.emps","爱我就啃我呀！");



    }

}

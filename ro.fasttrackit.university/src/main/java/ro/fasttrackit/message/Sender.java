package ro.fasttrackit.message;

// Sender
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ro.fasttrackit.service.model.MessageDto;

@Service
public class Sender {

    private final RabbitTemplate template;
    private final Queue queue;


    public Sender(RabbitTemplate template, Queue queue) {
        this.template = template;
        this.queue = queue;
    }


    public void send(String string) {
        this.template.convertAndSend(queue.getName(), string);
        System.out.println(" [x] Sent '" + string + "'");
    }

    /*

    public void send(String message) {
        this.template.convertAndSend(queue.getName(), message);
        System.out.println(" [x] Sent '" + message + "'");
    }
     */
}

package org.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class RabbitMqApp extends SpringBootServletInitializer {
    final static String queueName = "hello";


    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue userQueue() {
        return new Queue("user");
    }

    //===============以下是验证topic Exchange的队列==========
    @Bean
    public Queue queueMessageSql() {
        return new Queue("topic.sql");
    }
    @Bean
    public Queue queueMessageLink() {
        return new Queue("topic.link");
    }
    @Bean
    public Queue queueMessageNetty() {
        return new Queue("topic.netty");
    }
    @Bean
    public Queue queueMessageHtml() {
        return new Queue("topic.html");
    }

    @Bean
    public Queue queueMessages() {
        return new Queue("topic.messages");
    }
    //===============以上是验证topic Exchange的队列==========


    //===============以下是验证Fanout Exchange的队列==========
    @Bean
    public Queue AMessage() {
        return new Queue("fanout.sq");
    }

    @Bean
    public Queue BMessage() {
        return new Queue("fanout.link");
    }

    @Bean
    public Queue CMessage() {
        return new Queue("fanout.html");
    }

    @Bean
    public Queue DMessage() {
        return new Queue("fanout.netty");
    }
    //===============以上是验证Fanout Exchange的队列==========


    @Bean
    TopicExchange exchange() {
        return new TopicExchange("exchange");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    /**
     * 将队列topic.message与exchange绑定，binding_key为topic.message,就是完全匹配
     *
     * @return
     */
    @Bean
    Binding bindingExchangeMessageHtml(Queue queueMessageHtml, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessageHtml).to(exchange).with("topic.html");
    }

    @Bean
    Binding bindingExchangeMessageSQL(Queue queueMessageSql, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessageSql).to(exchange).with("topic.sql");
    }
    @Bean
    Binding bindingExchangeMessageNetty(Queue queueMessageNetty, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessageNetty).to(exchange).with("topic.netty");
    }
    @Bean
    Binding bindingExchangeMessageLink(Queue queueMessageLink, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessageLink).to(exchange).with("topic.link");
    }

    /**
     * 将队列topic.messages与exchange绑定，binding_key为topic.#,模糊匹配
     */
    @Bean
    Binding bindingExchangeMessages(Queue queueMessages, TopicExchange exchange) {
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }

    @Bean
    Binding bindingExchangeA(Queue AMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(AMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeB(Queue BMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(BMessage).to(fanoutExchange);
    }

    @Bean
    Binding bindingExchangeC(Queue CMessage, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(CMessage).to(fanoutExchange);
    }

//    public static void main(String[] args) throws Exception {
//        System.out.println("程序开始执行");
//        SpringApplication.run(RabbitMqApp.class, args);
//    }



    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        System.out.println("程序开始执行");
        return builder.sources(RabbitMqApp.class);
    }
}
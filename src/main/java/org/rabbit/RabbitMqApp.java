package org.rabbit;

import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.rabbit.mqtt.MqttMessage;
import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
public class RabbitMqApp extends SpringBootServletInitializer {
    final static String queueName = "hello";

    @Autowired
    MqttMessage mqttMessage;
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

    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[] { "tcp://127.0.0.1:1883" });
//        options.setUserName("username");
//        options.setPassword("password".toCharArray());
        options.setAutomaticReconnect(true); //自动重新链接
        options.setCleanSession(true);   //不保留session
        options.setKeepAliveInterval(30); //心跳周期
        factory.setConnectionOptions(options);
        return factory;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler mqttOutbound() {
        MqttPahoMessageHandler messageHandler =
                new MqttPahoMessageHandler("RbMqOutTestqq", mqttClientFactory());
        messageHandler.setAsync(true);
        messageHandler.setDefaultQos(1);
//        messageHandler.setDefaultTopic("testTopic");
        return messageHandler;
    }

    @Bean
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }






    @Bean
    public MessageChannel mqttInputChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageProducer inbound() {
        MqttPahoMessageDrivenChannelAdapter adapter =
                new MqttPahoMessageDrivenChannelAdapter("RbMqInTestqq",mqttClientFactory());

        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.addTopics(new String[]{"/upstream/#"},new int[]{1});  //订阅主题
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
//               接受mqtt消息
                mqttMessage.recieveMsg(message.getHeaders().get("mqtt_receivedTopic"), message.getPayload());
            }
        };
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        System.out.println("程序开始执行");
        return builder.sources(RabbitMqApp.class);
    }
}
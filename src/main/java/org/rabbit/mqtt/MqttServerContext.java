package org.rabbit.mqtt;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MqttServerContext implements ApplicationContextAware {
    private static ApplicationContext applicationContext = null;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if (MqttServerContext.applicationContext == null) {
//            System.out.println("mqttserverContext");
            MqttServerContext.applicationContext = applicationContext;

        }
    }

    public static MyGateWay getGateWay() {
        if (applicationContext != null)
            return applicationContext.getBean(MyGateWay.class);
//        System.out.println("mqttserverContext is null");
        return null;
    }
}

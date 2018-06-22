package org.rabbit.netty.udp;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;
@Component
public class UdpServer {
    @Autowired
    @Qualifier("udpBootstrap")
    private Bootstrap bootstrap;

    public Bootstrap getBootstrap() {
        return bootstrap;
    }

    public void setBootstrap(Bootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }

    public InetSocketAddress getTcpPort() {
        return udpPort;
    }

    public void setTcpPort(InetSocketAddress udpPort) {
        this.udpPort = udpPort;
    }

    @Autowired
    @Qualifier("udpSocketAddress")
    private InetSocketAddress udpPort;

    private ChannelFuture channelFuture;

    @PostConstruct
    public void start() throws InterruptedException {
        System.out.println("udpServer 启动了");
        channelFuture = bootstrap.bind(udpPort).sync();


    }

    @PreDestroy
    public void stop() throws InterruptedException {
        channelFuture.channel().closeFuture().sync();

    }


}

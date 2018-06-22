package org.rabbit.netty.tcp;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetSocketAddress;
@Component
public class TcpServer {
    @Autowired
    @Qualifier("serverBootstrap")
    private ServerBootstrap bootstrap;

    public ServerBootstrap getBootstrap() {
        return bootstrap;
    }


    public void setBootstrap(ServerBootstrap bootstrap) {
        this.bootstrap = bootstrap;
    }


    public InetSocketAddress getTcpPort() {
        return tcpPort;
    }

    public void setTcpPort(InetSocketAddress tcpPort) {
        this.tcpPort = tcpPort;
    }

    @Autowired
    @Qualifier("tcpSocketAddress")
    private InetSocketAddress tcpPort;

    private ChannelFuture channelFuture;

    @PostConstruct
    public void start() throws InterruptedException {
        System.out.println("tcpServer 启动了");
        channelFuture = bootstrap.bind(tcpPort).sync();


    }

    @PreDestroy
    public void stop() throws InterruptedException {
        channelFuture.channel().closeFuture().sync();

    }



}

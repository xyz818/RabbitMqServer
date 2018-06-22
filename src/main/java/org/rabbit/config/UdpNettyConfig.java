package org.rabbit.config;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.rabbit.netty.tcp.StringProtocolInitalizer;
import org.rabbit.netty.udp.UdpHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
@Configuration
public class UdpNettyConfig {


    @Autowired
    @Qualifier("udpHandler")
    private UdpHandler handler;


    @Bean(name = "udpBootstrap")
    public Bootstrap bootstrap()
    {

        Bootstrap b = new Bootstrap();
        b.group(workGroup()).channel(NioDatagramChannel.class).handler(handler);
        Map<ChannelOption<?>,Object> tcp = tcpChannelOptions();
        Set<ChannelOption<?> > keyset = tcp.keySet();
        for(@SuppressWarnings("rawtypes") ChannelOption option:keyset) {
            b.option(option, tcp.get(option));
        }
        return b;
    }



//    @Bean(name = "bossGroup",destroyMethod = "shutdownGracefully")
//    public NioEventLoopGroup bossGroup()
//    {
//
//        return new NioEventLoopGroup(2);
//    }


    @Bean(name = "UdpWorkerGroup",destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workGroup()
    {
        return new NioEventLoopGroup(2);
    }


    @Bean(name="udpSocketAddress")
    public InetSocketAddress tcpPort()
    {
        return new InetSocketAddress(19998);
    }


    @Bean(name="udpChannelOptions")
    public Map<ChannelOption<?>,Object> tcpChannelOptions()
    {
        Map<ChannelOption<?>,Object> optionObjectMap = new HashMap<ChannelOption<?>, Object>();
        optionObjectMap.put(ChannelOption.SO_KEEPALIVE,true);
        optionObjectMap.put(ChannelOption.SO_BACKLOG,100);
        return optionObjectMap;

    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }


}

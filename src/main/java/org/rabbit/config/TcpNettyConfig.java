package org.rabbit.config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import org.rabbit.netty.tcp.StringProtocolInitalizer;
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
public class TcpNettyConfig {




    @Autowired
    @Qualifier("springProtocolInitializer")
    private StringProtocolInitalizer protocolInitalizer;


    @Bean(name = "serverBootstrap")
    public ServerBootstrap bootstrap()
    {

        ServerBootstrap b = new ServerBootstrap();
        b.group(bossGroup(),workGroup()).channel(NioServerSocketChannel.class).childHandler(protocolInitalizer);
        Map<ChannelOption<?>,Object> tcp = tcpChannelOptions();
        Set<ChannelOption<?> > keyset = tcp.keySet();
        for(@SuppressWarnings("rawtypes") ChannelOption option:keyset) {
            b.option(option, tcp.get(option));
        }
        return b;
    }



    @Bean(name = "bossGroup",destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup bossGroup()
    {

        return new NioEventLoopGroup(2);
    }


    @Bean(name = "workerGroup",destroyMethod = "shutdownGracefully")
    public NioEventLoopGroup workGroup()
    {
        return new NioEventLoopGroup(2);
    }


    @Bean(name="tcpSocketAddress")
    public InetSocketAddress tcpPort()
    {
        return new InetSocketAddress(19999);
    }


    @Bean(name="tcpChannelOptions")
    public Map<ChannelOption<?>,Object> tcpChannelOptions()
    {
        Map<ChannelOption<?>,Object> optionObjectMap = new HashMap<ChannelOption<?>, Object>();
        optionObjectMap.put(ChannelOption.SO_KEEPALIVE,true);
        optionObjectMap.put(ChannelOption.SO_BACKLOG,100);
        return optionObjectMap;

    }


    @Bean(name = "stringEncoder")
    public StringEncoder stringEncoder()
    {
        return new StringEncoder();
    }


    @Bean(name= "stringDecoder")
    public StringDecoder stringDecoder()
    {
        return new StringDecoder();
    }


    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer()
    {
        return new PropertySourcesPlaceholderConfigurer();
    }


}

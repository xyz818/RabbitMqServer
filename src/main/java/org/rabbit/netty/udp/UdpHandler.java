package org.rabbit.netty.udp;


import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.socket.DatagramPacket;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("udpHandler")
@ChannelHandler.Sharable
public class UdpHandler extends SimpleChannelInboundHandler<DatagramPacket> {
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket) throws Exception {
//        System.out.println("sdfsdf ");
    }
}

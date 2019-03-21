package com.his.socket.server;

import com.his.resources.Config;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

/**
 * Client for test
 * @author lsy
 *
 */
public class SocketClient {

	/**
	 * SocketClientHandler
	 * @throws InterruptedException
	 */
	public void connect1(String ip, int port) throws InterruptedException {
		EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
		System.out.println("Client 0...");
        try{
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
            	.option(ChannelOption.SO_KEEPALIVE, true)
                .handler(new ChannelInitializer<SocketChannel>( ) {

					@Override
					protected void initChannel(SocketChannel arg0) throws Exception {
						 ChannelPipeline pipeline = arg0.pipeline();
					         pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4));
					         pipeline.addLast(new LengthFieldPrepender(4));
					         pipeline.addLast("decoder", new StringDecoder(CharsetUtil.UTF_8));
					         pipeline.addLast("encoder", new StringEncoder(CharsetUtil.UTF_8));
					         pipeline.addLast(new SocketClientHandler());
						
					}
                	
                });

            ChannelFuture channelFuture = bootstrap.connect(ip, port).sync();
            channelFuture.channel().closeFuture().sync();
        }finally {
            eventLoopGroup.shutdownGracefully();
        }
	}
	
	public static void main(String[] args) throws Exception {
		SocketClient client = new SocketClient();  
        client.connect1(Config.IP, Config.PORT); 
	}
}

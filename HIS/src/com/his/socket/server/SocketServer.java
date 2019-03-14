package com.his.socket.server;

import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.his.resources.Config;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

/**
 * Socket Server
 * @author lsy
 *
 */
@Service
public class SocketServer {
	
	private static Logger log = Logger.getLogger(SocketServer.class);
	
	private static final int port = Config.PORT;
	
	public void run() throws InterruptedException {
		EventLoopGroup bossGroup = new NioEventLoopGroup();        // 用来接收进来的连接
		EventLoopGroup workerGroup = new NioEventLoopGroup();      // 用来处理已经被接收的连接
		log.info("Start server：" + port);
		try {
			ServerBootstrap b = new ServerBootstrap();
			b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {

				@Override
				protected void initChannel(SocketChannel socketChannel) throws Exception {
					socketChannel.pipeline()
						.addLast("framer", new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE,0,4,0,4))
						.addLast(new LengthFieldPrepender(4, false))
						.addLast("decoder", new StringDecoder(CharsetUtil.UTF_8))
                        .addLast("encoder", new StringEncoder(CharsetUtil.UTF_8))
					//检测连接有效性（心跳）,此处功能：5秒内read()未被调用则触发一次useEventTrigger()方法
						.addLast(new IdleStateHandler(5, 0, 0, TimeUnit.MINUTES))
						.addLast(new SocketServerHandler());
				}
			})
			//服务端接受连接的队列长度，如果队列已满，客户端连接将被拒绝
			.option(ChannelOption.SO_BACKLOG, 128)
			.option(ChannelOption.SO_RCVBUF, 1048576*20)				//收包 20m 缓存
			.option(ChannelOption.CONNECT_TIMEOUT_MILLIS, 60000)		//超时1分钟
			.childOption(ChannelOption.SO_KEEPALIVE, true);     
			    
	      
			
			 // Bind and start to accept incoming connections.
			 ChannelFuture f = b.bind(port).sync();
			// Wait until the server socket is closed.
            // In this example, this does not happen, but you can do that to gracefully
            // shut down your server.
            f.channel().closeFuture().sync();
		} finally {
			workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
		}
		
	}
	
	@PostConstruct
	public void serverRun() throws InterruptedException {
		log.info("Server run...");
		new SocketServer().run();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		new SocketServer().run();
	}
	
}

package com.his.socket.server;

import org.apache.log4j.Logger;

import com.his.calc.CalculateScore;
import com.his.util.JSONUtil;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.ReferenceCountUtil;

/**
 * Socket request handler
 * @author lsy
 *
 */
public class SocketServerHandler extends SimpleChannelInboundHandler<String>{
	
	private static Logger log = Logger.getLogger(SocketServerHandler.class);
	
	
	@Override
	public void channelRead0(ChannelHandlerContext ctx, String msg) {
		log.info("Recieved data from remote address - " + ctx.channel().remoteAddress());
		try {
//			String body = new String(msg, CharsetUtil.UTF_8);
			String body = msg;
			log.info("Server recieved data: " + body);
			String ret = CalculateScore.calculate(body);
			log.info("return msg : " + ret);
			ctx.writeAndFlush(ret);
			  
		} catch (Exception e) {
			log.error("Calculate score error - ", e);
			log.info("return error msg - " + JSONUtil.err1());
			ctx.writeAndFlush(JSONUtil.err1());
			
		} finally {
			ReferenceCountUtil.release(msg);
		}
		
		
	}
	
	
	/**
	 * 当Netty由于IO错误或者处理器在处理事件时抛出异常时调用
	 */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
       // 当出现异常就关闭连接
    	log.error("Socket error：" + cause.getMessage());
    	cause.printStackTrace();
        ctx.close();
    }

}

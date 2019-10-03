package com.qqq.yuxin.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/**
 * Created by Administrator on 2019/8/29.
 */
public class NettyServer {

    private static final int port = 8080;
    private static final String url ="127.0.0.1";
    private static final int coreSize = Runtime.getRuntime().availableProcessors();


    public static void main(String[] args) {

        EventLoopGroup boss = new NioEventLoopGroup(1);
        EventLoopGroup work = new NioEventLoopGroup(coreSize);

        ServerBootstrap bootstrap = new ServerBootstrap();
        try {
            bootstrap.group(boss, work).channel(NioServerSocketChannel.class)
                    .option(ChannelOption.SO_BACKLOG, 1024)
                   // .option(ChannelOption.TCP_NODELAY, true)
                   // .option(ChannelOption.TCP_NODELAY, true)
                    .childHandler(new NettyInit());

            ChannelFuture future = bootstrap.bind(url, port).sync();
            future.channel().closeFuture().sync().addListener(new GenericFutureListener<Future<? super Void>>() {
                @Override
                public void operationComplete(Future<? super Void> future) throws Exception {
                     if (future.isSuccess()){
                         System.out.println("端口绑定成功");
                     }
                     else
                         System.out.println("失败");
                }
            });

        } catch (InterruptedException exception) {
            System.out.println("出错了");
        }
        finally {
            boss.shutdownGracefully();
            work.shutdownGracefully();
        }
    }
}

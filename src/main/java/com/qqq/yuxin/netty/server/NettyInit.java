package com.qqq.yuxin.netty.server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;


/**
 * Created by Administrator on 2019/8/29.
 */
public class NettyInit extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel channel) throws Exception {

        final ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast(new Handler());

    }
}

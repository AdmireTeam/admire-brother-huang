package com.abh.common;
import java.util.List;

import com.abh.constants.Constants;
import com.abh.utils.CommonUtil;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

public class Decoder extends ByteToMessageDecoder{
    public final int BASE_LENGTH = 6;

    private int offsetLength = 0;

    public Decoder(int offsetLength) {
        this.offsetLength = offsetLength;
    }

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf buffer, List<Object> out) throws Exception {

        // The readable length must be greater than the base length
        if (buffer.readableBytes() >= BASE_LENGTH) {

            // Record the header of the header
            int beginReader;

            while (true) {

                // Get the header at the beginning of the header
                beginReader = buffer.readerIndex();

                // Mark the header at the beginning of the header
                buffer.markReaderIndex();

                // Read the beginning of the protocol flag, end the while loop
                if (buffer.readByte() == Constants.START_VALUE) {
                    break;
                }

                // Not read the header, skip a byte
                // Every time you skip, one byte, read, and start the header tag
                buffer.resetReaderIndex();
                buffer.readByte();

                // When skipped, after a byte,The length of the packet becomes
                // unsatisfactory. At this point, it should end. Waiting for the
                // following data to arrive
                if (buffer.readableBytes() < BASE_LENGTH) {
                    return;
                }
            }

            // Length
            int length_L = buffer.readByte() & Constants.BYTE_MAX;
            int length_H = buffer.readByte() & Constants.BYTE_MAX;
            int length = length_L + (length_H << 8);

            if (offsetLength != 0) {
                length >>= offsetLength;
            }

            // Length we don't care
            buffer.readByte();
            buffer.readByte();
            buffer.readByte();

            // Determine whether the request packet data is in progress
            if (buffer.readableBytes() < (length + 2)) {

                // Restore read pointer
                buffer.readerIndex(beginReader);
                return;
            }

            // Read data
            byte[] data = new byte[length];
            buffer.readBytes(data);

            // Cs
            byte cs = buffer.readByte();

            // End
            byte end = buffer.readByte();

            if (end != Constants.END_VALUE) {
                return;
            }

            // Output array
            byte[] bytes = CommonUtil.getListByte(new byte[]{Constants.START_VALUE, (byte) length_L, (byte) length_H,
                    (byte) length_L, (byte) length_H, Constants.START_VALUE}, data, new byte[]{cs, end});

            // Bytes to @code{ByteBuf}
            ByteBuf buf = Unpooled.buffer();
            buf.writeBytes(bytes);

            // Wrap a @code{ByteBuf} array into a buffer
            out.add(buf);
        }
    }

}

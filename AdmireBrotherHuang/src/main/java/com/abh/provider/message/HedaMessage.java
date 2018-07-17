package com.abh.provider.message;


import com.abh.model.HedaRequestDTO;
import com.abh.utils.ConvertUtil;
import com.abh.utils.HexDumper;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;


public class HedaMessage {

    public static String generateMessage(HedaRequestDTO hedaRequestDTO){

        System.out.println("start");
        ByteBuf buf = Unpooled.buffer();
        //开头
        int start_data = 0xABCD;
        buf.writeShort(start_data);
        //长度头42 数据10*2+6*4+3*2=50 校验1
        int length = 42 + 56 + 1;
        buf.writeShort(length);
        //站号
        buf.writeShort(Integer.valueOf(hedaRequestDTO.getNumber()));
        //时间
        byte[] time = new byte[]{0x17,0x11,0x21,0x15,0x35};
        buf.writeBytes(time);
        //个数
        buf.writeByte(1);
        //间隔
        buf.writeByte(15);
        //电池电压
        buf.writeShort(3);
        //上发次数
        buf.writeShort(1);
        //信号强度
        buf.writeByte(48);
        //设备名称
        byte[] name = new byte[]{0x44,0x32,0x31,0x31,0x3b,0x31,0x2e,0x31,0x3b,0x35,0x2e,0x30,0x2e,0x30,0x32,0x32,0x20,0x20,0x20,0x20,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0};
        buf.writeBytes(name);

        //P13
        buf.writeByte(1);
        buf.writeByte(1);
        buf.writeInt(-1);
        buf.writeBytes(ConvertUtil.intToByteArray(Integer.valueOf(hedaRequestDTO.getP13())));
        //P14
        buf.writeByte(1);
        buf.writeByte(14);
        buf.writeInt(-1);
        buf.writeBytes(ConvertUtil.intToByteArray(Integer.valueOf(hedaRequestDTO.getP14())));
        //A1
        buf.writeByte(4);
        buf.writeByte(1);
        buf.writeFloat(Float.valueOf(hedaRequestDTO.getA1()));
        //A2
        buf.writeByte(4);
        buf.writeByte(2);
        buf.writeFloat(Float.valueOf(hedaRequestDTO.getA2()));
        //A3
        buf.writeByte(4);
        buf.writeByte(3);
        buf.writeFloat(Float.valueOf(hedaRequestDTO.getA3()));
        //A12
        buf.writeByte(4);
        buf.writeByte(12);
        buf.writeFloat(Float.valueOf(hedaRequestDTO.getA12()));
        //A13
        buf.writeByte(4);
        buf.writeByte(13);
        buf.writeFloat(Float.valueOf(hedaRequestDTO.getA13()));
        //K4
        buf.writeByte(2);
        buf.writeByte(4);
        buf.writeByte(Integer.valueOf(hedaRequestDTO.getK4()));
        //K5
        buf.writeByte(2);
        buf.writeByte(5);
        buf.writeByte(Integer.valueOf(hedaRequestDTO.getK5()));
        //检验
        buf.writeByte(106);
        //结尾
        int end_data = 0x0D0A;
        buf.writeShort(end_data);
        byte[] mes = new byte[buf.readableBytes()];
        buf.readBytes(mes);

        return HexDumper.getHexdump(mes);
    }

}

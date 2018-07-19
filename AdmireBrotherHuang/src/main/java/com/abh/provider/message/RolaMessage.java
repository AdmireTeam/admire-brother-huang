package com.abh.provider.message;
import com.abh.utils.CommonUtil;
import com.abh.utils.HexDumper;
import com.abh.model.RolaRequestDTO;
import com.abh.utils.ConvertUtil;


import static com.abh.utils.CommonUtil.sum;

public class RolaMessage {

    //项目号
    public static String pid = "d903";
    //序列号
    public static String number = "000f";
    //日期
    public static byte[] date = {18, 06, 07, 11, 14, 57, 8};

    public static String generateMessage(RolaRequestDTO rolaRequestDTO){
        String waterNum=CommonUtil.addZero2Num(rolaRequestDTO.getWaterNum(),8);
        String reading=CommonUtil.addZero2Num(rolaRequestDTO.getReading(),8);
        String conNum=CommonUtil.addZero2Num(rolaRequestDTO.getConNum(),8);
        //表端数据
        byte[] meterBytes1 = CommonUtil.getListByte(new byte[] {14,71,3},HexDumper.hexStringToByte(waterNum),
                new byte[] {58,(byte) 255},HexDumper.hexStringToByte(reading),new byte[] {8});
        byte[] meterBytes2 = CommonUtil.getListByte(meterBytes1,sum(meterBytes1));

        String x = ConvertUtil.xor(ConvertUtil.xor(pid)+ConvertUtil.xor(number));
        String k = ConvertUtil.sxor(HexDumper.getHexdump(meterBytes2),x);
        String dat =  HexDumper.getHexdump(date);

        //用户数据
        byte[] userBytes1 = CommonUtil.getListByte(new byte[] {36},HexDumper.hexStringToByte(pid),
                new byte[] {1},HexDumper.hexStringToByte(number),new byte[] {(byte) ((dat+k).length()/2)},
                HexDumper.hexStringToByte(dat+k),new byte[] {125,3});
        byte[] userBytes2 = CommonUtil.getListByte(userBytes1,sum(userBytes1));

        int len = userBytes2.length;
        //String length = CommonUtil.add00(len);
        byte[] length = new byte[2];

        for (int i = 0; i < 2; i++) {
            length[1-i] = (byte)(len >>> (i * 8));
        }
        //主动上报报文
        byte[] meterBytes = CommonUtil.getListByte(new byte[] {36},HexDumper.hexStringToByte(conNum),
                new byte[] {1},length,userBytes2,new byte[] {(byte)163,87});

        return HexDumper.getHexdump(meterBytes);
    }


}

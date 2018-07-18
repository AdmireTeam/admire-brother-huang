package com.abh.provider.message;

import com.abh.model.MaituoRequestDTO;
import com.abh.utils.CommonUtil;
import com.abh.utils.HexDumper;

import java.io.IOException;

import static com.abh.utils.BCDUtil.str2Bcd;
import static com.abh.utils.CommonUtil.*;
import static com.abh.utils.ConvertUtil.*;
import static com.abh.utils.HexDumper.hexStringToByte;

public class MaituoMessage {

    public static String generateHeartBytes(MaituoRequestDTO maituoRequestDTO) throws IOException {
        /*参数：集中器编码
         */


        byte[] res = null;
        byte[] heartBytes = null;
        byte start7B = (byte)123;


        String conAddr = stringToHexAscii(maituoRequestDTO.getConAddress());
        //System.out.println("conAddr:" + conAddr);
        byte[] controlBytes = new byte[] { start7B };
        byte[] heartEnd = new byte[] {(byte)10,(byte)116,(byte)252,(byte)95,(byte)15,(byte)162};

        heartBytes = getListByte(controlBytes,new byte[] { (byte)1 },new byte[] { (byte)0 },new byte[] { (byte)22 },hexStringToByte(conAddr),heartEnd,controlBytes);

        res = heartBytes;
        System.out.println(HexDumper.getHexdump(res));
        return HexDumper.getHexdump(res);
    }


    public static byte[] generateUpStreamMessage(MaituoRequestDTO maituoRequestDTO) throws IOException {
        /* 迈拓主动上报水表数据报文

        参数：
        集中器编码 String conStartAddr"201710270001";
        水表序号 String waterNumber = "12345678";
        正向累计流量 String accumulate1 = "12345678";
        反向累计流量 String accumulate2 = "12345678";
        瞬时流量 String instant = "00123456";
        时间 String time = "20141120112006";
         */


        byte[] waterNumber1 = str2Bcd(String.valueOf(maituoRequestDTO.getWaterNum()));
        byte[] factory_code = new byte[]{(byte)0,(byte)17,(byte)17};


        byte[] unit_L = new byte[]{(byte)41};
        byte[] unit_Lh = new byte[]{(byte)50};

        byte[] res = null;
        byte[] dataBytes = null;
        byte start7B = (byte)123;


        byte[] controlBytes = new byte[] { start7B };
        byte[] header7B = new byte[] {(byte)123, (byte)10, (byte)0};
        byte[] length7B = new byte[] {(byte)56};
        byte[] controlBytes_new = new byte[]{(byte)129,(byte)27,(byte)137,(byte)26,(byte)179 };
        byte[] waterState = new byte[]{(byte)0};
        byte[] valveState = new byte[]{(byte)85};
        byte[] accumulate_1 = reverseArray(str2Bcd(maituoRequestDTO.getAccumulate1()));
        byte[] accumulate_2 = reverseArray(str2Bcd(maituoRequestDTO.getAccumulate2()));
        byte[] instantFlow = reverseArray(str2Bcd(maituoRequestDTO.getInstantFlow()));
        byte[] timeBCD = reverseArray(str2Bcd(maituoRequestDTO.getTime()));

        String conAddr = stringToHexAscii(maituoRequestDTO.getConAddress());
        //System.out.println("conAddr:" + conAddr);


        int sum = CommonUtil.getSumFromArr(new byte[] {START_VALUE}) + CommonUtil.getSumFromArr(new byte[]{(byte)16})+CommonUtil.getSumFromArr(waterNumber1)
                + CommonUtil.getSumFromArr(factory_code) + CommonUtil.getSumFromArr(controlBytes_new) + CommonUtil.getSumFromArr(accumulate_1)
                + CommonUtil.getSumFromArr(unit_L) + CommonUtil.getSumFromArr(accumulate_2) + CommonUtil.getSumFromArr(unit_L) + CommonUtil.getSumFromArr(instantFlow)
                + CommonUtil.getSumFromArr(unit_Lh) + CommonUtil.getSumFromArr(timeBCD) + CommonUtil.getSumFromArr(waterState) + CommonUtil.getSumFromArr(valveState);
        dataBytes = getListByte(header7B,length7B,hexStringToByte(conAddr),new byte[] {START_VALUE},new byte[]{(byte)16},waterNumber1,factory_code,controlBytes_new,accumulate_1,unit_L,accumulate_2,unit_L,instantFlow,unit_Lh,timeBCD,waterState,valveState,new byte[] { (byte) (sum % 256) },new byte[] {END_VALUE},controlBytes);

        res = dataBytes;
        System.out.println(HexDumper.getHexdump(res));
        return res;
    }

    public static byte[] generateResponseMessage(MaituoRequestDTO maituoRequestDTO) throws IOException {
        /* 迈拓回复服务端上行报文

        参数：
        集中器编码 String conStartAddr"201710270001";
        水表序号 String waterNumber = "12345678";
        正向累计流量 String accumulate1 = "12345678";
        反向累计流量 String accumulate2 = "12345678";
        瞬时流量 String instant = "00123456";
        时间 String time = "20141120112006";
         */


        byte[] waterNumber1 = str2Bcd(String.valueOf(maituoRequestDTO.getWaterNum()));
        byte[] factory_code = new byte[]{(byte)0,(byte)17,(byte)17};


        byte[] unit_L = new byte[]{(byte)41};
        byte[] unit_Lh = new byte[]{(byte)50};

        byte[] res = null;
        byte[] dataBytes = null;
        byte start7B = (byte)123;


        byte[] controlBytes = new byte[] { start7B };
        byte[] header7B = new byte[] {(byte)123, (byte)9, (byte)0};
        byte[] length7B = new byte[] {(byte)56};
        byte[] controlBytes_new = new byte[]{(byte)129,(byte)27,(byte)137,(byte)26,(byte)179 };
        byte[] waterState = new byte[]{(byte)0};
        byte[] valveState = new byte[]{(byte)85};
        byte[] accumulate_1 = reverseArray(str2Bcd(maituoRequestDTO.getAccumulate1()));
        byte[] accumulate_2 = reverseArray(str2Bcd(maituoRequestDTO.getAccumulate2()));
        byte[] instantFlow = reverseArray(str2Bcd(maituoRequestDTO.getInstantFlow()));
        byte[] timeBCD = reverseArray(str2Bcd(maituoRequestDTO.getTime()));

        String conAddr = stringToHexAscii(maituoRequestDTO.getConAddress());
        //System.out.println("conAddr:" + conAddr);


        int sum = CommonUtil.getSumFromArr(new byte[] {START_VALUE}) + CommonUtil.getSumFromArr(new byte[]{(byte)16})+CommonUtil.getSumFromArr(waterNumber1)
                + CommonUtil.getSumFromArr(factory_code) + CommonUtil.getSumFromArr(controlBytes_new) + CommonUtil.getSumFromArr(accumulate_1)
                + CommonUtil.getSumFromArr(unit_L) + CommonUtil.getSumFromArr(accumulate_2) + CommonUtil.getSumFromArr(unit_L) + CommonUtil.getSumFromArr(instantFlow)
                + CommonUtil.getSumFromArr(unit_Lh) + CommonUtil.getSumFromArr(timeBCD) + CommonUtil.getSumFromArr(waterState) + CommonUtil.getSumFromArr(valveState);
        dataBytes = getListByte(header7B,length7B,hexStringToByte(conAddr),new byte[] {START_VALUE},new byte[]{(byte)16},waterNumber1,factory_code,controlBytes_new,accumulate_1,unit_L,accumulate_2,unit_L,instantFlow,unit_Lh,timeBCD,waterState,valveState,new byte[] { (byte) (sum % 256) },new byte[] {END_VALUE},controlBytes);

        res = dataBytes;
        System.out.println(HexDumper.getHexdump(res));
        return res;
    }



}




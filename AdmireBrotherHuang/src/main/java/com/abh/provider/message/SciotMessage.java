package com.abh.provider.message;

import com.abh.model.SciotRequestDTO;
import com.abh.utils.CommonUtil;
import com.abh.utils.HexDumper;

import static com.abh.utils.CommonUtil.sum;

public class SciotMessage {


    public static  String generateMessage(SciotRequestDTO sciotRequestDTO) {
        String waterNum=sciotRequestDTO.getWaterNum();
        String reading=sciotRequestDTO.getReading();
        String startDate=sciotRequestDTO.getStartDate();

        byte[] meter = HexDumper.hexStringToByte(String.valueOf(waterNum));
        String start1 = "68009F68";

        String start2 = "A8000000A70F10046004019930665903000174A8";
        byte[] data1 = CommonUtil.getListByte(HexDumper.hexStringToByte("1002"),CommonUtil.getReseaseArr(meter),
                HexDumper.hexStringToByte(start2),HexDumper.hexStringToByte(startDate),new byte[] {3});

        byte[] data2 = CommonUtil.getListByte(HexDumper.hexStringToByte(start1),data1);

        byte[] data = null;
        for (int i=0;i<31;i++) {

            double dou = Double.parseDouble(reading);
            int a = (int)(dou*1000);
            int r = a + i*1000;
            String r1 = CommonUtil.aaa(Integer.toString(r));
            if(data != null){

                data = CommonUtil.getListByte(data,HexDumper.hexStringToByte(r1));
            }else{
                data = CommonUtil.getListByte(HexDumper.hexStringToByte(r1));
            }

            }
        byte[] data3 = CommonUtil.getListByte(data2,data,sum(CommonUtil.getListByte(data1,data)),new byte[] {22});

        return HexDumper.getHexdump(data3);
    }



}


package com.abh.provider.message;

import com.abh.model.XtRequestDTO;
import com.abh.utils.CommonUtil;
import com.abh.utils.HexDumper;

import java.io.IOException;

public class XtMessage {
    public static String generateMessage(int mode,XtRequestDTO xtRequestDTO)
            throws IOException {
		/*
		File fout = new File("H:/xintian.txt");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		bw.write("集中器号" + "," + "登录报文" + "," + "心跳报文" + "," + "群抄报文");
		bw.newLine();
		*/
        byte[] res = null;
        byte[] loginBytes = null;
        byte[] heartBytes = null;
        byte[] readManyMetersBytes = null;
        //String reading = "00002200";
        System.out.println("****:"+xtRequestDTO.getConStartAddr());
        loginBytes = CommonUtil.getDownMessage((short) 39, (byte) 136, xtRequestDTO.getConStartAddr(),
                (byte) 2, (byte) 96, (byte) 1, null);
        heartBytes = CommonUtil.getDownMessage((short) 39, (byte) 136, xtRequestDTO.getConStartAddr(),
                (byte) 2, (byte) 96, (byte) 3, null);

        for (int i = 0; i < xtRequestDTO.getConCount(); i++) {

            byte[] data = null;
            readManyMetersBytes = null;
            for (int j = 0; j < xtRequestDTO.getMeterCount(); j++) {
                String reading = getNextReading(xtRequestDTO.getReading());
                //long meterStartAddr = Integer.parseInt(xtRequestDTO.getMeterStartAddr());
                //String ma = String.valueOf(meterStartAddr);
                if (data != null) {
                    data = CommonUtil.getListByte(data,
                            CommonUtil.getListByte(HexDumper.hexStringToByte(String.valueOf(Long.parseLong(xtRequestDTO.getMeterStartAddr())+j) + "01"),
                                    CommonUtil.reverseArray(HexDumper.hexStringToByte(reading)),
                                    HexDumper.hexStringToByte("0200")));
                } else {
                    data = CommonUtil.getListByte(HexDumper.hexStringToByte(xtRequestDTO.getMeterStartAddr() + "01"),
                            CommonUtil.reverseArray(HexDumper.hexStringToByte(reading)),
                            HexDumper.hexStringToByte("0000"));
                }
                //meterStartAddr++;


               // ma = Long.toString(meterStartAddr);
                //if (ma.length()<12){
                //    for(int k=0;k<12-ma.length();k++){
                //        ma = "0" + ma;
                //    }

               // }

            }

            readManyMetersBytes = CommonUtil.getDownMessage((short) ((18 + xtRequestDTO.getMeterCount() * 13) << 2), (byte) 136,
                    String.valueOf(xtRequestDTO.getConStartAddr()), (byte) 12, (byte) 64, (byte) 1,
                    CommonUtil.getListByte(new byte[] { 1, 0, 1, 0, (byte) xtRequestDTO.getMeterCount(), 19, 9, 23, 16 }, data));
			/*
			bw.write(conStartAddr + "," + HexDumper.getHexdump(loginBytes) + "," + HexDumper.getHexdump(heartBytes)
					+ "," + HexDumper.getHexdump(readManyMetersBytes));
			bw.newLine();
			*/
            //conStartAddr++;
        }
        //bw.close();
        if(mode==1) {
            res = loginBytes;
        }
        else if(mode==2) {
            res = readManyMetersBytes;
        }
        else {
            res = heartBytes;
        }
        return HexDumper.getHexdump(res);
    }

    public static String getNextReading(String reading) {
        Integer oldReading = Integer.parseInt(reading);
        String temp = String.valueOf(++oldReading);
        int length = temp.length();
        for (int i = 0; i < 8 - length; i++) {
            temp = "0" + temp;
        }
        return temp;
    }
}

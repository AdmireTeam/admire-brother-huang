package com.abh.provider.message;

import com.abh.model.JxRequestDTO;
import com.abh.utils.CommonUtil;
import com.abh.utils.HexDumper;

import java.io.IOException;

public class JxMessage {
    public static String generateMessage(int mode, JxRequestDTO jxRequestDTO) throws IOException {
        /*参数：集中器编码、集中器个数、水表个数
         * mode为1：返回登陆报文
         * mode为2：返回群抄报文
         * mode为3：返回心跳报文
         */
		/*
		File fout = new File("E:/jiexian.txt");
		FileOutputStream fos = new FileOutputStream(fout);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
		bw.write("集中器号" + "," + "登录报文" + "," + "心跳报文" + "," + "群抄报文");
		bw.newLine();
		*/
        //String reading = "00001000";
        byte[] res = null;
        byte[] loginBytes = null;
        byte[] heartBytes = null;
        byte[] readManyMetersBytes = null;
        for (int i = 0; i < jxRequestDTO.getConCount(); i++) {
            loginBytes = CommonUtil.getDownMessage((short) 53, (byte) 201, String.valueOf(jxRequestDTO.getConAddr()),
                    (byte) 2, (byte) 112, 268435712, new byte[] { 35 });
            heartBytes = CommonUtil.getDownMessage((short) 53, (byte) 201, String.valueOf(jxRequestDTO.getConAddr()),
                    (byte) 2, (byte) 112, 268436480, new byte[] { 36 });
            byte[] data = null;

            int meterTN = 1;
            String reading = jxRequestDTO.getReading();
            for (int j = 0; j < jxRequestDTO.getMeterCount(); j++) {
                reading = getNextReading(reading);
                if (data != null) {
                    data = CommonUtil.getListByte(data, CommonUtil.getListByte(new byte[] { 01, (byte) meterTN },
                            CommonUtil.reverseArray(HexDumper.hexStringToByte("00" + reading))));
                } else {
                    data = CommonUtil.getListByte(new byte[] { 01, (byte) meterTN },
                            CommonUtil.reverseArray(HexDumper.hexStringToByte("00" + reading)));
                }
                meterTN++;
            }
            //System.out.println(HexDumper.getHexdump(data));

            readManyMetersBytes = CommonUtil.getDownMessage((short) ((14 + jxRequestDTO.getMeterCount() * 7) << 2), (byte) 136,
                    String.valueOf(jxRequestDTO.getConAddr()), (byte) 140, (byte) 96, 805306631,
                    CommonUtil.getListByte(new byte[] { (byte) jxRequestDTO.getMeterCount(), 0 }, data));
/*			bw.write(conStartAddr + "," + HexDumper.getHexdump(loginBytes) + "," + HexDumper.getHexdump(heartBytes)
					+ "," + HexDumper.getHexdump(readManyMetersBytes));
*/
/*			bw.write(HexDumper.getHexdump(loginBytes) + "," + HexDumper.getHexdump(heartBytes)
			+ "," + HexDumper.getHexdump(readManyMetersBytes));
*/

            //bw.newLine();
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
        //System.out.println("oldreading:" + oldReading);
        String temp = String.valueOf(++oldReading);
        int length = temp.length();
        for (int i = 0; i < 8 - length; i++) {
            temp = "0" + temp;
        }
        //System.out.println("temp:" + temp);
        return temp;
    }
}

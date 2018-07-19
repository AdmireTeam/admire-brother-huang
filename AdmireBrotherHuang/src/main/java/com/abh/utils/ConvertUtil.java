package com.abh.utils;


import java.io.UnsupportedEncodingException;

import org.apache.mina.core.buffer.IoBuffer;

/**
 * TODO 这里请补充该类型的简述说明
 * @author <a href="mailto:fanxt@emrubik.com">fanxiaotong</a>
 * @version $Revision 1.0 $ 2017年8月10日 下午6:31:33
 */
public class ConvertUtil {
    
    /**
     * getHighData 低位转换高位
     * @param buffer
     * @return TODO 请在每个@param,@return,@throws行尾补充对应的简要说明
     */
    private Object getHighData(IoBuffer buffer) {
        return buffer.getUnsigned() + (buffer.getUnsigned() << 8) 
                + (buffer.getUnsigned() << 16) + (buffer.getUnsigned() << 24);
    }
    
    /**  
     * int到byte[]  
     * @param i  
     * @return  
     */  
    public static byte[] intToByteArray(int i) {     
          byte[] result = new byte[4];    
          //由高位到低位  
//          result[0] = (byte)((i >> 24) & 0xFF);  
//          result[1] = (byte)((i >> 16) & 0xFF);  
//          result[2] = (byte)((i >> 8) & 0xFF);  
//          result[3] = (byte)(i & 0xFF);  
          result[0] = (byte)(i & 0xFF);
          result[1] = (byte)((i >> 8) & 0xFF);  
          result[2] = (byte)((i >> 16) & 0xFF);  
          result[3] = (byte)((i >> 24) & 0xFF);  
          return result;  
    } 
    
    /**
     * 
     * bcd2Str 字节数组转BCD码
     * @param bytes
     * @return TODO 请在每个@param,@return,@throws行尾补充对应的简要说明
     */
    public static String bcd2Str(byte[] bytes) {
        StringBuffer temp = new StringBuffer(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            temp.append((byte) ((bytes[i] & 0xf0) >>> 4));
            temp.append((byte) (bytes[i] & 0x0f));
        }
        return temp.toString();
    }
    
    /**
     * 
     * bytesToAscii 将字节数组转为ascii码
     * @param bytes 将字节数组转为ascii码
     * @param offset 起始位置
     * @param dateLen 长度
     * @return TODO 请在每个@param,@return,@throws行尾补充对应的简要说明
     */
    public static String bytesToAscii(byte[] bytes, int offset, int dateLen) {  
        if ((bytes == null) || (bytes.length == 0) || (offset < 0) || (dateLen <= 0)) {  
            return null;  
        }  
        if ((offset >= bytes.length) || (bytes.length - offset < dateLen)) {  
            return null;  
        }  
  
        String asciiStr = null;  
        byte[] data = new byte[dateLen];  
        System.arraycopy(bytes, offset, data, 0, dateLen);  
        try {  
            asciiStr = new String(data, "ISO8859-1");  
        } catch (UnsupportedEncodingException e) {  
        }  
        return asciiStr;  
    }  
  
    /**
     * 
     * bytesToAscii 将字节数组转为ascii码
     * @param bytes 字节数组
     * @param dateLen 长度
     * @return TODO 请在每个@param,@return,@throws行尾补充对应的简要说明
     */
    public static String bytesToAscii(byte[] bytes, int dateLen) {  
        return bytesToAscii(bytes, 0, dateLen);  
    }
    
    /**
     * byteToBit 把byte转为字符串的bit 
     */
    public static String byteToBit(byte b) {  
        return ""  
                + (byte) ((b >> 7) & 0x1) + (byte) ((b >> 6) & 0x1)  
                + (byte) ((b >> 5) & 0x1) + (byte) ((b >> 4) & 0x1)  
                + (byte) ((b >> 3) & 0x1) + (byte) ((b >> 2) & 0x1)  
                + (byte) ((b >> 1) & 0x1) + (byte) ((b >> 0) & 0x1);  
    }  
    
    /** 
     * 二进制字符串转byte 
     */  
    public static byte decodeBinaryString(String byteStr) {  
        int re, len;  
        if (null == byteStr) {  
            return 0;  
        }  
        len = byteStr.length();  
        if (len != 4 && len != 8) {  
            return 0;  
        }  
        if (len == 8) {// 8 bit处理  
            if (byteStr.charAt(0) == '0') {// 正数  
                re = Integer.parseInt(byteStr, 2);  
            } else {// 负数  
                re = Integer.parseInt(byteStr, 2) - 256;  
            }  
        } else {// 4 bit处理  
            re = Integer.parseInt(byteStr, 2);  
        }  
        return (byte) re;  
    }

    public static String stringToHexAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            sbu.append(Integer.toHexString((int)chars[i]));


        }

        return sbu.toString();

    }

    public static byte[] hexStrToByteArray(String str)
    {
        if (str == null) {
            return null;
        }
        if (str.length() == 0) {
            return new byte[0];
        }
        byte[] byteArray = new byte[str.length() / 2];
        for (int i = 0; i < byteArray.length; i++){
            String subStr = str.substring(2 * i, 2 * i + 2);
            byteArray[i] = ((byte)Integer.parseInt(subStr, 16));
        }
        return byteArray;
    }
    

    public static byte[] parseBytes(String s,boolean lp0) {
        s = s.replace(" ", "");
        if(lp0==true && s.length()%2!=0)
        {
            s="0"+s;
        }
        byte[] ba = new byte[s.length() / 2];
        if (s.length() % 2 > 0) {
            s = s + '0';
        }
        for (int i = 0; i < s.length(); i += 2) {
            ba[i / 2] = (byte) (charToNibble(s.charAt(i)) << 4 | charToNibble(s.charAt(i + 1)));
        }
        return ba;
    }

    private static int charToNibble(char c) {
        if (c >= '0' && c <= '9') {
            return (c - '0');
        } else if (c >= 'a' && c <= 'f') {
            return (10 + c - 'a');
        } else if (c >= 'A' && c <= 'F') {
            return (10 + c - 'A');
        } else {
            return 0;
        }
    }

    private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5',
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String bytesToHexFun2(byte[] bytes) {
        char[] buf = new char[bytes.length * 2];
        int index = 0;
        for(byte b : bytes) { // 利用位运算进行转换，可以看作方法一的变种
            buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
            buf[index++] = HEX_CHAR[b & 0xf];
        }

        return new String(buf);
    }

    //异或
    public static String xor(String content) {
        content = change(content);
        String[] b = content.split(" ");
        int a = 0;
        for (int i = 0; i < b.length; i++) {
            a = a ^ Integer.parseInt(b[i], 16);
        }
        if(a<10){
            StringBuffer sb = new StringBuffer();
            sb.append("0");
            sb.append(a);
            return sb.toString();
        }
        return Integer.toHexString(a);
    }

    //
    public static String sxor(String x,String y) {
        x = change(x);
        String[] q = x.split(" ");
        int[] a= new int[100];
        String a2 = new String();
        int y1= Integer.parseInt(y,16);
        for (int i = 0; i < q.length; i++) {
            a[i] = y1 ^ Integer.parseInt(q[i], 16);
            if (a[i]<16) {
                a2 = a2+"0"+Integer.toHexString(a[i]);
            }
            else {
                a2 = a2+Integer.toHexString(a[i]);
            }
        }
        return a2;
    }

    //
    public static String change(String content) {
        String str = "";
        for (int i = 0; i < content.length(); i++) {
            if (i % 2 == 0) {
                str += " " + content.substring(i, i + 1);
            } else {
                str += content.substring(i, i + 1);
            }
        }
        return str.trim();
    }

}
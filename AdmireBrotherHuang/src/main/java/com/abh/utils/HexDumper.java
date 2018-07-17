/*******************************************************************************
 * @(#)HexDumper.java 2009-3-25
 *
 * Copyright 2009 emrubik Group Ltd. All rights reserved.
 * emrubik PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *******************************************************************************/
package com.abh.utils;

import io.netty.buffer.ByteBuf;

public final class HexDumper {
    private HexDumper() {
    }

    private static final byte[] highDigits;

    private static final byte[] lowDigits;

    private static final String newLine = "\r\n";

    // initialize lookup tables
    static {
        final byte[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

        int i;
        byte[] high = new byte[256];
        byte[] low = new byte[256];

        for (i = 0; i < 256; i++) {
            high[i] = digits[i >>> 4];
            low[i] = digits[i & 0x0F];
        }

        highDigits = high;
        lowDigits = low;
    }

    /**
     * ��16�����ַ���ת�����ֽ�����
     * 
     * @param hex
     * @return
     */
    public static byte[] hexStringToByte(String hex) {
        if (null == hex) {
            return null;
        }
        hex = hex.toUpperCase();
        if (hex.length() % 2 != 0) {
            hex = "0" + hex;
        }
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }

    /**
     * byte����ת16�����ַ�,���ո���������Ϊ�����
     * 
     * @param bb
     * @return 16�����ַ�
     */
    public static String getHexdump(byte[] bb, int colNum) {

        StringBuffer out = new StringBuffer(bb.length * 2);

        // fill the first
        int byteValue = bb[0] & 0xFF;
        out.append(newLine);
        out.append((char) highDigits[byteValue]);
        out.append((char) lowDigits[byteValue]);
        out.append(" ");
        int size = bb.length;
        size--;

        // and the others, too
        for (; size > 0; size--) {
            byteValue = bb[bb.length - size] & 0xFF;
            out.append((char) highDigits[byteValue]);
            out.append((char) lowDigits[byteValue]);
            out.append(" ");
            if ((bb.length - size + 1) % (colNum) == 0) out.append(newLine);
            if (size == 1) out.append(" " + newLine);
        }
        return out.toString();
    }

    /**
     * byte����ת16�����ַ�
     * 
     * @param bb
     * @return 16�����ַ�
     */
    public static String getHexdump(byte[] bb) {

        StringBuffer out = new StringBuffer(bb.length * 2);

        // fill the first
        int byteValue = bb[0] & 0xFF;
        out.append((char) highDigits[byteValue]);
        out.append((char) lowDigits[byteValue]);
        int size = bb.length;
        size--;

        // and the others, too
        for (; size > 0; size--) {
            byteValue = bb[bb.length - size] & 0xFF;
            out.append((char) highDigits[byteValue]);
            out.append((char) lowDigits[byteValue]);
        }
        return out.toString();
    }

    public static byte[] buf2bytes(ByteBuf buff) {
        byte[] bytes = new byte[buff.readableBytes()];
        buff.markReaderIndex();
        buff.readBytes(bytes);
        buff.resetReaderIndex();
        return bytes;
    }
}

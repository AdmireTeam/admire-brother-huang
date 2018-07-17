package com.abh.utils;


import java.util.ArrayList;
import java.util.List;
//import java.util.logging.Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import org.slf4j.LoggerFactory;

public class CommonUtil
{
	public static final int START_VALUE = 104;
	public static final int END_VALUE = 22;
	public static final int BYTE_MAX = 0xff;
	public static final byte[] HZ_HEAD = {0x3e,0x01};
	public static final byte[] HZ_ID = {0x49,0x44,0x3a};
	public static final byte[] HZ_DA = {0x44,0x41,0x3a};

	private static final Logger logger = LoggerFactory.getLogger(CommonUtil.class);

	/**
	 * Create a new CommonUtil
	 */
	private CommonUtil() {

	}

	public static byte[] getHeaderBytes(short length) {
		byte[] startBytes = new byte[] { START_VALUE };
		byte[] lengthBytes = BitUtil.shortToBytesL(length);
		byte[] bytes = getListByte(startBytes, lengthBytes, lengthBytes, startBytes);
		return bytes;
	}
	
	public static byte[]  getListByte(byte[]... bytes) {
		List<byte[]> collect = new ArrayList<byte[]>();
		if (bytes != null) {
			for (int j = 0; j < bytes.length; j++) {
				collect.add(bytes[j]);
			}
		}
		byte[] aa0 = null;
		// Each time the two arrays are merged so the number of merges is
		// collect.size (), the first
		// is the virtual array
		for (int i = 0; i < collect.size(); i++) {
			int aa0Length = aa0 == null ? 0 : aa0.length;
			byte[] aa1 = (byte[]) collect.get(i);
			byte[] c = new byte[aa0Length + aa1.length];
			if (aa0 != null) {
				System.arraycopy(aa0, 0, c, 0, aa0Length);
			}
			System.arraycopy(aa1, 0, c, aa0Length, aa1.length);
			aa0 = c;
		}
		return aa0;
	}
	
	public static byte[] getDownMessage(short length, byte control, String addressFiled, byte afnOut, byte seqOut,
			Object dataUnit, byte[] content) {
		byte[] headerBytes = CommonUtil.getHeaderBytes(length);
		byte[] controlBytes = new byte[] { control };
		byte[] addrBytes = BCDUtil.str2Bcd(addressFiled);
		byte[] afnOutBytes = new byte[] { afnOut };
		byte[] seqOutBytes = new byte[] { seqOut };
		byte[] dataUnitBytes = null;
		if (dataUnit instanceof Integer) {
			dataUnitBytes = BitUtil.intToBytes((int) dataUnit);
		} else if (dataUnit instanceof Byte) {
			dataUnitBytes = new byte[] { (byte) dataUnit };
		}

		int sum = CommonUtil.getSumFromArr(controlBytes) + CommonUtil.getSumFromArr(addrBytes)
				+ CommonUtil.getSumFromArr(afnOutBytes) + CommonUtil.getSumFromArr(seqOutBytes)
				+ CommonUtil.getSumFromArr(dataUnitBytes) + CommonUtil.getSumFromArr(content);
		byte[] bytesOut = null;
		if(content!=null) {
			bytesOut = CommonUtil.getListByte(headerBytes, controlBytes, addrBytes, afnOutBytes, seqOutBytes,
				dataUnitBytes, content, new byte[] { (byte) (sum % 256) }, new byte[] { END_VALUE });
		}
		else {
			bytesOut = CommonUtil.getListByte(headerBytes, controlBytes, addrBytes, afnOutBytes, seqOutBytes,
					dataUnitBytes, new byte[] { (byte) (sum % 256) }, new byte[] { END_VALUE });
		}
		return bytesOut;
	}
	
	public static byte[] getCqDownMessage(short length, byte control, byte commandCharacter, byte typeCharacter,
			byte[] content) {
		byte[] headerBytes = CommonUtil.getHeaderBytes(length);
		byte[] controlBytes = new byte[] { control };
		byte[] commandCharacterBytes = new byte[] { commandCharacter };
		byte[] typeCharacterBytes = new byte[] { typeCharacter };

		int sum = CommonUtil.getSumFromArr(controlBytes) + CommonUtil.getSumFromArr(commandCharacterBytes)
				+ CommonUtil.getSumFromArr(typeCharacterBytes) + CommonUtil.getSumFromArr(content);
		byte[] bytesOut = CommonUtil.getListByte(headerBytes, controlBytes, commandCharacterBytes, typeCharacterBytes,
				content, new byte[] { (byte) (sum % 256) }, new byte[] { END_VALUE });
		return bytesOut;
	}

	public static byte[] getReseaseArr(byte[] bytes) {
		byte[] out = new byte[bytes.length];
		for (int i = 0; i < bytes.length; i++) {
			out[bytes.length - 1 - i] = bytes[i];
		}
		return out;
	}
	
	public static byte[] reverseArray(byte[] Array) {
		byte[] new_array = new byte[Array.length];
		for (int i = 0; i < Array.length; i++) {
			// 反转后数组的第一个元素等于源数组的最后一个元素：
			new_array[i] = Array[Array.length - i - 1];
		}
		return new_array;
	}

	public static int getSumFromArr(byte[] arr) {
		int sum = 0;
		if (arr != null && arr.length > 0) {
			for (int i = 0; i < arr.length; i++) {
				sum += (arr[i] & BYTE_MAX);
			}
		}
		return sum;
	}

	
}

package com.abh.constants;

import org.apache.hadoop.hbase.util.Bytes;

public class Constants {

    /** 事件 */
    public static final String SESSION_EVENT = "SESSION_EVENT";

    /** 异常原因 */
    public static final String SESSION_EXCEPTION_CAUSE = "SESSION_EXCEPTION_CAUSE";

    /** 事件类型：建立链接 */
    public static final int SESSION_OPEN = 0;

    /** 事件类型：关闭连接 */
    public static final int SESSION_CLOSED = 1;

    /** 事件类型：链接异常 */
    public static final int SESSION_EXCEPTION = 2;

    /** 事件类型：接收数据 */
    public static final int MESSAGE_RECEIVED = 4;

    /** 常量 0 */
    public static final int CONSTANT_0 = 0;

    /** 常量 1 */
    public static final int CONSTANT_1 = 1;

    /** 常量2 */
    public static final int CONSTANT_2 = 2;

    /** 常量3 */
    public static final int CONSTANT_3 = 3;

    /** 常量4 */
    public static final int CONSTANT_4 = 4;

    /** 常量5 */
    public static final int CONSTANT_5 = 5;

    /** 常量6 */
    public static final int CONSTANT_6 = 6;

    /** 常量7 */
    public static final int CONSTANT_7 = 7;

    /** 常量8 */
    public static final int CONSTANT_8 = 8;

    /** 常量9 */
    public static final int CONSTANT_9 = 9;

    /** 常量10 */
    public static final int CONSTANT_10 = 10;

    /** 常量11 */
    public static final int CONSTANT_11 = 11;

    /** 常量12 */
    public static final int CONSTANT_12 = 12;

    /** 常量13 */
    public static final int CONSTANT_13 = 13;

    /** 常量14 */
    public static final int CONSTANT_14 = 14;

    /** 常量15 */
    public static final int CONSTANT_15 = 15;

    /** 常量16 */
    public static final int CONSTANT_16 = 16;

    /** 常量17 */
    public static final int CONSTANT_17 = 17;

    /** 常量18 */
    public static final int CONSTANT_18 = 18;

    /** 常量19 */
    public static final int CONSTANT_19 = 19;

    /** 常量20 */
    public static final int CONSTANT_20 = 20;

    /** 常量21 */
    public static final int CONSTANT_21 = 21;

    /** 常量22 */
    public static final int CONSTANT_22 = 22;

    /** 常量23 */
    public static final int CONSTANT_23 = 23;

    /** 常量24 */
    public static final int CONSTANT_24 = 24;

    /** 常量25 */
    public static final int CONSTANT_25 = 25;

    /** 常量26 */
    public static final int CONSTANT_26 = 26;

    /** 常量27 */
    public static final int CONSTANT_27 = 27;

    /** 常量28 */
    public static final int CONSTANT_28 = 28;

    /** 常量29 */
    public static final int CONSTANT_29 = 29;

    /** 常量30 */
    public static final int CONSTANT_30 = 30;

    /** 常量31 */
    public static final int CONSTANT_31 = 31;

    /** 常量32 */
    public static final int CONSTANT_32 = 32;

    /** 每日用水基本用量 */
    public static final int DAYWATERBASE = 50;

    /** 报文起始字符 */
    public static final int START_VALUE = 104;

    /** 报文结束字符 */
    public static final int END_VALUE = 22;

    /** 常量255 */
    public static final int BYTE_MAX = 0xff;

    /** 常量255 */
    public static final int SHORT_MAX = 0xffff;

    /** 协议类型 */
    public static final String PROTOCOLTYPE = "protocolType";

    /** 解析类的包路径 */
    public static final String BASE_PARSER_PACKAGE_PATH = "com.emrubik.iot.parser";

    /** 解析类的类名 */
    public static final String MESSAGEPARSER_CLASS_NAME = "MessageParser";

    /** 解析消息方法 */
    public static final String PARSEMESSAGE_METHOD_NAME = "parseMsg";

    /** 处理消息方法 */
    public static final String PROCESSMESSAGE_METHOD_NAME = "procMsg";

    /** 验证消息有效性方法 */
    public static final String VALIDATEMESSAGE_METHOD_NAME = "validMsg";

    /** 设备鉴权方法 */
    public static final String AUTHMESSAGE_METHOD_NAME = "authMsg";

    /** 阈值告警主题 */
    public static final String HELLOWORLDTOPIC = "helloworldTopic";

    public static final String ORIGIN = "1";

    /** 告警等级 */
    public static final String ALARM_LEVEL = "3";

    /** 组织机构ID */
    public static final String ORGID = "orgId";

    /** 设备类型 */
    public static final String TYPEID = "typeId";

    /** 设备名称 */
    public static final String DEVICENAME = "name";

    /******************************************** 公共 *********************************************/
    /** 数据 */
    public static final String SDATA = "sdata";

    /** 修改时间 */
    public static final String UPDATETIME = "updateTime";

    /** 设备码 */
    public static final String CDATE_CODE = "cdata.code";

    /** 设备码 */
    public static final String CODE = "code";

    /** 设备类型 */
    public static final String DEVICETYPE = "deviceType";

    /** 集中器IP */
    public static final String ADATA_IPADDR = "adata.ipAddr";

    /** 集中器在线状态 0-不在线 1-在线 */
    public static final String ONLINE = "online";

    /******************************************** Hbase *********************************************/
    /** 列族 */
    public static byte[] LZ = Bytes.toBytes("lz");

    /** 表名 */
    public static String IOT_WATER_HISTORY = "iot_water_history";

    /** ID */
    public static byte[] hId = Bytes.toBytes("id");

    /** 集中器地址 */
    public static byte[] hConAddr = Bytes.toBytes("hConAddr");

    /******************************************** 重庆智能 *********************************************/
    /** 累计流量单位 */
    public static final String SDATA_UNIT = "unit";

    /** 状态 */
    public static final String SDATA_STATE = "state";

    /** 水表读数 */
    public static final String SDATA_READING = "reading";

    /** 数据值 */
    public static byte[] hReading = Bytes.toBytes("reading");

    /** 采集时间 */
    public static byte[] hTime = Bytes.toBytes("time");

    /** 水表地址 */
    public static byte[] hMeterAddr = Bytes.toBytes("hmeterAddr");

    /** 冻结日期 */
    public static byte[] hFreezeDate = Bytes.toBytes("hFreezeDate");

    /** 表类型 */
    public static byte[] hMeterType = Bytes.toBytes("hMeterType");

    /** 数据项 */
    public static byte[] hDataItem = Bytes.toBytes("hDataItem");

    /** 抄表时间 */
    public static byte[] hReadingTime = Bytes.toBytes("hReadingTime");

    /******************************************** 捷先 *********************************************/
    /** 采集器TN号 */
    public static final String SDATE_JX_COLLECTOR_TNNO = "collectorTNNo";

    /** 表TN号 */
    public static final String SDATE_JX_WATERMETER_TNNO = "waterMeterTNNo";

    /** 表读数 */
    public static final String SDATE_JX_READING = "reading";

    /** 阀门状态 */
    public static final String SDATE_JX_VALVE_STATE = "valveState";

    /** 采集器TN号 */
    public static final byte[] HCOLLECTORTNNO = Bytes.toBytes("hCollectorTNNo");

    /** 表TN号 */
    public static final byte[] HWATERMETERTNNO = Bytes.toBytes("hWaterMeterTNNo");

    /** 表读数 */
    public static final byte[] HREADING = Bytes.toBytes("hReading");

    /** 阀门状态 */
    public static final byte[] HVALVESTATE = Bytes.toBytes("hValveState");

    /******************************************** 新天 *********************************************/
    /** 采集器通信地址 */
    public static final String SDATE_XT_COLLECTOR_ADDRESS = "collectorAddress";

    /** 表底数 */
    public static final String SDATE_XT_WATERMETER_READING = "value";

    /** 表状态 */
    public static final String SDATE_XT_STATE = "state";

    /** 抄表时间 */
    public static final String SDATE_XT_READING_TIME = "readingTime";

    /** 冻结日期 */
    public static final String SDATE_XT_FREEZE_DATE = "freezeDate";

    /** 表类型 */
    public static final String SDATE_XT_WATERMETER_TYPE = "meterType";

    /** 数据项 */
    public static final String SDATE_XT_DATA_ITEM = "dataItem";

}

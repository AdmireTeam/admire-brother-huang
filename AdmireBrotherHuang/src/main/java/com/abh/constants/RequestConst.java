package com.abh.constants;

import java.io.*;
import java.util.PropertyResourceBundle;
import java.util.ResourceBundle;

/**
 * Created by zqc on 2017/7/20.
 */
public class RequestConst {


    static  {
        ResourceBundle resourceBundle;
        Reader in;
        try {
            in = new InputStreamReader(new BufferedInputStream(new FileInputStream(new File(System.getProperty("user.dir")
                    + "/request.properties"))),"UTF-8");
            resourceBundle = new PropertyResourceBundle(in);
            in.close();

            HedaHost = resourceBundle.getString("HedaHost");
            HedaPort = Integer.valueOf(resourceBundle.getString("HedaPort"));
            HedaNumber = resourceBundle.getString("HedaNumber");
            HedaK4 = resourceBundle.getString("HedaK4");
            HedaK5 = resourceBundle.getString("HedaK5");
            HedaA1 = resourceBundle.getString("HedaA1");
            HedaA2 = resourceBundle.getString("HedaA2");
            HedaA3 = resourceBundle.getString("HedaA3");
            HedaA12 = resourceBundle.getString("HedaA12");
            HedaA13 = resourceBundle.getString("HedaA13");
            HedaP2 = resourceBundle.getString("HedaP2");
            HedaP13 = resourceBundle.getString("HedaP13");
            HedaP14 = resourceBundle.getString("HedaP14");


            MtConAddress=resourceBundle.getString("MtConAddress");
            MtWaterNum=resourceBundle.getString("MtWaterNum");
            MtAccumulate1=resourceBundle.getString("MtAccumulate1");
            MtAccumulate2=resourceBundle.getString("MtAccumulate2");
            MtInstantFlow=resourceBundle.getString("MtInstantFlow");
            MtTime=resourceBundle.getString("MtTime");
            MtPort=Integer.valueOf(resourceBundle.getString("MtPort"));


            RolaPort = Integer.valueOf(resourceBundle.getString("RolaPort"));
            RolaConAddress= String.valueOf(Integer.parseInt(resourceBundle.getString("RolaConAddress")));
            RolaWaterNum= String.valueOf(Integer.parseInt(resourceBundle.getString("RolaWaterNum")));
            RolaReading= String.valueOf(Integer.parseInt(resourceBundle.getString("RolaReading")));

            JxconAddr=String.valueOf(Integer.parseInt(resourceBundle.getString("JxConAddr")));
            Jxreading=String.valueOf(Integer.parseInt(resourceBundle.getString("Jxreading")));
            JxconCount=Integer.valueOf(resourceBundle.getString("JxconCount"));
            JxmeterCount=Integer.valueOf(resourceBundle.getString("JxmeterCount"));
            JxPort=Integer.valueOf(resourceBundle.getString("JxPort"));

            XtconAddr=resourceBundle.getString("XtconAddr");
            XtconCount=Integer.valueOf(resourceBundle.getString("XtconCount"));
            XtmeterCount=Integer.valueOf(resourceBundle.getString("XtmeterCount"));
            Xtreading=resourceBundle.getString("Xtreading");
            XtPort=Integer.valueOf(resourceBundle.getString("XtPort"));
            XtMeterStartAddr=resourceBundle.getString("XtMeterStartAddr");

            SciotPort = Integer.valueOf(resourceBundle.getString("SciotPort"));
            SciotWaterNum= String.valueOf(Long.parseLong(resourceBundle.getString("SciotWaterNum")));
            SciotReading= String.valueOf(Double.parseDouble(resourceBundle.getString("SciotReading")));
            SciotStartDate= String.valueOf(Long.parseLong(resourceBundle.getString("SciotStartDate")));


        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }


    }

    public static String HedaHost;
    public static int HedaPort;
    public static String HedaNumber;
    public static String HedaK4;
    public static String HedaK5;
    public static String HedaA1;
    public static String HedaA2;
    public static String HedaA3;
    public static String HedaA12;
    public static String HedaA13;
    public static String HedaP2;
    public static String HedaP13;
    public static String HedaP14;
    public static String MtConAddress;
    public static String MtWaterNum;
    public static String MtAccumulate1;
    public static String MtAccumulate2;
    public static String MtInstantFlow;
    public static String MtTime;
    public static int MtPort;

    public static String RolaConAddress;
    public static String RolaWaterNum;
    public static String RolaReading;
    public static int RolaPort;

    public static String JxconAddr;
    public static int JxconCount;
    public static int JxmeterCount;
    public static String Jxreading;
    public static int JxPort;

    public static String XtconAddr;
    public static int XtconCount;
    public static int XtmeterCount;
    public static String Xtreading;
    public static int XtPort;
    public static String XtMeterStartAddr;

    public static String SciotStartDate;
    public static String SciotWaterNum;
    public static String SciotReading;
    public static int SciotPort;

}

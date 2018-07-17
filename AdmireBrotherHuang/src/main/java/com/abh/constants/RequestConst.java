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


}
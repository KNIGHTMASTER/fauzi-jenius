package com.wissensalt.rnd.fj.util.date;

import java.text.SimpleDateFormat;

/**
 * Created on 12/11/18.
 *
 * @author <a href="mailto:fauzi.knightmaster.achmad@gmail.com">Achmad Fauzi</a>
 */
public class FormatDateConstant {

    public static final String FORMAT_BIRTH_DATE = "dd-mm-yyyy";
    public static final String FORMAT_GENERAL = "dd-MM-yyyy hh:mm:ss";
    public static final String FORMAT_ISO_8601 = "dd-MM-yyyy'T'hh:mm:ss:SSSX";
    public static final String FORMAT_ISO_8601_2 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";
    public static final String FORMAT_ISO_8601_3 = "yyyy-MM-dd hh:mm:ss Z";
    public static final String FORMAT_ISO_8601_4 = "yyyy-MM-dd'T'hh:mm:ss'Z'";
    public static final String FORMAT_DATE = "yyyy-MM-dd";
    public static final String FORMAT_STANDARD_TIME = "hh:mm:ss Z";

    public static SimpleDateFormat BIRTH_DATE = new SimpleDateFormat(FORMAT_BIRTH_DATE);
    public static SimpleDateFormat GENERAL = new SimpleDateFormat(FORMAT_GENERAL);
    public static SimpleDateFormat ISO_8601 = new SimpleDateFormat(FORMAT_ISO_8601);
    public static SimpleDateFormat ISO_8601_2 = new SimpleDateFormat(FORMAT_ISO_8601_2);
    public static SimpleDateFormat ISO_8601_3 = new SimpleDateFormat(FORMAT_ISO_8601_3);
    public static SimpleDateFormat ISO_8601_4 = new SimpleDateFormat(FORMAT_ISO_8601_4);
    public static SimpleDateFormat DATE = new SimpleDateFormat(FORMAT_DATE);
    public static SimpleDateFormat STANDARD_TIME = new SimpleDateFormat(FORMAT_STANDARD_TIME);
}

package com.arfan.auth.enums;

public enum Constants {
    ;

    private Constants() {
        throw new IllegalStateException("Utility class");
    }

    public static final String FORMAT_DATE_YYYYMMDD_1 = "yyyy-MM-dd";
    public static final String FORMAT_DATE_YYYYMMDD_2 = "yyyyMMdd";
    public static final String FORMAT_DATE_YYYYMMDD_3 = "yyyy/MM/dd";
    public static final String FORMAT_DATE_YYYYMMDD_4 = "yyyy-MM-dd HH:mm:ss.SSSSSS";
    public static final String FORMAT_DATE_YYYYMMDD_5 = "yyyy-MM-dd'T'HH:mm:ss";
    public static final String FORMAT_DATE_YYYYMMDD_6 = "yyyy-MM-dd HH:mm:ss";


    /* Status HTTP */
    public static final int OK = 200;
    public static final int BAD_REQUEST = 400;
    public static final int INTERNAL_SERVER_ERROR = 500;
    public static final String MESSAGE = "message";

    /* Status HTTP */
    public static final String GLB_MESSAGE_SUCCESS = "Success !";
    public static final String GLB_MESSAGE_FAILED = "Failed !";
    public static final String GLB_MESSAGE_FOUND = "Data Found !";
    public static final String GLB_MESSAGE_NOT_FOUND = "Data Not Found !";
}

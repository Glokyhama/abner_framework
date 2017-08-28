package com.abner.util;

public final class CoreUtil {


    public static String createUid(String identityType){



        //"#{client_type}#{CaiQiuSupport::CaiQiuTime.get_value_of_time}#{CaiQiuSupport::CaiQiuUtils.get_random(9)}"

        // uid的格式是“2位客户端类型（右补零）”+“13位的时间串”+“9位随机数”
        StringBuilder uid = new StringBuilder(identityType);
        uid.append(DateUtil.getCurrentTimeMillis());



        return null;

    }
}

package com.quocbao.tests.helpers;

import java.io.File;

public class SystemHelper {
    public static String getCurrentDir(){
        return System.getProperty("user.dir")+File.separator;
    }
}

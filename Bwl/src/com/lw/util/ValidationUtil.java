package com.lw.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    // ʹ��������ʽУ�����ڸ�ʽ
    public static boolean validateTimeFormat(String memotime) {
        Pattern pattern = Pattern.compile("[12](\\d){3}-[01](\\d)-[0123](\\d)");
        Matcher matcher = pattern.matcher(memotime);
        if (matcher.matches() && (!memotime.contains("-00"))) {
            return true;
        } else {
            return false;
        }
    }
}

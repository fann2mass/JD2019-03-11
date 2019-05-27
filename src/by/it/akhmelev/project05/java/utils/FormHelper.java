package by.it.akhmelev.project05.java.utils;

import javax.servlet.http.HttpServletRequest;

public class FormHelper {
    public static boolean isPost(HttpServletRequest req) {
        return req.getMethod().equalsIgnoreCase("POST");
    }
}

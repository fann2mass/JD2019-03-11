package by.it.akhmelev.project05.java.utils;

import by.it.akhmelev.project05.java.exceptions.SiteException;

import javax.servlet.http.HttpServletRequest;

public class Validator {


    public static String getString(HttpServletRequest req, String name) {
        return getString(req,name,".*");
    }

    public static String getString(HttpServletRequest req, String name, String pattern) {
        String value = req.getParameter(name);
        if (value.matches(pattern))
            return value;
        throw new SiteException("Incorrect value of " + name);
    }


    public static int getInt(HttpServletRequest req, String name){
        try {
            return Integer.parseInt(req.getParameter(name));
        }
        catch (Exception e){
            throw new SiteException("Incorrect value of " + name, e);
        }
    }

    public static double getDouble(HttpServletRequest req, String name){
        try {
            return Double.parseDouble(req.getParameter(name));
        }
        catch (Exception e){
            throw new SiteException("Incorrect value of " + name, e);
        }
    }

    public static long getLong(HttpServletRequest req, String name){
        try {
            return Long.parseLong(req.getParameter(name));
        }
        catch (Exception e){
            throw new SiteException("Incorrect value of " + name, e);
        }
    }
}

package com.bsoftwares.login_car.Utils;

public class Values {

    private static String TOKEN;
    private static int CURRENT_CAR_ID;

    public static int getCURRENT_CAR_ID() {
        return CURRENT_CAR_ID;
    }
    public static void setCURRENT_CAR_ID(int currentCarId) {
        CURRENT_CAR_ID = currentCarId;
    }
    public static int PREF_SECURITY(){
        return 0;
    }
    public static String PREF_NAME(){
        return "MainPref";
    }
    public static String getTOKEN() {
        return TOKEN;
    }
    public static void setTOKEN(String TOKEN) {
        Values.TOKEN = TOKEN;
    }

}

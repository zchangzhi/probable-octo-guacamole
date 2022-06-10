package com.coolweather.weixin;

public class ItemBean {
    private String userName;
    private String Msg;
    private int imgId;

    public String getUserName() {
        return userName;
    }

    public String getMsg() {
        return Msg;
    }

    public int getImgId() {
        return imgId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setMsg(String msg) {
        Msg = msg;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public ItemBean(String userName, String msg, int imgId) {
        this.userName = userName;
        Msg = msg;
        this.imgId = imgId;
    }
}

package com.buzzbites.instaconadmin.data.response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseCallValue {
    @SerializedName("protocol")
    @Expose
    private Object protocol;
    @SerializedName("code")
    @Expose
    private Object code;

    @SerializedName("message")
    @Expose
    private Object message;

    @SerializedName("url")
    @Expose
    private Object url;

    public Object getProtocol() {
        return protocol;
    }

    public void setProtocol(Object protocol) {
        this.protocol = protocol;
    }

    public Object getCode() {
        return code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getMessage() {
        return message;
    }

    public void setMessage(Object message) {
        this.message = message;
    }

    public Object getUrl() {
        return url;
    }

    public void setUrl(Object url) {
        this.url = url;
    }
}

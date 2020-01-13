package com.daleondeveloper.swordartonline_site.security.jwt;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.tomcat.util.codec.binary.Base64;

import java.io.UnsupportedEncodingException;

public class JwtTokenDecode {
    public String email;

    public static JwtTokenDecode getDecoded(String encodedToken) throws UnsupportedEncodingException {
        String[] pieces = encodedToken.split("\\.");
        String b64payload = pieces[1];
        String jsonString = new String(Base64.decodeBase64(b64payload), "UTF-8");

        return new Gson().fromJson(jsonString, JwtTokenDecode.class);
    }

    public String toString() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return gson.toJson(this);
    }
}

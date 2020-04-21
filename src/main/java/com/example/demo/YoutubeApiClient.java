package com.example.demo;

import javax.net.ssl.HttpsURLConnection;
import java.io.*;
import java.net.URL;

public class YoutubeApiClient {
    public String youtubeApiClient (String param, String path) {
        HttpsURLConnection uc;
        try {
            URL url = new URL(path+param);
            uc = (HttpsURLConnection) url.openConnection();
            uc.setRequestMethod("GET");
            uc.setUseCaches(false);
            uc.setDoOutput(true);
            //uc.setRequestProperty("Content-Type", "application/json");
/*

            OutputStreamWriter out = new OutputStreamWriter(
                    new BufferedOutputStream(uc.getOutputStream()));
            out.write();
            out.close();
*/

            BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream()));
            String line = in.readLine();
            String body = "";
            while (line != null) {
                body = body + line;
                line = in.readLine();
            }
            uc.disconnect();
            return body;

        } catch (IOException e) {
            e.printStackTrace();
            return "client - IOException : " + e.getMessage();
        }
    }
}

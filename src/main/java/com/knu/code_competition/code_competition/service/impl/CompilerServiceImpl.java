package com.knu.code_competition.code_competition.service.impl;

import com.knu.code_competition.code_competition.model.CompilerModel;
import com.knu.code_competition.code_competition.service.CompilerService;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Service
public class CompilerServiceImpl implements CompilerService {
    String url = "https://api.jdoodle.com/v1/execute";
    private String clientId = "d319f05187f61a1ba0f2d4b5908f96ed";
        private String clientSecret = "ae482e79fec907d28dab2e300e4a3949933c33bb18940b92cc5af6645d218604";
    @Override
    public String executeCode(CompilerModel compilerModel) {
        return run(compilerModel);
    }
    private String run(CompilerModel compilerModel){
        HttpURLConnection connection = null;
        OutputStream outputStream = null;
        JSONObject json = null;
        String jsonText = "";
        try {
            URL url = new URL("https://api.jdoodle.com/v1/execute");
            connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");

            String input = "{\"clientId\": \"" + clientId + "\",\"clientSecret\":\"" + clientSecret + "\",\"script\":\"" + compilerModel.getScript() +
                    "\",\"language\":\"" + compilerModel.getLanguage() + "\",\"versionIndex\":\"" + compilerModel.getVersionIndex() + "\"} ";

            System.out.println(input);

            outputStream = connection.getOutputStream();
            outputStream.write(input.getBytes());
            outputStream.flush();

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RuntimeException("Please check your inputs : HTTP error code : "+ connection.getResponseCode());
            }

            BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream(), StandardCharsets.UTF_8));
            jsonText = readAll(rd);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.disconnect();
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return jsonText;
    }
    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }
}

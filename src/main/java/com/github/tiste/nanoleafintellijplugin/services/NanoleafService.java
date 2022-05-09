package com.github.tiste.nanoleafintellijplugin.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tiste.nanoleafintellijplugin.settings.ApplicationState;
import com.intellij.openapi.components.ServiceManager;
import okhttp3.*;

import java.io.IOException;

public class NanoleafService {
    public static final MediaType TEXT = MediaType.get("text/plain; charset=utf-8");
    final OkHttpClient client = new OkHttpClient();

    public static NanoleafService getInstance() {
        return ServiceManager.getService(NanoleafService.class);
    }

    public String[] fetchEffects() throws IOException {
        ApplicationState settings = ApplicationState.getInstance();

        ObjectMapper mapper = new ObjectMapper();
        Request request = new Request.Builder()
                .url("http://" + settings.ipAddress + "/api/v1/" + settings.apiKey + "/effects/effectsList")
                .build();

        Response response = client.newCall(request).execute();

        return mapper.readValue(response.body().byteStream(), String[].class);
    }

    public String fetchCurrentEffect() throws IOException {
        ApplicationState settings = ApplicationState.getInstance();

        ObjectMapper mapper = new ObjectMapper();
        Request request = new Request.Builder()
                .url("http://" + settings.ipAddress + "/api/v1/" + settings.apiKey + "/effects/select")
                .build();

        Response response = client.newCall(request).execute();

        return mapper.readValue(response.body().byteStream(), String.class);
    }

    public void setTestPassed(boolean passed) throws IOException {
        ApplicationState settings = ApplicationState.getInstance();

        RequestBody body = RequestBody.create("{\"select\" : \"Jungle\"}", TEXT);
        Request request = new Request.Builder()
                .url("http://" + settings.ipAddress + "/api/v1/" + settings.apiKey + "/effects")
                .put(body)
                .build();
        client.newCall(request).execute();

        if (passed) {
            System.out.println("Passé");
            System.out.println(settings.ipAddress);
        } else {
            System.out.println("Pas passé");
            System.out.println(settings.apiKey);
        }
    }
}

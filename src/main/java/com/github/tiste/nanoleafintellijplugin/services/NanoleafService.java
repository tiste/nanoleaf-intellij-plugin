package com.github.tiste.nanoleafintellijplugin.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tiste.nanoleafintellijplugin.settings.ApplicationState;
import com.intellij.openapi.components.ServiceManager;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

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

    public String getNewApiKey() throws IOException {
        ApplicationState settings = ApplicationState.getInstance();

        ObjectMapper mapper = new ObjectMapper();
        Request request = new Request.Builder()
                .url("http://" + settings.ipAddress + "/api/v1/new")
                .post(RequestBody.create(new byte[]{}, null))
                .build();

        Response response = client.newCall(request).execute();

        return mapper.readValue(response.body().string(), AuthTokenEntity.class).getAuthToken();
    }

    public void setTestPassed(boolean passed) throws IOException {
        ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(5);
        ApplicationState settings = ApplicationState.getInstance();
        String currentEffect = this.fetchCurrentEffect();

        if (passed) {
            this.setEffect(settings.greenEffect);
        } else {
            this.setEffect(settings.redEffect);
        }

        exec.schedule(new Runnable() {
            public void run() {
                try {
                    setEffect(currentEffect);
                } catch (IOException e) {
                    System.out.println("Failed to update to previous effect");
                    System.out.println(e);
                }
            }
        }, 3, TimeUnit.SECONDS);
    }

    private String fetchCurrentEffect() throws IOException {
        ApplicationState settings = ApplicationState.getInstance();

        ObjectMapper mapper = new ObjectMapper();
        Request request = new Request.Builder()
                .url("http://" + settings.ipAddress + "/api/v1/" + settings.apiKey + "/effects/select")
                .build();

        Response response = client.newCall(request).execute();

        return mapper.readValue(response.body().byteStream(), String.class);
    }

    private void setEffect(String effect) throws IOException {
        ApplicationState settings = ApplicationState.getInstance();

        RequestBody body = RequestBody.create("{\"select\" : \"" + effect + "\"}", TEXT);
        Request request = new Request.Builder()
                .url("http://" + settings.ipAddress + "/api/v1/" + settings.apiKey + "/effects")
                .put(body)
                .build();
        client.newCall(request).execute();
    }
}

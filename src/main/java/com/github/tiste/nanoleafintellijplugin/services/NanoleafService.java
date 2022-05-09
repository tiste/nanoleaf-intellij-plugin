package com.github.tiste.nanoleafintellijplugin.services;

import com.github.tiste.nanoleafintellijplugin.settings.ApplicationState;
import com.intellij.openapi.components.ServiceManager;

public class NanoleafService {
    public static NanoleafService getInstance() {
        return ServiceManager.getService(NanoleafService.class);
    }

    public void setTestPassed(boolean passed) {
        ApplicationState settings = ApplicationState.getInstance();

        if (passed) {
            System.out.println("Passé");
            System.out.println(settings.ipAddress);
        } else {
            System.out.println("Pas passé");
            System.out.println(settings.apiKey);
        }
    }
}

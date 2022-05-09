package com.github.tiste.nanoleafintellijplugin.settings;

import com.github.tiste.nanoleafintellijplugin.services.NanoleafService;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.IOException;

public class ApplicationConfigurable implements Configurable {
    private SettingsComponent settingsComponent;

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Nanoleaf";
    }

    @Override
    public @Nullable JComponent createComponent() {
        NanoleafService nanoleafService = NanoleafService.getInstance();
        ApplicationState settings = ApplicationState.getInstance();
        String[] effects = new String[]{};

        try {
            if (!settings.ipAddress.isEmpty() && !settings.apiKey.isEmpty()) {
                effects = nanoleafService.fetchEffects();
            }
        } catch (IOException e) {
            System.out.println("Fail to fetch effects");
        }
        settingsComponent = new SettingsComponent(effects);
        return settingsComponent.getPanel();
    }

    @Override
    public boolean isModified() {
        ApplicationState settings = ApplicationState.getInstance();

        return !settings.ipAddress.equals(settingsComponent.getIpAddress()) || !settings.apiKey.equals(settingsComponent.getApiKey());
    }

    @Override
    public void apply() {
        ApplicationState settings = ApplicationState.getInstance();

        settings.ipAddress = settingsComponent.getIpAddress();
        settings.apiKey = settingsComponent.getApiKey();
    }

    @Override
    public void reset() {
        settingsComponent.reset();
    }

    @Override
    public void disposeUIResources() {
        settingsComponent = null;
    }
}

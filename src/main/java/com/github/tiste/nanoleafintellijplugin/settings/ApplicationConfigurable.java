package com.github.tiste.nanoleafintellijplugin.settings;

import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.util.NlsContexts;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class ApplicationConfigurable implements Configurable {
    private SettingsComponent settingsComponent;

    @Override
    public @NlsContexts.ConfigurableName String getDisplayName() {
        return "Nanoleaf";
    }

    @Override
    public @Nullable JComponent createComponent() {
        settingsComponent = new SettingsComponent();
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

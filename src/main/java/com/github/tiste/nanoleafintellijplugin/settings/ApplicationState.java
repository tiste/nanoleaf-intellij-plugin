package com.github.tiste.nanoleafintellijplugin.settings;

import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@State(
        name = "com.github.tiste.nanoleafintellijplugin.settings.ApplicationState",
        storages = {@Storage("NanoleafSettingsPlugin.xml")}
)
public class ApplicationState implements PersistentStateComponent<ApplicationState> {
    public String ipAddress = "";
    public String apiKey = "";

    @Nullable
    @Override
    public ApplicationState getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull ApplicationState state) {
        XmlSerializerUtil.copyBean(state, this);
    }

    public static ApplicationState getInstance() {
        return ServiceManager.getService(ApplicationState.class);
    }
}

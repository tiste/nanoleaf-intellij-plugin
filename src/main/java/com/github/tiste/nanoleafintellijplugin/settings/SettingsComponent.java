package com.github.tiste.nanoleafintellijplugin.settings;

import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;

import javax.swing.*;

public class SettingsComponent {
    private final JPanel mainPanel;
    private final JBTextField ipAddress = new JBTextField("0.0.0.0");
    private final JBTextField apiKey = new JBTextField("");

    public SettingsComponent() {
        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Enter Nanoleaf IP address: "), ipAddress, 1, false)
                .addLabeledComponent(new JBLabel("Enter Nanoleaf API key: "), apiKey, 1, false)
                .addSeparator()
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();
    }

    public JPanel getPanel() {
        return mainPanel;
    }

    public JComponent getPreferredFocusedComponent() {
        return ipAddress;
    }

    public String getIpAddress() {
        return ipAddress.getText();
    }

    public String getApiKey() {
        return apiKey.getText();
    }

    public void reset() {
        ApplicationState settings = ApplicationState.getInstance();

        ipAddress.setText(settings.ipAddress);
        apiKey.setText(settings.apiKey);
    }
}

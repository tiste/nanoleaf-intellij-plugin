package com.github.tiste.nanoleafintellijplugin.settings;

import com.github.tiste.nanoleafintellijplugin.services.NanoleafService;
import com.intellij.openapi.ui.ComboBox;
import com.intellij.ui.components.JBLabel;
import com.intellij.ui.components.JBTextField;
import com.intellij.util.ui.FormBuilder;

import javax.swing.*;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;
import java.io.IOException;

public class SettingsComponent {
    private final JPanel mainPanel;
    private final JBTextField ipAddress = new JBTextField("");
    private final JBTextField apiKey = new JBTextField("");
    private final ComboBox<String> redEffects = new ComboBox<>();
    private final ComboBox<String> greenEffects = new ComboBox<>();

    public SettingsComponent() {
        mainPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent(new JBLabel("Enter Nanoleaf IP address (form 192.168.x.x:16021): "), ipAddress, 1, false)
                .addLabeledComponent(new JBLabel("Enter Nanoleaf API key: "), apiKey, 1, false)
                .addSeparator()
                .addLabeledComponent(new JBLabel("Select red effect"), redEffects, 1, false)
                .addLabeledComponent(new JBLabel("Select green effect"), greenEffects, 1, false)
                .addSeparator()
                .addComponentFillVertically(new JPanel(), 0)
                .getPanel();

        redEffects.addPopupMenuListener(this.getEffectsPopupMenu());
        greenEffects.addPopupMenuListener(this.getEffectsPopupMenu());
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

    public String getRedEffect() {
        return redEffects.getItem();
    }

    public String getGreenEffect() {
        return greenEffects.getItem();
    }

    public void reset() {
        ApplicationState settings = ApplicationState.getInstance();

        ipAddress.setText(settings.ipAddress);
        apiKey.setText(settings.apiKey);
        redEffects.setItem(settings.redEffect);
        greenEffects.setItem(settings.greenEffect);
    }

    private PopupMenuListener getEffectsPopupMenu() {
        return new PopupMenuListener() {
            @Override
            public void popupMenuWillBecomeVisible(PopupMenuEvent popupMenuEvent) {
                JComboBox<String> comboBox = (JComboBox<String>) popupMenuEvent.getSource();

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

                comboBox.setModel(new DefaultComboBoxModel<>(effects));
            }

            @Override
            public void popupMenuWillBecomeInvisible(PopupMenuEvent popupMenuEvent) {

            }

            @Override
            public void popupMenuCanceled(PopupMenuEvent popupMenuEvent) {

            }
        };
    }
}

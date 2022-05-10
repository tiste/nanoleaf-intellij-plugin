package com.github.tiste.nanoleafintellijplugin.listeners;

import com.github.tiste.nanoleafintellijplugin.services.NanoleafService;
import com.intellij.execution.testframework.AbstractTestProxy;
import com.intellij.execution.testframework.TestStatusListener;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

public class TestSuiteListener extends TestStatusListener {
    @Override
    public void testSuiteFinished(@Nullable AbstractTestProxy root) {
        if (root != null && !root.isDefect()) {
            try {
                NanoleafService.getInstance().setTestPassed(root.isPassed());
            } catch (IOException e) {
                System.out.println("Failed to update test passed");
            }
        }
    }
}

package com.github.tiste.nanoleafintellijplugin.listeners;

import com.github.tiste.nanoleafintellijplugin.services.NanoleafService;
import com.intellij.execution.testframework.AbstractTestProxy;
import com.intellij.execution.testframework.TestStatusListener;
import org.jetbrains.annotations.Nullable;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class TestSuiteListener extends TestStatusListener {
    private LocalDateTime lastRun = LocalDateTime.now();
    private int numberOfRun = 0;

    @Override
    public void testSuiteFinished(@Nullable AbstractTestProxy root) {
        long diff = ChronoUnit.SECONDS.between(lastRun, LocalDateTime.now());

        if (root != null) {
            boolean isFirstRunOrDebounce = numberOfRun == 0 || diff > 0;

            if (isFirstRunOrDebounce) {
                NanoleafService.getInstance().setTestPassed(root.isPassed());
            }
        }

        lastRun = LocalDateTime.now();
        numberOfRun++;
    }
}

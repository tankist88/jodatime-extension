package com.github.tankist88.extension.jodatime;

import com.github.tankist88.object2source.SourceGenerator;
import com.github.tankist88.object2source.dto.ProviderResult;
import org.joda.time.PeriodType;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class PeriodTypeExtensionTest {
    @Test
    public void periodTypeTest() {
        SourceGenerator sg = new SourceGenerator();
        sg.registerExtension(new PeriodTypeExtension());
        ProviderResult pr = sg.createDataProviderMethod(PeriodType.yearMonthDay());
        assertTrue(pr.getEndPoint().getMethodBody().contains("return org.joda.time.PeriodType.yearMonthDay();"));
    }
}

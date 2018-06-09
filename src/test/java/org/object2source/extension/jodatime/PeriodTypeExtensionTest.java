package org.object2source.extension.jodatime;

import org.joda.time.PeriodType;
import org.object2source.SourceGenerator;
import org.object2source.dto.ProviderResult;
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

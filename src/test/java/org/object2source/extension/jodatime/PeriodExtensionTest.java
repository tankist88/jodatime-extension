package org.object2source.extension.jodatime;

import org.joda.time.DateTime;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.object2source.SourceGenerator;
import org.object2source.dto.ProviderResult;
import org.testng.annotations.Test;

import java.util.Calendar;

import static org.testng.Assert.assertTrue;

public class PeriodExtensionTest {
    @Test
    public void periodTest() {
        SourceGenerator sg = new SourceGenerator();
        sg.registerExtension(new PeriodTypeExtension());
        sg.registerExtension(new PeriodExtension());
        sg.registerExtension(new DateTimeExtension());

        Calendar cal1 = Calendar.getInstance();
        cal1.add(Calendar.YEAR, -2);
        cal1.getTime();

        Calendar cal2 = Calendar.getInstance();
        cal2.getTime();

        Period period = new Period(new DateTime(cal1), new DateTime(cal2), PeriodType.yearMonthDay());
        ProviderResult pr = sg.createDataProviderMethod(period);

        assertTrue(pr.getEndPoint().getMethodBody().contains("return new org.joda.time.Period(2, 0, 0, 0, 0, 0, 0, 0, getPeriodType_1671551597());"));
    }
}

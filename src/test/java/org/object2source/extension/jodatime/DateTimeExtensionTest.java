package org.object2source.extension.jodatime;

import org.joda.time.DateTime;
import org.object2source.SourceGenerator;
import org.object2source.dto.ProviderResult;
import org.testng.annotations.Test;

import java.util.Calendar;

import static org.testng.Assert.assertTrue;

public class DateTimeExtensionTest {
    @Test
    public void dateTimeTest() {
        Calendar calendar = Calendar.getInstance();
        SourceGenerator sg = new SourceGenerator();
        sg.registerExtension(new DateTimeExtension());
        ProviderResult pr = sg.createDataProviderMethod(new DateTime(calendar));
        assertTrue(
                pr.getEndPoint().getMethodBody().contains("" +
                        "return new org.joda.time.DateTime(getCalendarInstance(" +
                        "\"" + calendar.getTimeZone().getID() + "\", " +
                        "" + calendar.getTimeInMillis() + "L));"
                )
        );
    }
}

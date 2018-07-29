package com.github.tankist88.extension.jodatime;

import com.github.tankist88.object2source.dto.ProviderInfo;
import com.github.tankist88.object2source.dto.ProviderResult;
import com.github.tankist88.object2source.extension.AbstractEmbeddedExtension;
import org.joda.time.Period;

import java.util.Set;

public class PeriodExtension extends AbstractEmbeddedExtension {
    @Override
    public boolean isTypeSupported(Class<?> clazz) {
        return clazz.equals(org.joda.time.Period.class);
    }

    @Override
    public void fillMethodBody(StringBuilder bb, Set<ProviderInfo> providers, int objectDepth, Object obj) throws Exception {
        Period value = (Period) obj;

        int years = value.getYears();
        int months = value.getMonths();
        int weeks = value.getWeeks();
        int days = value.getDays();
        int hours = value.getHours();
        int minutes = value.getMinutes();
        int seconds = value.getSeconds();
        int millis = value.getMillis();

        ProviderResult generatedPeriodType = sourceGenerator.createDataProviderMethod(value.getPeriodType());

        providers.addAll(generatedPeriodType.getProviders());

        bb  .append(getTabSymb()).append(getTabSymb()).append("return new org.joda.time.Period(")
            .append(years).append(", ")
            .append(months).append(", ")
            .append(weeks).append(", ")
            .append(days).append(", ")
            .append(hours).append(", ")
            .append(minutes).append(", ")
            .append(seconds).append(", ")
            .append(millis).append(", ")
            .append(generatedPeriodType.getEndPoint().getMethodName())
            .append(");\n");
    }

    @Override
    public String getActualType(Object obj) {
        return org.joda.time.Period.class.getName();
    }
}

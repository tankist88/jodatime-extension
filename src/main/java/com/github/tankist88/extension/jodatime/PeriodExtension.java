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
    public boolean isFillingSupported() {
        return false;
    }

    @Override
    public String getMethodBody(Set<ProviderInfo> providers, int objectDepth, Object obj, boolean fillObj) {
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

        return getTabSymb() + getTabSymb() +
                "return new org.joda.time.Period(" +
                years + ", " +
                months + ", " +
                weeks + ", " +
                days + ", " +
                hours + ", " +
                minutes + ", " +
                seconds + ", " +
                millis + ", " +
                generatedPeriodType.getEndPoint().getMethodName() + ");\n";
    }

    @Override
    public String getActualType(Object obj) {
        return org.joda.time.Period.class.getName();
    }
}

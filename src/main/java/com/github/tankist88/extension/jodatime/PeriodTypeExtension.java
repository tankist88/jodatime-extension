package com.github.tankist88.extension.jodatime;

import com.github.tankist88.object2source.dto.ProviderInfo;
import com.github.tankist88.object2source.extension.AbstractEmbeddedExtension;
import org.joda.time.PeriodType;

import java.util.Set;

import static com.github.tankist88.object2source.util.GenerationUtil.downFirst;

public class PeriodTypeExtension extends AbstractEmbeddedExtension {
    @Override
    public boolean isTypeSupported(Class<?> clazz) {
        return clazz.equals(org.joda.time.PeriodType.class);
    }

    @Override
    public boolean isFillingSupported() {
        return false;
    }

    @Override
    public String getMethodBody(Set<ProviderInfo> providers, int objectDepth, Object obj, boolean fillObj) {
        PeriodType value = (PeriodType) obj;
        return getTabSymb() + getTabSymb() + "return org.joda.time.PeriodType." + downFirst(value.getName()) + "();\n";
    }

    @Override
    public String getActualType(Object obj) {
        return org.joda.time.PeriodType.class.getName();
    }
}

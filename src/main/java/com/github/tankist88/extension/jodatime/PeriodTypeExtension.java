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
    public void fillMethodBody(StringBuilder bb, Set<ProviderInfo> providers, int objectDepth, Object obj) throws Exception {
        PeriodType value = (PeriodType) obj;
        bb.append(getTabSymb()).append(getTabSymb()).append("return org.joda.time.PeriodType.").append(downFirst(value.getName())).append("();\n");
    }

    @Override
    public String getActualType(Object obj) {
        return org.joda.time.PeriodType.class.getName();
    }
}

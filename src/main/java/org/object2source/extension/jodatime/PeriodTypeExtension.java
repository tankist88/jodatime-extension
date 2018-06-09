package org.object2source.extension.jodatime;

import org.joda.time.PeriodType;
import org.object2source.dto.ProviderInfo;
import org.object2source.extension.AbstractEmbeddedExtension;
import org.object2source.util.GenerationUtil;

import java.util.Set;

// org.joda.time.PeriodType
public class PeriodTypeExtension extends AbstractEmbeddedExtension {
    @Override
    public boolean isTypeSupported(Class<?> clazz) {
        return clazz.equals(org.joda.time.PeriodType.class);
    }

    @Override
    public void fillMethodBody(StringBuilder bb, Set<ProviderInfo> providers, int objectDepth, Object obj) throws Exception {
        PeriodType value = (PeriodType) obj;
        bb.append(getTabSymb()).append(getTabSymb()).append("return org.joda.time.PeriodType.").append(GenerationUtil.downFirst(value.getName())).append("();\n");
    }

    @Override
    public String getActualType(Object obj) {
        return org.joda.time.PeriodType.class.getName();
    }
}

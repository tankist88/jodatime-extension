package com.github.tankist88.extension.jodatime;

import com.github.tankist88.object2source.dto.InstanceCreateData;
import com.github.tankist88.object2source.dto.ProviderInfo;
import com.github.tankist88.object2source.extension.AbstractEmbeddedExtension;
import org.joda.time.DateTime;

import java.util.Set;

public class DateTimeExtension extends AbstractEmbeddedExtension {
    @Override
    public boolean isTypeSupported(Class<?> clazz) {
        return clazz.equals(org.joda.time.DateTime.class);
    }

    @Override
    public boolean isFillingSupported() {
        return false;
    }

    @Override
    public String getMethodBody(Set<ProviderInfo> providers, int objectDepth, Object obj, boolean fillObj) throws Exception {
        DateTime value = (DateTime) obj;

        InstanceCreateData instanceCreateData = sourceGenerator.getInstanceCreateData(value.toGregorianCalendar(), objectDepth);

        providers.addAll(instanceCreateData.getDataProviderMethods());

        return getTabSymb() + getTabSymb() + "return new org.joda.time.DateTime(" + instanceCreateData.getInstanceCreator() + ");\n";
    }

    @Override
    public String getActualType(Object obj) {
        return org.joda.time.DateTime.class.getName();
    }
}

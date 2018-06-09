package org.object2source.extension.jodatime;

import org.joda.time.DateTime;
import org.object2source.dto.InstanceCreateData;
import org.object2source.dto.ProviderInfo;
import org.object2source.extension.AbstractEmbeddedExtension;

import java.util.Set;

// org.joda.time.DateTime
public class DateTimeExtension extends AbstractEmbeddedExtension {
    @Override
    public boolean isTypeSupported(Class<?> clazz) {
        return clazz.equals(org.joda.time.DateTime.class);
    }

    @Override
    public void fillMethodBody(StringBuilder bb, Set<ProviderInfo> providers, int objectDepth, Object obj) throws Exception {
        DateTime value = (DateTime) obj;

        InstanceCreateData instanceCreateData = sourceGenerator.getInstanceCreateData(value.toGregorianCalendar(), objectDepth);

        providers.addAll(instanceCreateData.getDataProviderMethods());

        bb.append(getTabSymb()).append(getTabSymb()).append("return new org.joda.time.DateTime(").append(instanceCreateData.getInstanceCreator()).append(");\n");
    }

    @Override
    public String getActualType(Object obj) {
        return org.joda.time.DateTime.class.getName();
    }
}

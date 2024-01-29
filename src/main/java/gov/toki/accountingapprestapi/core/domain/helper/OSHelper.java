package gov.toki.accountingapprestapi.core.domain.helper;

import lombok.experimental.UtilityClass;

@UtilityClass
public class OSHelper {

    public String getOSName() {
        return System.getProperty("os.name");
    }

}

package gov.toki.accountingapprestapi.core.domain.helper;

@UtilityClass
public class ThreadHelper {

    @SneakyThrows(InterruptedException.class)
    public void sleep(long millis) {
        Thread.sleep(millis);
    }

}

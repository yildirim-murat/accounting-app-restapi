package gov.toki.accountingapprestapi.core.crosscuttingconcerns.config;

@Configuration
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
public class AopConfig {
}

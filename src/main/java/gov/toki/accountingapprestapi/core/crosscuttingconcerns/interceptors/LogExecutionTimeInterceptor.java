package gov.toki.accountingapprestapi.core.crosscuttingconcerns.interceptors;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
@Order(Ordered.HIGHEST_PRECEDENCE)
public class LogExecutionTimeInterceptor {

    @Pointcut("within(@edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime *)")
    private void insideAClassAnnotatedWithLogExecutionTime() {/*POINTCUT*/}

    @Pointcut("@annotation(edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.LogExecutionTime)")
    private void annotatedWithLogExecutionTime() {/*POINTCUT*/}

    @Around("insideAClassAnnotatedWithLogExecutionTime() || annotatedWithLogExecutionTime()")
    public Object logExecutionTime(ProceedingJoinPoint pjp) throws Throwable {
        long start = System.nanoTime();
        Object ret = pjp.proceed();
        long end = (System.nanoTime() - start) / 1000000;
        String logMessage = "Method executed in " + end + " milliseconds: " + pjp.toShortString();
        if (end < 400) log.info(logMessage);
        else if (end > 400 && end < 1200) log.warn(logMessage);
        else log.error(logMessage);
        return ret;
    }

}

package gov.toki.accountingapprestapi.core.crosscuttingconcerns.interceptors;

@Aspect
@Component
@Order(0)
public class ReturnIfNullInterceptor {

    @Pointcut("execution(public * *(.., @edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.ReturnIfNull (*), ..))")
    private void hasAtLeastOneParameterAnnotatedWithReturnIfNull() {/*POINTCUT*/}

    @Around("hasAtLeastOneParameterAnnotatedWithReturnIfNull()")
    public Object returnIfNull(final ProceedingJoinPoint pjp) throws Throwable {
        List<Object> argsByAnnotation = AopHelper.getAnnotatedArgs(pjp, ReturnIfNull.class);
        for (Object o : argsByAnnotation) if (o == null) return null;
        return pjp.proceed(pjp.getArgs());
    }

}

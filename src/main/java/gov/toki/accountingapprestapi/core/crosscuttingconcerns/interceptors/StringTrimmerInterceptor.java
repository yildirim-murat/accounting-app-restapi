package gov.toki.accountingapprestapi.core.crosscuttingconcerns.interceptors;

@Aspect
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class StringTrimmerInterceptor {

    @Pointcut("within(@edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Trimmed *)")
    private void insideAClassAnnotatedWithTrimmed() {/*POINTCUT*/}

    @Pointcut("execution(public * *(.., edu.estu.estufastingrestapi.core.service.model.request.abstraction.RequestModel+, ..))")
    private void hasAtLeastOneParameterIsSubclassOfModelInterface() {/*POINTCUT*/}

    @Around("insideAClassAnnotatedWithTrimmed() && hasAtLeastOneParameterIsSubclassOfModelInterface()")
    public Object trim(final ProceedingJoinPoint pjp) throws Throwable {
        Object[] args = pjp.getArgs();
        for (Object object : args) {
            if (!(object instanceof RequestModel)) continue;
            for (Method getter : object.getClass().getMethods())
                if (getter.getReturnType() == String.class && getter.getParameterCount() == 0 && Modifier.isPublic(getter.getModifiers()) && getter.getName().startsWith("get")) {
                    Object value = getter.invoke(object);
                    if (value == null) continue;
                    Method setter = object.getClass().getDeclaredMethod("set" + getter.getName().substring(3), String.class);
                    setter.invoke(object, value.toString().trim());
                }
        }
        return pjp.proceed(args);
    }

}

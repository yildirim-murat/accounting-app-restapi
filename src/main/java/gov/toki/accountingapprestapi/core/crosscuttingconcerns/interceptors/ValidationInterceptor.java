package gov.toki.accountingapprestapi.core.crosscuttingconcerns.interceptors;

@Aspect
@Component
@RequiredArgsConstructor
public class ValidationInterceptor {

    private final Validator validator;

    @Pointcut("execution(public * *(.., @edu.estu.estufastingrestapi.core.crosscuttingconcerns.annotations.Valid (*), ..))")
    private void hasAtLeastOneParameterAnnotatedWithValid() {/*POINTCUT*/}

    @Around("hasAtLeastOneParameterAnnotatedWithValid()")
    public Object validate(final ProceedingJoinPoint pjp) throws Throwable {
        List<Object> argsByAnnotation = AopHelper.getAnnotatedArgs(pjp, Valid.class);
        for (Object object : argsByAnnotation) {
            Set<ConstraintViolation<Object>> violations = validator.validate(object);
            if (!violations.isEmpty()) {
                StringBuilder sb = new StringBuilder();
                for (ConstraintViolation<?> violation : violations)
                    sb.append(violation.getMessage());
                throw new ConstraintViolationException("Error occurred: " + sb, violations);
            }
        }
        return pjp.proceed(pjp.getArgs());
    }

}

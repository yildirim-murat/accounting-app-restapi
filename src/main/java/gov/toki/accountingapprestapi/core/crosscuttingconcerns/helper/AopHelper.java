package gov.toki.accountingapprestapi.core.crosscuttingconcerns.helper;

@UtilityClass
public class AopHelper {

    public <T extends Annotation> T getMethodAnnotation(final JoinPoint jp, Class<T> annotation) {
        return ((MethodSignature) jp.getSignature()).getMethod().getAnnotation(annotation);
    }

    public List<Object> getAnnotatedArgs(final JoinPoint jp, Class<? extends Annotation> searchFor) {
        List<Object> objects = new ArrayList<>();
        Object[] args = jp.getArgs();
        Method method = ((MethodSignature) jp.getSignature()).getMethod();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        for (int i = 0; i < parameterAnnotations.length; i++) {
            Annotation[] annotations = parameterAnnotations[i];
            for (Annotation annotation : annotations)
                if (annotation.annotationType() == searchFor)
                    objects.add(args[i]);
        }
        return objects;
    }

}

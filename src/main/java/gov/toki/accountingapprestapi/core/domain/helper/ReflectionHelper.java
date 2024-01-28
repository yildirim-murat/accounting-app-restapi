package gov.toki.accountingapprestapi.core.domain.helper;

@UtilityClass
public class ReflectionHelper {

    @SneakyThrows(IllegalAccessException.class)
    public <T> Optional<T> getStaticFieldValueByName(String fieldName, Class<T> fieldType, Class<?> clazz) {
        try {
            return Optional.ofNullable(fieldType.cast(clazz.getField(fieldName).get(null)));
        } catch (NoSuchFieldException exception) {
            return Optional.empty();
        }
    }

    public <T> Optional<T> getFieldValueByGetter(Object object, String getterName, Class<T> fieldType) {
        if (object == null || getterName == null || fieldType == null) return Optional.empty();
        try {
            Method getter = object.getClass().getMethod(getterName);
            return Optional.ofNullable(fieldType.cast(getter.invoke(object)));
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException exception) {
            return Optional.empty();
        }
    }

    public List<Object> getArgsByAnnotation(Parameter[] params, Object[] args, Class<? extends Annotation> searchAnnotation) {
        List<Object> annotatedArgs = new ArrayList<>();
        for (int i = 0; i < args.length; i++)
            if (params[i].isAnnotationPresent(searchAnnotation))
                annotatedArgs.add(args[i]);
        return annotatedArgs;
    }

    public <T extends Annotation> T getMethodAnnotation(Method method, Class<T> annotation) {
        return method.getAnnotation(annotation);
    }

    @SneakyThrows
    public <RT, OT> RT invokeMethod(OT object, Method method, Class<RT> returnType, Object[] paramValues) {
        return returnType.cast(method.invoke(object, paramValues));
    }

    @SneakyThrows
    public <RT, OT> RT invokeMethod(OT object, String methodName, Class<RT> returnType, Class<?>[] paramTypes, Object[] paramValues) {
        return invokeMethod(object, getMethod(object.getClass(), methodName, paramTypes), returnType, paramValues);
    }

    @SneakyThrows
    public Method getMethod(Class<?> clazz, String methodName, Class<?>[] paramTypes) {
        return clazz.getMethod(methodName, paramTypes);
    }

    public String getGetterNameOfFieldName(String fieldName) {
        return "get" + Character.toUpperCase(fieldName.charAt(0)) + fieldName.substring(1);
    }

}

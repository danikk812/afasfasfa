package by.bsuir.servlets.service;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ClassMethodsFinder {

    public List<String> findClassMethods(String className) {
        try {
            Class inputClass = Class.forName(className);
            Method[] methods = inputClass.getDeclaredMethods();
            List<String> methodsList = Arrays.stream(methods)
                    .map(this::formatMethodInfo)
                    .collect(Collectors.toList());
            return methodsList;
        } catch (ClassNotFoundException e) {
            return null;
        }

    }

    private String formatMethodInfo(Method method) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(method.getReturnType().getName()).append(" ");
        stringBuilder.append(method.getName()).append("(");
        Class<?>[] methodParams = method.getParameterTypes();
        for (int i = 0; i < methodParams.length; i++) {
            if (methodParams.length > 1 && i < methodParams.length - 1) {
                stringBuilder.append(methodParams[i].getName()).append(", ");
            } else {
                stringBuilder.append(methodParams[i].getName());
            }
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

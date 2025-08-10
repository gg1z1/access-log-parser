package com.stepup.patterns;

public enum HttpMethod {
    GET,
    POST,
    PUT,
    DELETE,
    HEAD,
    OPTIONS,
    PATCH,
    TRACE,
    CONNECT;

    // Метод для безопасного получения метода
    public static HttpMethod fromString(String method) {
        try {
                return HttpMethod.valueOf(method.toUpperCase());
        } catch (IllegalArgumentException e) {
            return null; // или можно вернуть DEFAULT метод
        }
    }
}
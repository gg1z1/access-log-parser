package com.stepup.exeptions;

public class LineLengthException extends RuntimeException {
    public static final int MAX_LINE_LENGTH = 1024;

    public LineLengthException(int actualLength) {
        super(buildErrorMessage(actualLength));
    }

    private static String buildErrorMessage(int actualLength) {
        return String.format(
                """
                        Превышена максимально допустимая длина строки!
                        Максимально разрешенная длина: %d символов
                        Обнаруженная длина строки: %d символов
                        Разница: %d символов""",

                MAX_LINE_LENGTH,
                actualLength,
                actualLength - MAX_LINE_LENGTH
        );
    }
}

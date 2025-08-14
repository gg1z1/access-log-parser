package com.stepup.exeptions;

public class LineLengthException extends RuntimeException {
    public static final int MAX_LINE_LENGTH = 1024;

    private final int lineNumber;
    private final int actualLength;

    public LineLengthException(int lineNumber, int actualLength) {
        super(buildErrorMessage(lineNumber, actualLength));
        this.lineNumber = lineNumber;
        this.actualLength = actualLength;
    }

    private static String buildErrorMessage(int lineNumber, int actualLength) {
        return String.format(
                """
                        Ошибка в строке №%d!
                        Превышена максимально допустимая длина строки!
                        Максимально разрешенная длина: %d символов
                        Обнаруженная длина строки: %d символов
                        Разница: %d символов""",
                lineNumber,
                MAX_LINE_LENGTH,
                actualLength,
                actualLength - MAX_LINE_LENGTH
        );
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public int getActualLength() {
        return actualLength;
    }
}

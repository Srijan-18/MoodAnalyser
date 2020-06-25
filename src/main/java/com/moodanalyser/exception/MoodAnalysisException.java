package com.moodanalyser.exception;

public class MoodAnalysisException extends Exception {
    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD;
    }

    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
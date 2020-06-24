package com.moodanalyser.exception;

public class MoodAnalysisException extends Exception {
    public enum ExceptionType {
        ENTERED_NULL, ENTERED_EMPTY;
    }

    public ExceptionType type;

    public MoodAnalysisException(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
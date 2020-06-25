package com.moodanalyser.service;

import com.moodanalyser.exception.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyserObject(String className,String  message,Class<?> parameters) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName(className);
            Constructor<?> moodAnalyserConstructor = moodAnalyserClass.getConstructor(parameters);
            moodAnalyserConstructor.setAccessible(true);
            Object moodAnalyserObj = moodAnalyserConstructor.newInstance(message);
            return (MoodAnalyser)moodAnalyserObj;
        } catch (ClassNotFoundException e) {
            throw new MoodAnalysisException
                    (MoodAnalysisException.ExceptionType.NO_SUCH_CLASS, "ERROR: NO SUCH CLASS FOUND");
        } catch (NoSuchMethodException e) {
            throw new MoodAnalysisException
                    (MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "ERROR: NO SUCH METHOD");
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}

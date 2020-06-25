package com.moodanalyser.service;

import com.moodanalyser.exception.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserReflector {
   static Object moodAnalyserObj;
    public static MoodAnalyser createMoodAnalyser(String... details) throws MoodAnalysisException {
        try {
            Class<?> moodAnalyserClass = Class.forName(details[0]);
            if (details.length>1){
            Class<?> parameters=Class.forName("java.lang."+details[1]);
            Constructor<?> moodAnalyserConstructor = moodAnalyserClass.getConstructor(parameters);
            Object moodAnalyserObj = moodAnalyserConstructor.newInstance(details[2]);
            return (MoodAnalyser)moodAnalyserObj;
            }
            else {
                Constructor<?> moodAnalyserConstructor = moodAnalyserClass.getConstructor();
                Object moodAnalyserObj = moodAnalyserConstructor.newInstance();
                return (MoodAnalyser)moodAnalyserObj;
            }
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
    public static String callAnalyseMood(MoodAnalyser moodAnalyser) throws MoodAnalysisException {
        try {
            return moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_METHOD, "Improper Message Call");
        }
    }
    public static void setMood(MoodAnalyser moodAnalyser,String fieldName,String fieldValue) throws MoodAnalysisException {
        try
        {
            Field field = moodAnalyser.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(moodAnalyser, fieldValue);
        } catch (NoSuchFieldException e)
        {
            throw new MoodAnalysisException(MoodAnalysisException.ExceptionType.NO_SUCH_FIELD, "ERROR: NO SUCH FIELD");
        } catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}

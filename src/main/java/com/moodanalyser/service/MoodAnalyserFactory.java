package com.moodanalyser.service;

import com.moodanalyser.exception.MoodAnalysisException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {

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
}

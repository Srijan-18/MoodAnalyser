package com.moodanalyser.service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserFactory {
    public static MoodAnalyser createMoodAnalyserObject(String  message) {
        try {
            Class<?> moodAnalyserClass = Class.forName("com.moodanalyser.service.MoodAnalyser");
            Constructor<?> moodAnalyserConstructor = moodAnalyserClass.getConstructor(String.class);
            Object moodAnalyserObj = moodAnalyserConstructor.newInstance(message);
            return (MoodAnalyser)moodAnalyserObj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
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

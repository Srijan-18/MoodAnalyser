package com.moodanalyser;

import com.moodanalyser.exception.MoodAnalysisException;
import com.moodanalyser.service.MoodAnalyser;
import com.moodanalyser.service.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyserTest {
    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject()  {
        MoodAnalyser moodAnalyser= MoodAnalyserFactory.createMoodAnalyserObject("I am in happy mood");
        Assert.assertEquals(new MoodAnalyser("I am in happy mood"),moodAnalyser);
    }
    @Test
    public void givenMood_WhenContainsSad_ShouldReturnSAD() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in Sad Mood");
        Assert.assertEquals("SAD", moodAnalyser.analyseMood());
    }

    @Test
    public void givenMood_WhenDoesNotContainSad_ShouldReturnHAPPY() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in happy Mood");
        Assert.assertEquals("HAPPY", moodAnalyser.analyseMood());
    }

    @Test
    public void givenMood_WhenNull_ShouldTHROWEXCEPTION() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_NULL, e.type);
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenMood_WhenEMPTY_ShouldTHROWEXCEPTION() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, e.type);
            System.out.println(e.getMessage());
        }
    }
}
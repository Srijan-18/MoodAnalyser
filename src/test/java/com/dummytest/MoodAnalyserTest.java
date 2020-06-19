package com.dummytest;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMood_WhenContainsSad_ShouldReturnSAD() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad Mood");
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
            System.out.print(e.getMessage());
        }
    }

    @Test
    public void givenMood_WhenEMPTY_ShouldTHROWEXCEPTION() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("");
        try {
            moodAnalyser.analyseMood();
        } catch (MoodAnalysisException e) {
            Assert.assertEquals(MoodAnalysisException.ExceptionType.ENTERED_EMPTY, e.type);
            System.out.print(e.getMessage());
        }
    }
}

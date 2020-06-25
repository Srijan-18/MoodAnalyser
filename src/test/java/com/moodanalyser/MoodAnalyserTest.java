package com.moodanalyser;

import com.moodanalyser.exception.MoodAnalysisException;
import com.moodanalyser.service.MoodAnalyser;
import com.moodanalyser.service.MoodAnalyserFactory;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyserObject
                ("com.moodanalyser.service.MoodAnalyser", "I am in happy mood", String.class);
        Assert.assertEquals(new MoodAnalyser("I am in happy mood"), moodAnalyser);
    }

    @Test
    public void givenClassName_WhenImproper_ShouldThrowAnError() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyserObject
                    ("com.moodanalyser.service.Mood", "I am in happy mood", String.class);
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenConstructor_WhenImproperParameters_ShouldThrowAnError() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserFactory.createMoodAnalyserObject
                    ("com.moodanalyser.service.MoodAnalyser", "I am in happy mood", Integer.class);
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
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
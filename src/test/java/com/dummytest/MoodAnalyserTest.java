package com.dummytest;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void testAnalyseMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in sad Mood");
        Assert.assertEquals("SAD",moodAnalyser.analyseMood());
    }

    @Test
    public void testHappyMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser("I am in happy Mood");
        Assert.assertEquals("HAPPY",moodAnalyser.analyseMood());
    }

    @Test
    public void givenMood_WhenNull_ShouldReturnHappy() {
        MoodAnalyser moodAnalyser = new MoodAnalyser(null);
        Assert.assertEquals("HAPPY",moodAnalyser.analyseMood());
    }
}

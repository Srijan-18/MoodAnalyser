package com.moodanalyser;

import com.moodanalyser.exception.MoodAnalysisException;
import com.moodanalyser.service.MoodAnalyser;
import com.moodanalyser.service.MoodAnalyserReflector;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {

    @Test
    public void givenMoodAnalyserClass_WhenProper_ShouldReturnObject() throws MoodAnalysisException {
        MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser
                ("com.moodanalyser.service.MoodAnalyser",  "String","I am in happy mood");
        Assert.assertEquals(new MoodAnalyser("I am in happy mood"), moodAnalyser);
    }

    @Test
    public void givenClassName_WhenImproper_ShouldThrowAnError() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser
                    ("com.moodanalyser.service.Mood", "String", "I am in happy mood");
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenConstructor_WhenImproperParameters_ShouldThrowAnError() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser
                    ("com.moodanalyser.service.MoodAnalyser", "Integer","I am in happy mood");
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void givenConstructor_WhenNoParameters_ShouldMakeDefaultConstructor() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser
                    ("com.moodanalyser.service.MoodAnalyser");
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void givenMessage_ShouldInvoke_AnalyseMoodMethod_UsingReflector() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser
                    ("com.moodanalyser.service.MoodAnalyser", "String", "I am in happy mood");
            Assert.assertEquals("HAPPY",MoodAnalyserReflector.callAnalyseMood(moodAnalyser));
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenHappyMessage_ShouldChangeMoodDynamically_UsingReflector() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser
                    ("com.moodanalyser.service.MoodAnalyser");
            MoodAnalyserReflector.setMood(moodAnalyser,"message","I am in Happy Mood");
            Assert.assertEquals("HAPPY",MoodAnalyserReflector.callAnalyseMood(moodAnalyser));
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenInvalidFieldName_ShouldReturnError() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser
                    ("com.moodanalyser.service.MoodAnalyser");
            MoodAnalyserReflector.setMood(moodAnalyser,"mood","I am in Happy Mood");
            Assert.assertEquals("HAPPY",MoodAnalyserReflector.callAnalyseMood(moodAnalyser));
        } catch (MoodAnalysisException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void givenHappyMessage_WhenImproperMethod_ShouldThrowAnError() {
        try {
            MoodAnalyser moodAnalyser = MoodAnalyserReflector.createMoodAnalyser
                    ("com.moodanalyser.service.MoodAnalyser", "Integer", "I am in happy mood");
            Assert.assertEquals("HAPPY",MoodAnalyserReflector.callAnalyseMood(moodAnalyser));
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
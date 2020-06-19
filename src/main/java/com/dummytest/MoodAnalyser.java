package com.dummytest;

public class MoodAnalyser {
    private String message;

    /**
     * PARAMETERISED CONSTRUCTOR TO INITIALISE CLASS VARIABLE
     * @param message
     */
    public MoodAnalyser(String message) {
        this.message = message;
    }

    /**
     * METHOD TO ANALYSE MOOD BASED ON USER INPUT IN CLASS VARIABLE AND RETURN A MESSAGE ACCORDINGLY
     * @return
     */
    public String analyseMood() throws MoodAnalysisException {
        try {
            if(message.length() == 0)
               throw new MoodAnalysisException
                       (MoodAnalysisException.ExceptionType.ENTERED_EMPTY,"INVALID INPUT : EMPTY MOOD");
            if (message.contains("SAD"))
                return "SAD";
            else
                return "HAPPY";
        }catch (NullPointerException e){
            throw new MoodAnalysisException
                    (MoodAnalysisException.ExceptionType.ENTERED_NULL,"INVALID INPUT : NULL MOOD");
        }
    }
}
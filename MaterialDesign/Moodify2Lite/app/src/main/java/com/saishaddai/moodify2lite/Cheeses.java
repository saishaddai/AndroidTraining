package com.saishaddai.moodify2lite;
import java.util.Random;

public class Cheeses {

    private static final Random RANDOM = new Random();

    public static int getRandomCheeseDrawable() {
        return moodWeekValuesIcons[RANDOM.nextInt(7)];
    }

    public static final String[] moodWeekNames = {
            "This week",
            "Last week",
            "2 weeks ago",
            "3 weeks ago",
            "4 weeks ago",
            "5 weeks ago",
            "6 weeks ago",
            "7 weeks ago"
    };

    public static final int[] moodWeekValues = {
            R.drawable.anger,
            R.drawable.disgust,
            R.drawable.fear,
            R.drawable.joy,
            R.drawable.love,
            R.drawable.normal,
            R.drawable.surprise,
            R.drawable.sadness
    };

    public static final int[] moodWeekValuesIcons = {
            R.drawable.zanger,
            R.drawable.zdisgust,
            R.drawable.zfear,
            R.drawable.zjoy,
            R.drawable.zlove,
            R.drawable.znormal,
            R.drawable.zsurprise,
            R.drawable.zsadness
    };

}

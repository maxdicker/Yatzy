package com.max;

public class UserIO {

    public ScoreCategory chooseCategory(IO inputGetter) {
        ScoreCategory chosenCategory = ScoreCategory.ONES;

        inputGetter.write("Which score category would you like to calculate?");
        String input = inputGetter.read();

        for (ScoreCategory category : ScoreCategory.values()) {
            if (input.equals(category.identifier)) {
                chosenCategory = category;
                break;
            }
        }

        return chosenCategory;
    }
}

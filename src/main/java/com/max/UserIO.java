package com.max;

public class UserIO {

    public ScoreCategory chooseCategory(IO inputGetter) {
        inputGetter.write("Which score category would you like to calculate?");
        String input = inputGetter.read();

        for (ScoreCategory category : ScoreCategory.values()) {
            if (input.equals(category.identifier)) {
                return category;
            }
        }

        return chooseCategory(inputGetter);
    }
}

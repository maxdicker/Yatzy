package com.max;

public enum ScoreCategory {
    CHANCE (1),
    YATZY (2),
    ONES (3),
    TWOS (4),
    THREES (5),
    FOURS (6),
    FIVES (7),
    SIXES (8),
    PAIR (9),
    TWO_PAIRS (10),
    THREE_OF_A_KIND (11),
    FOUR_OF_A_KIND (12),
    SMALL_STRAIGHT (13),
    LARGE_STRAIGHT (14),
    FULL_HOUSE (15);

    private int identifier;

    ScoreCategory(int identifier) {
        this.identifier = identifier;
    }
}

package Bingo;

import com.aldebaran.qi.Application;

import java.util.Arrays;

public class BingoGame {

    private final int SEVENFIVE = 75;
    private final int ONE = 1;
    private final int ZERO = 0;
    private final int ONEFOUR = 14;


// Which one is row and column. Two-dimentional array
    private int[][] bingoCards = {
            {0},
// Explain which card.
            {2, 8, 14, 16, 19, 30, 33, 41, 43, 48, 51, 56, 62, 70, 74},
            {3, 5, 13, 18, 20, 27, 32, 34, 39, 46, 58, 59, 64, 68, 71},
            {9, 10, 15, 17, 21, 26, 31, 38, 45, 47, 49, 55, 61, 69, 72},
            {1, 4, 12, 17, 18, 22, 34, 35, 44, 50, 52, 57, 63, 67, 73},
            {6, 11, 12, 17, 22, 29, 36, 37, 42, 53, 56, 58, 65, 66, 75},

            {7, 10, 13, 16, 23, 28, 34, 41, 44, 45, 53, 60, 70, 71, 75},
            {1, 2, 14, 18, 24, 25, 35, 36, 40, 48, 51, 59, 68, 71, 74},
            {4, 6, 11, 19, 20, 23, 32, 33, 37, 49, 50, 58, 61, 67, 72},
            {3, 7, 8, 19, 20, 24, 31, 37, 39, 46, 48, 54, 62, 64, 66},
            {2, 4, 9, 21, 25, 26, 34, 38, 45, 47, 49, 58, 65, 67, 72},

            {5, 7, 15, 22, 24, 25, 37, 39, 40, 49, 52, 54, 63, 69, 73},
            {1, 4, 8, 19, 20, 22, 30, 33, 43, 50, 52, 56, 61, 64, 75},
            {3, 5, 11, 16, 18, 27, 36, 38, 42, 49, 53, 55, 63, 65, 73},
            {5, 6, 11, 16, 23, 30, 36, 37, 41, 46, 57, 60, 66, 68, 70},
            {9, 12, 13, 20, 21, 23, 30, 35, 40, 46, 51, 56, 62, 68, 74},
    };

    private boolean[] numbersRead;
//    private Random random;

    // Constructor
    public BingoGame() {
        numbersRead = new boolean[76];
//        random = new Random();
    }

// The read number fills in the spot in the array with a random generated number.
    public boolean isNumberRead(int index) {
//        System.out.println("Bingo.Number read: " + index);
        return this.numbersRead[index];
    }

// Set generated number to true, so you know which numbers have already passed.
    public void setNumberRead(int index) {
        this.numbersRead[index] = true;
    }


// Method's to generate numbers from 1 to 75. This generated number, if different turns into "ball".
    public int generateNumber() {
//        return random.nextInt(75) + 1;
        int generated = ((int) (Math.random() * this.SEVENFIVE) + this.ONE);
//        System.out.println("Generated number | " + generated);
        return generated;
    }

// Method checks if all numbers are read.

    public boolean ifAllNumbersRead() {
        for (int i = ONE; i <= SEVENFIVE; i++) {
            if (!isNumberRead(i)) {
                return false;
            }
        }
        return true;
    }

// This method checks if the bingocard correct is by using the is number read function.
    public boolean ifCardIsCorrect(int cardNumber) {
        for (int i = ZERO; i < ONEFOUR; i++) {
//                System.out.println("Bingo.Number card: " + bingoCards[0][i]);
            if (!isNumberRead(bingoCards[cardNumber][i])) {
//                    System.out.println("niet gelezen");
                return false;
            }
        }
      return true;
    }
}


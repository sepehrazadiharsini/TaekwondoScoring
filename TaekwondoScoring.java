/*
* Sepehr Azadi-Harsini
* 240540030
* 05/11/24
* Version 1
* Assessed programme 6: This program is used to score Taekwindo competitions. It asks which player scored and what the score was for.
* It caclulates and displays the total score for both players until the word "QUIT" is entered.
*/

import java.util.Scanner;


//Start TaekwondoScoring

public class TaekwondoScoring {

    public static void main(String[] args) {

        calculateScore();

    }

    //Start printScoreMenu
    //This method uses concatention to print the scoring menu

    public static void printScoreMenu()
    {
        final int PUNCH = 1;
        final int HOGU = 2;
        final int HEAD = 3;
        final int T_HOGU = 4;
        final int T_HEAD = 5;
        final int GAM_JEOM = 1;

        System.out.println("Taekwondo Scores");
        System.out.println("punch = " +  PUNCH + ", hogu = " +  HOGU + ", head = " + HEAD + " t-hogu = " + T_HOGU + ", t-head = " + T_HEAD + ", gam-jeom = " + GAM_JEOM);
        System.out.println("-----------------");

        return;

    } // End  printScoreMenu




    //Start typeOfScore
    // This method  asks the user to input the type of score that the player as earned, calculates the score  and prints the result

    public static int typeOfScore(int playerNumber)
    {
        final int PUNCH = 1;
        final int HOGU = 2;
        final int HEAD = 3;
        final int T_HOGU = 4;
        final int T_HEAD = 5;
        final int GAM_JEOM = 1;

        int score = 0;
        

        String askTypeOfScore = inputString("What was the score for (punch, hogu, etc) ?").toLowerCase();

        if (askTypeOfScore.equals("punch")) {
            score += PUNCH;
        } else if (askTypeOfScore.equals("hogu")) {
            score += HOGU;
        } else if (askTypeOfScore.equals("head")) {
            score += HEAD;
        } else if (askTypeOfScore.equals("t-hogu")) {
            score += T_HOGU;
        } else if (askTypeOfScore.equals("t-head")) {
            score += T_HEAD;
        } else if (askTypeOfScore.equals("gam-jeom")) {
            score += GAM_JEOM;
        } else {
            System.out.println("Invalid score type. Please enter a valid score type (punch, hogu, head, t-hogu, t-head, or gam-jeom).");
            score = typeOfScore(playerNumber);
        }

        System.out.println("Player " + playerNumber + " scored " + score + " point" + (score > 1 ? "s." : "."));
        return score;

    } // ask TypeOfScore




    
    // Start askScore
    // This method asks which player scored and returns the score of that player.
    public static int[] askScore()
    {   
        final String QUIT = "TIME";
        String playerScored = inputString("Which player scored (1 or 2)?");
        int playerOneScore = 0;
        int playerTwoScore = 0;

        while (!playerScored.equals(QUIT.toLowerCase())) {
            int playerNumber;

            // Validate player input (1 or 2)
            if (playerScored.equals("1") || playerScored.equals("2")) {
                playerNumber = Integer.parseInt(playerScored);

                // Add the score to the correct player's total
                if (playerNumber == 1) {
                    playerOneScore += typeOfScore(playerNumber);
                } else if (playerNumber == 2) {
                    playerTwoScore += typeOfScore(playerNumber);
                }
            } else {
                System.out.println("Invalid input. Please enter 1, 2, or 'TIME' to end.");
            }

            System.out.println("Score = " + playerOneScore + " : " + playerTwoScore);

            // Prompt for the next input
            playerScored = inputString("Which player scored (1 or 2)?").toLowerCase();
        }

        return new int[]{playerOneScore, playerTwoScore};

    } // End askScore



    //Start printWinner
    // this method prints the winner of the game

    public static void printWinner(int playerOneScore, int playerTwoScore) 
    {

        if (playerOneScore > playerTwoScore) {
            System.out.println("Player 1 wins! Final Score = " + playerOneScore + " : " + playerTwoScore);
        } else if (playerTwoScore > playerOneScore) {
            System.out.println("Player 2 wins! Final Score = " + playerOneScore + " : " + playerTwoScore);
        } else {
            System.out.println("It's a tie! Final Score = " + playerOneScore + " : " + playerTwoScore);
        }

    } // End  printWinner





    //Start calculateScore
    public static void calculateScore()
    {

        printScoreMenu();

        int[] scores = askScore();

        printWinner(scores[0], scores[1]);

        return;
    } // End  calculateScore



    // Start inputString
    public static String inputString(String message) 
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();
    } // End inputString



} //End TaekwondoScoring

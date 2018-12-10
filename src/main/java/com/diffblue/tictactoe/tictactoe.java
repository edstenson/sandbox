// Copyright 2018 Diffblue limited. All rights reserved.

package com.diffblue.tictactoe;

import java.util.Scanner;
import java.util.Random;

public class tictactoe {

  public static void main(String[] args) {

//  Set up initial variables
//  ========================
    String[] ourBoard = {"__", "__", "__", "__", "__", "__", "__", "__", "__"};
    String thisPlayer;
    int moveCount = 0;

//  Show help and then show empty board
//  ===================================
    System.out.println("\n\n\n");
    displayHelp();
    System.out.println("Here's the board. Good luck.\n");
    printBoard(ourBoard);

//  Choose who goes first
//  =====================
    Random rand = new Random();
    thisPlayer = "P1";
    int n = rand.nextInt(2);
    if (n == 1) { thisPlayer = "P2"; }
    System.out.println("=====================");
    System.out.println("Player " + thisPlayer + " to go first");
    System.out.println("=====================\n");


//  Main playing loop
//  =================
    String theWinner;

    for (int play = 1; play < 10; play++) {
      Scanner sc = new Scanner(System.in);

      System.out.print("What's your move " + thisPlayer + "? ");
      int move = sc.nextInt();
      parseCommandLine(move);

      // Check that the square has not already been chosen and is not out of bounds
      while (ourBoard[move] != "__" && move < 10 && move > -1) {
        System.out.print("Sorry, that's already taken. What's your move " + thisPlayer + "?");
        move = sc.nextInt();
        parseCommandLine(move);
      }

      ourBoard[move] = thisPlayer;
      printBoard(ourBoard);


      theWinner = checkWinner(ourBoard);
      if(theWinner == "P1" || theWinner == "P2") {
        System.out.println("And the crowd goes wild for " + theWinner);
        System.exit(0);
      }
 
    // Switch to the other player
      if (thisPlayer == "P1") { thisPlayer = "P2"; } else { thisPlayer = "P1"; }  
    }

    // Game is over without a winner
    System.out.println("It's a draw. Well played.\n\n\n\n\n\n\n\n\n\n");
    }


//  Print the current status of the board
//  =====================================
    public static void printBoard(String[] theBoard) {
      for (int row = 0; row < 3; row++) {
        System.out.println(theBoard[3 * row + 0] + " " + theBoard[3 * row + 1] + " " + theBoard[3 * row + 2]);
        System.out.println();
      }
      System.out.println("\n");
    }


//  Check for special commands such as quit or man
//  ==============================================
    public static void parseCommandLine(int command) {
      if (command == 99) { System.exit(0); }
      if (command == 88) { displayHelp(); }
    }


//  Display help page
//  =================
    public static void displayHelp() {
      System.out.println("\n\nWelcome to Diffblue TicTacToe\n=============================\n");
      System.out.println("The goal of the game is simple: run away from the zombies!");
      System.out.println("Here's a summary of the commands you can use:\n");
      System.out.println("  0 to 2 are the squares in the top row");
      System.out.println("  3 to 5 are the squares in the middle row");
      System.out.println("  6 to 8 are the squares in the bottom row");
      System.out.println("  99 to quit\n");
//    System.out.println("  88 to display this page\n");
    }


//  Check if anyone has won yet
//  ===========================
// Check rows
    public static String checkWinner(String[] theBoard) {
            if (theBoard[0] == theBoard[1] && theBoard[0] == theBoard[2]) { return theBoard[0]; }
            if (theBoard[3] == theBoard[4] && theBoard[3] == theBoard[5]) { return theBoard[3]; }
            if (theBoard[6] == theBoard[7] && theBoard[6] == theBoard[8]) { return theBoard[6]; }
            
            // Check columns
            if (theBoard[0] == theBoard[3] && theBoard[0] == theBoard[6]) { return theBoard[0]; }
            if (theBoard[1] == theBoard[4] && theBoard[1] == theBoard[7]) { return theBoard[1]; }
            if (theBoard[2] == theBoard[5] && theBoard[2] == theBoard[8]) { return theBoard[2]; }
            
            //  Check diagonals
            if (theBoard[0] == theBoard[4] && theBoard[0] == theBoard[8]) { return theBoard[0]; }
            if (theBoard[2] == theBoard[4] && theBoard[2] == theBoard[6]) { return theBoard[2]; }

            return "none";
        }
}


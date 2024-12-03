package com.example.tictactoe

class GameLogic {

    // x->1 O->2
    private var currPlayer = 1

    // A matrix that will hold the current state of the board
    private var boardState = arrayOf(
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0),
        intArrayOf(0, 0, 0)
    )

    fun getCurrentPlayer():Int{
        return currPlayer
    }

    // Update the board if the move is valid
    fun moveOnBoard(row: Int, col: Int): Boolean {
        if (boardState[row][col] != 0) {
            return false// Checks if move is valid
        }
        boardState[row][col] = currPlayer

        if (gameOver() || isBoardFull()) {
            resetBoard()// If there's a winner or the board is full, reset it
        }
        else {
            currPlayer = 3 - currPlayer// Switch player
        }
        return true
    }

    fun isBoardFull(): Boolean{
        for (row in boardState ){
            for(cell in row){
                if(cell == 0)
                    return false// Board is not full
            }
        }
        return true// Board is full
    }

        //Reset the board
    fun resetBoard() {
            boardState = arrayOf(
                intArrayOf(0, 0, 0),
                intArrayOf(0, 0, 0),
                intArrayOf(0, 0, 0)
            )
            currPlayer = 1
        }

    private fun gameOver(): Boolean {
        if(
            (boardState[0][0] == currPlayer && boardState[0][1] == currPlayer && boardState[0][2] == currPlayer)
            ||
            (boardState[1][0] == currPlayer && boardState[1][1] == currPlayer && boardState[1][2] == currPlayer)
            ||
            (boardState[2][0] == currPlayer && boardState[2][1] == currPlayer && boardState[2][2] == currPlayer)
            ||
            (boardState[0][0] == currPlayer && boardState[1][0] == currPlayer && boardState[2][0] == currPlayer)
            ||
            (boardState[0][1] == currPlayer && boardState[1][1] == currPlayer && boardState[2][1] == currPlayer)
            ||
            (boardState[0][2] == currPlayer && boardState[1][2] == currPlayer && boardState[2][2] == currPlayer)
            ||
            (boardState[0][0] == currPlayer && boardState[1][1] == currPlayer && boardState[2][2] == currPlayer)
            ||
            (boardState[0][2] == currPlayer && boardState[1][1] == currPlayer && boardState[2][0] == currPlayer)
            )
        {
            //There is a winner
            return true;
        }
        //There is no winner
        return false;
    }
}

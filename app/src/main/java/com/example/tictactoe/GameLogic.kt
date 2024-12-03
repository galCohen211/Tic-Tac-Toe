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
    
        //Reset the board
    fun restBoard(){
        boardState = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        currPlayer = 1

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
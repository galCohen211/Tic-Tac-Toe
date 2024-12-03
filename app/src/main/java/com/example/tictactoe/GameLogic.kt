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
    }
}
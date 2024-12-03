package com.example.tictactoe

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PlayActivity : AppCompatActivity() {

    //lateinit allows to initialize the variable later on in the project
    private lateinit var gameLogic: GameLogic
    private lateinit var box1: TextView
    private lateinit var box2: TextView
    private lateinit var box3: TextView
    private lateinit var box4: TextView
    private lateinit var box5: TextView
    private lateinit var box6: TextView
    private lateinit var box7: TextView
    private lateinit var box8: TextView
    private lateinit var box9: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_play)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Initialize the logic
        gameLogic = GameLogic()

        // Initialize TextView variables by finding them in the layout
        box1 = findViewById(R.id.box1)
        box2 = findViewById(R.id.box2)
        box3 = findViewById(R.id.box3)
        box4 = findViewById(R.id.box4)
        box5 = findViewById(R.id.box5)
        box6 = findViewById(R.id.box6)
        box7 = findViewById(R.id.box7)
        box8 = findViewById(R.id.box8)
        box9 = findViewById(R.id.box9)

        // Each box needs a listener to keep track of the players' moves
        //setClickListeners()
    }


    fun handleMove(row: Int, col: Int, box: TextView) {
        if (gameLogic.moveOnBoard(row,col)){
            val playerType = gameLogic.getCurrentPlayer();
            if (playerType == 1) {
                box.text = "X"
            }else{
                box.text = "O"
            }
            box.isClickable = false;
        }
        else{
            //resetBoardUI()
        }
    }
}

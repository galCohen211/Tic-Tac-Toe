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

    private fun resetBoardUI() {
        box1.text = ""
        box2.text = ""
        box3.text = ""
        box4.text = ""
        box5.text = ""
        box6.text = ""
        box7.text = ""
        box8.text = ""
        box9.text = ""

        // Re-enable clicks
        box1.isClickable = true
        box2.isClickable = true
        box3.isClickable = true
        box4.isClickable = true
        box5.isClickable = true
        box6.isClickable = true
        box7.isClickable = true
        box8.isClickable = true
        box9.isClickable = true
    }

//    private fun setClickListeners() {
//        box1.setOnClickListener { handleMove(0, 0, box1) }
//        box2.setOnClickListener { handleMove(0, 1, box2) }
//        box3.setOnClickListener { handleMove(0, 2, box3) }
//        box4.setOnClickListener { handleMove(1, 0, box4) }
//        box5.setOnClickListener { handleMove(1, 1, box5) }
//        box6.setOnClickListener { handleMove(1, 2, box6) }
//        box7.setOnClickListener { handleMove(2, 0, box7) }
//        box8.setOnClickListener { handleMove(2, 1, box8) }
//        box9.setOnClickListener { handleMove(2, 2, box9) }
//    }

    //handleMove
}

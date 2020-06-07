package com.example.tictactoegame

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()
    private var activePlayer = 1

    fun restartGame(view:View)
    {
        bu1.setBackgroundResource(android.R.drawable.btn_default)
        bu2.setBackgroundResource(android.R.drawable.btn_default)
        bu3.setBackgroundResource(android.R.drawable.btn_default)
        bu4.setBackgroundResource(android.R.drawable.btn_default)
        bu5.setBackgroundResource(android.R.drawable.btn_default)
        bu6.setBackgroundResource(android.R.drawable.btn_default)
        bu7.setBackgroundResource(android.R.drawable.btn_default)
        bu8.setBackgroundResource(android.R.drawable.btn_default)
        bu9.setBackgroundResource(android.R.drawable.btn_default)

        bu1.setBackgroundColor(Color.parseColor("#ff669900"))
        bu2.setBackgroundColor(Color.parseColor("#ff669900"))
        bu3.setBackgroundColor(Color.parseColor("#ff669900"))
        bu4.setBackgroundColor(Color.parseColor("#ff669900"))
        bu5.setBackgroundColor(Color.parseColor("#ff669900"))
        bu6.setBackgroundColor(Color.parseColor("#ff669900"))
        bu7.setBackgroundColor(Color.parseColor("#ff669900"))
        bu8.setBackgroundColor(Color.parseColor("#ff669900"))
        bu9.setBackgroundColor(Color.parseColor("#ff669900"))

        bu1.text = ""
        bu2.text = ""
        bu3.text = ""
        bu4.text = ""
        bu5.text = ""
        bu6.text = ""
        bu7.text = ""
        bu8.text = ""
        bu9.text = ""

        player1.clear()
        player2.clear()
        activePlayer = 1

        bu1.isEnabled = true
        bu2.isEnabled = true
        bu3.isEnabled = true
        bu4.isEnabled = true
        bu5.isEnabled = true
        bu6.isEnabled = true
        bu7.isEnabled = true
        bu8.isEnabled = true
        bu9.isEnabled = true
    }

    fun buClick(view: View){
        val buSelected = view as Button
        var cellID = 0
        when(buSelected.id) {
            R.id.bu1 -> cellID = 1
            R.id.bu2 -> cellID = 2
            R.id.bu3 -> cellID = 3
            R.id.bu4 -> cellID = 4
            R.id.bu5 -> cellID = 5
            R.id.bu6 -> cellID = 6
            R.id.bu7 -> cellID = 7
            R.id.bu8 -> cellID = 8
            R.id.bu9 -> cellID = 9
        }
        playGame(cellID, buSelected)
    }

    private fun playGame(cellID: Int, buSelected: Button) {
        if(activePlayer==1){
            buSelected.text = "X"
            buSelected.setBackgroundColor(Color.parseColor("#ffa500"))
            player1.add(cellID)
            activePlayer = 2
        }else{
            buSelected.text = "O"
            buSelected.setBackgroundColor(Color.parseColor("#add8e6"))
            player2.add(cellID)
            activePlayer = 1
        }
        buSelected.isEnabled = false
        checkWinner()
    }

    private fun checkWinner() {
        var winner = -1
        //row1
        if(player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner = 2
        }
        ///row2
        if(player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner = 1
        }
        if(player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner = 2
        }
        //row3
        if(player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner = 2
        }

        //col1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }
        //col2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }
        //col3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        if(winner != -1){
            if(winner == 1){
                Toast.makeText(this, "Player 1 won this game.", Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Player 2 won this game.", Toast.LENGTH_LONG).show()
            }
        }
    }
}
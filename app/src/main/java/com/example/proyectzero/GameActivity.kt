package com.example.proyectzero

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_game.*


class GameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        iniciar()
    }
    var live = 200
    var damage = 0
    var heal = 0
    var score = 0
    var monsterDamage = 0
    var monsterLive = (100 until 280).random()

    fun iniciar(){
        textMonsterLive.text = monsterLive.toString()
        textGame.text = "Oh no un mounstro ha aparecido"
        textLive.text = live.toString()
    }

     fun getAttackDamage(number: Number): Int {
        var number = (0 until 30).random()
        var item = (3..6).random()
        if(number >= 8){
            number += item
        }
        return number
    }

    fun getMonsterAttack(number: Number): Int
    {
        var number = (0 until 30).random()
        return number

    }
    fun attackPress(view: View) {
        textGame.text = "Atacaste al enemigo"
        
        damage = getAttackDamage(damage)
        textDamageToMonster.text = damage.toString()
        monsterLive -= damage
        score = damage * 10
    }

    fun healPress(view: View) {
        textGame.text="Te haz curado"
        heal = (0..10).random()
        if (live >= 30) {
            heal *= 2
        }else if(live >=200){
            heal *= 0
            live = 200
        }
        live += heal
    }
    fun retreatPress(view: View) {
        textGame.text = "RETIRADA!!!"
        monsterDamage = getMonsterAttack(monsterDamage)
        textMonsterDamage.text = monsterDamage.toString()

    }


}



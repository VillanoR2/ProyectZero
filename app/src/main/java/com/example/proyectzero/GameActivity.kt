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
        textMonsterLive.text = "Monster: " +  monsterLive.toString()
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
        var btnhealButton = findViewById<Button>(R.id.healButton)
        var btnattackButton = findViewById<Button>(R.id.attackButton)
        var btnreatreatButton = findViewById<Button>(R.id.retreatButton)

        if(live > 0) {
            textGame.text = "Atacaste al enemigo"

            if(monsterLive > 0)
            {
                damage = getAttackDamage(damage)
                textDamageToMonster.text = damage.toString()
                monsterLive -= damage
                actualizarDamage(damage)
                actualizarMonsterLive(monsterLive)
                score += damage * 10
                btnattackButton.isEnabled = false
            }
            if(monsterLive <= 0)
            {
                textGame.text = "Has matado al mounstro, tu SCORE es :" + score.toString()
                btnattackButton.isEnabled = false
                btnhealButton.isEnabled = false
            }
        }else{
            textGame.text = "Haz muerto, tu score es:  "+ score .toString()
            btnattackButton.isEnabled = false
            btnhealButton.isEnabled = false
            btnreatreatButton.isEnabled = false
        }
    }

    fun healPress(view: View) {
        var btnhealButton = findViewById<Button>(R.id.healButton)
        textGame.text="Tomando pocion..."

        if(live < 200)
        {
            heal = (0..10).random()
            if (live >= 30)
            {
                heal *= 2
            }
            else if(live >=200)
            {
                heal *= 0
                live = 200
            }
            live += heal
            textGame.text = "Te haz curado: " + heal.toString() + " puntos "
            actualizarLive(live)
            btnhealButton.isEnabled = false
        }else{
            textGame.text = "Tu vida esta al máximo..."

        }

    }

    fun retreatPress(view: View) {
        var btnhealButton = findViewById<Button>(R.id.healButton)
        var btnattackButton = findViewById<Button>(R.id.attackButton)

        textGame.text = "Turno finalizado"
        monsterDamage = getMonsterAttack(monsterDamage)

        actualizarMonsterDamage(monsterDamage)
        live -= monsterDamage
        actualizarLive(live)


        if(!btnhealButton.isEnabled and !btnattackButton.isEnabled)
        {
            btnhealButton.isEnabled = true
            btnattackButton.isEnabled = true
            textGame.text = "Iniciando Turno"
        }

    }
    fun actualizarLive(number: Number){
        textLive.text = "Vida: "+number.toString()
    }
    fun actualizarDamage(number: Number){
        textDamageToMonster.text = "Ataque: "+ number.toString()
    }
    fun actualizarMonsterLive(number: Number){
        textMonsterLive.text = "Mounstro: "+ number.toString()
    }
    fun actualizarMonsterDamage(number: Number){
        textMonsterDamage.text = "Ataque: "+ number.toString()
    }

}



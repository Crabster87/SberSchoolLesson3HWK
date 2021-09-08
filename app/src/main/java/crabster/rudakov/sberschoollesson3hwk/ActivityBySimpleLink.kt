package crabster.rudakov.sberschoollesson3hwk

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ActivityBySimpleLink : AppCompatActivity() {

    private lateinit var simpleLinkResult1: TextView
    private lateinit var simpleLinkResult2: TextView
    private lateinit var actor1: String
    private lateinit var actor2: String
    private val ACTOR1_KEY: String = "actor1"
    private val ACTOR2_KEY: String = "actor2"
    private var postfix: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_by_simple_link)

        val data: Uri? = intent?.data
        actor1 = data!!.getQueryParameter(ACTOR1_KEY)!!
        actor2 = data.getQueryParameter(ACTOR2_KEY)!!

        simpleLinkResult1 = findViewById(R.id.simple_link_result1)
        simpleLinkResult1.text = actor1
        simpleLinkResult2 = findViewById(R.id.simple_link_result2)
        simpleLinkResult2.text = actor2

        val simpleLinkImage1: ImageView? = findViewById(R.id.simple_link_image1)
        simpleLinkImage1!!.setImageResource(R.drawable.schwarzenegger)
        val simpleLinkImage2: ImageView? = findViewById(R.id.simple_link_image2)
        simpleLinkImage2!!.setImageResource(R.drawable.van_damm)

        relaunchCurrentActivity()
    }

    /**
     * По нажатию кнопки имена актёров кладём в интент и перезапускаем текущую singleTask Activity
     */
    private fun relaunchCurrentActivity() {
        val asSingleTop: Button = findViewById(R.id.as_singleTop)
        asSingleTop.setOnClickListener {
            val intent = Intent(this, ActivityBySimpleLink::class.java)
            intent.putExtra(ACTOR1_KEY, actor1)
            intent.putExtra(ACTOR2_KEY, actor2)
            startActivity(intent)
        }
    }

    /**
     * Получаем имена актёров из интента и добавляем счётчик вызовов текущей singleTask Activity
     */
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        postfix++
        val newActor3: String? = intent?.extras?.getString(ACTOR1_KEY)
        val newActor4: String? = intent?.extras?.getString(ACTOR2_KEY)
        simpleLinkResult1.text = "$newActor3 $postfix"
        simpleLinkResult2.text = "$newActor4 $postfix"
    }
}
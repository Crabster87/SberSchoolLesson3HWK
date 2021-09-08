package crabster.rudakov.sberschoollesson3hwk

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class ActivityByDeepLink : AppCompatActivity() {

    private lateinit var simpleLinkResult3: TextView
    private lateinit var simpleLinkResult4: TextView
    private lateinit var actor3: String
    private lateinit var actor4: String
    private val ACTOR3_KEY: String = "actor3"
    private val ACTOR4_KEY: String = "actor4"
    private var postfix: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_by_deep_link)

        val data: Uri? = intent?.data
        actor3 = data!!.getQueryParameter(ACTOR3_KEY)!!
        actor4 = data.getQueryParameter(ACTOR4_KEY)!!

        simpleLinkResult3 = findViewById(R.id.simple_link_result3)
        simpleLinkResult3.text = actor3
        simpleLinkResult4 = findViewById(R.id.simple_link_result4)
        simpleLinkResult4.text = actor4

        val simpleLinkImage3: ImageView? = findViewById(R.id.simple_link_image3)
        simpleLinkImage3!!.setImageResource(R.drawable.stallone)
        val simpleLinkImage4: ImageView? = findViewById(R.id.simple_link_image4)
        simpleLinkImage4!!.setImageResource(R.drawable.lundgren)

        relaunchCurrentActivity()
    }

    /**
     * По нажатию кнопки имена актёров кладём в интент и перезапускаем текущую singleTask Activity
     */
    private fun relaunchCurrentActivity() {
        val asSingleTask: Button = findViewById(R.id.as_singleTask)
        asSingleTask.setOnClickListener {
            val intent = Intent(this, ActivityByDeepLink::class.java)
            intent.putExtra(ACTOR3_KEY, actor3)
            intent.putExtra(ACTOR4_KEY, actor4)
            startActivity(intent)
        }
    }

    /**
     * Получаем имена актёров из интента и добавляем счётчик вызовов текущей singleTask Activity
     */
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        postfix++
        val newActor3: String? = intent?.extras?.getString(ACTOR3_KEY)
        val newActor4: String? = intent?.extras?.getString(ACTOR4_KEY)
        simpleLinkResult3.text = "$newActor3 $postfix"
        simpleLinkResult4.text = "$newActor4 $postfix"
    }
}
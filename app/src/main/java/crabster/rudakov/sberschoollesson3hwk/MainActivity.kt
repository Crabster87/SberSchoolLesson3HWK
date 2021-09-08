package crabster.rudakov.sberschoollesson3hwk

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val linkView: TextView = findViewById(R.id.link_View)
        linkView.movementMethod = LinkMovementMethod.getInstance();

        val deepLinkView: TextView = findViewById(R.id.deepLink_View)
        deepLinkView.movementMethod = LinkMovementMethod.getInstance();
    }
}
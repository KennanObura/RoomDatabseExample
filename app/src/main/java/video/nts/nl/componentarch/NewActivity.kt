package video.nts.nl.componentarch

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_new.*
import android.text.TextUtils



class NewActivity : AppCompatActivity() {

    companion object{
        const val EXTRA_REPLY = "com.example.android.wordlistsql.REPLY"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new)

        val mEditWordView = this.edit_word


        this.button_save.setOnClickListener(View.OnClickListener() {

            val replyIntent = Intent()

            if (TextUtils.isEmpty(mEditWordView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val word = mEditWordView.text.toString()
                replyIntent.putExtra(EXTRA_REPLY, word)
                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish()

        })
    }
}

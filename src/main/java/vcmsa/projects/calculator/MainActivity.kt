package vcmsa.projects.calculator



import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val num1EditText: EditText = findViewById(R.id.num1)
        val num2EditText: EditText = findViewById(R.id.num2)
        val addButton: Button = findViewById(R.id.btn_add)
        val answerTextView: TextView = findViewById(R.id.answer)

        addButton.setOnClickListener{
            val num1Str = num1EditText.text.toString()
            val num2Str = num2EditText.text.toString()

            if (num1Str.isNotEmpty() && num2Str.isNotEmpty()){
                try{
                    val num1 = num1Str.toInt()
                    val num2 = num2Str.toInt()
                    val sum = num1 + num2
                    answerTextView.text = sum.toString()
                } catch (e: NumberFormatException) {
                    answerTextView.text = "Invalid input. Please enter numbers."
                }
            } else {
                answerTextView.text = "Please enter both numbers."
            }
        }
    }
}

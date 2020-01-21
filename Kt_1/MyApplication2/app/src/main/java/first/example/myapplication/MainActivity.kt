package first.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //안드로이드와 다르게 여기서 선언을 안해주어도 가능
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //함수정의
        //fun 함수임을 나타냄 //main 함수이름
        //args : Array<String> 함수 인자를 나타낼 때 변수명:타입 순서대로


        btn_Helloworld.setOnClickListener()
        {
            //함수 호출
            Toast.makeText(this,"Hello, World!", Toast.LENGTH_SHORT).show()
            //로그 없으면 개발 못함
            Log.e("1","로그")

        }
    }
}

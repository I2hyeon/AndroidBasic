package com.example.activity

import android.app.Activity
import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.activity.databinding.ActivityMainBinding

const val TAG = "myLog"

class MainActivity : AppCompatActivity() {

    // private var binding : ActivityMainBinding? = null
    private lateinit var binding: ActivityMainBinding
    private var count = 1;

    // 전역으로 사용할 변수
    private var cnt = 1

    // 액티비티 콜백을 받기 위한 멤버변수
    var activityLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        Log.d(TAG, ": 콜백 실행됨 $it" )
        if (it.resultCode == Activity.RESULT_OK) {
            // 성공시 실행할 코드를 동작 - data를 받는게 가능함
            var callback = it.data?.getStringExtra("callback")
            Toast.makeText(this, "콜백데이터 :$callback", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // View Binding 초기화
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // setContentView(R.layout.activity_main)

        // 기존방식
        // var tvView : TextView = findViewById(R.id.ex_text)
        // tvView.setOnClickListener {}

        // 뷰바인딩 방식 - 아이디는 카멜표기법으로
        binding.exText.setOnClickListener {
            Toast.makeText(this, "클릭", Toast.LENGTH_SHORT).show()
        }

//        // 초기 값 설정
//        binding.increaseText.text = count.toString()
//
//        // 버튼 클릭 이벤트
//        binding.increaseBtn.setOnClickListener {
//            count++
//            binding.increaseText.text = count.toString()
//        }

        // 실습
        binding.increaseBtn.setOnClickListener {

            var cnt = binding.increaseText.text.toString().toInt().plus(1)
            binding.increaseText.text = cnt.toString()
        }

        // 인텐트 전환하기
        binding.changeBtn.setOnClickListener {

//            val intent = Intent(this, MyIntent::class.java) // 컨텍스트, 실행시킬 클래스
//            intent.putExtra("data1", "홍길동")
//            intent.putExtra("data2", 20)
//
//            startActivity(intent)

            // 액티비티 콜백 런처
            val intent = Intent(this, MyIntent::class.java)
            activityLauncher.launch(intent) // 인텐트 실행
        }
    }
    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: 액티비티 생성 후 시작")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume: 액티비티 시작 재개")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause: 액티비티 일시정지")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop: 액티비티 정지")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(TAG, "onRestart: 액티비티 재시작") // Restart -> start -> resume
    }

    override fun onDestroy() {
      super.onDestroy()
      Log.d(TAG, "onDestroy: 액티비티 종료")
    }

    // 액티비티의 상태를 저장할 때
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        
        // onStop 이후에 동작을 하고 bundle에 값을 저장할 수 있음
        // 돌아갈 때 저장을 시키고
        Log.d(TAG, "onSaveInstanceState: 실행됨")

        outState.putString("data1", "홍길동")
        outState.putInt("data2", cnt)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        // onStart 이후에 실행됨
        Log.d(TAG, "onRestoreInstanceState: 실행됨")

        // 생성될 때 다시 저장
        var name = savedInstanceState.getString("data1")
        cnt = savedInstanceState.getInt("data2")
        binding.increaseText.text=cnt.toString() // 값 유지
    }


}
package com.example.roomdatabase

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.log
import kotlin.system.measureTimeMillis

const val TAG = "myLog"

class CoroutinActivity : AppCompatActivity() {

    suspend fun example1(): String {
        delay(2000)
        return "result 1"
    }

    suspend fun example2(): String {
        delay(1000)
        return "result 2"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutin)

        // 코루틴 - 비동기 라이크, 협동 루틴
        // suspend는 일시 중단 가능한 함수이고 비동기적인 코드에서 사용합니다.
        // suspend를 호출하려면 suspend 함수 or 코루틴 스코프 이어야 합니다.

//        lifecycleScope.launch {
//
//            var time = measureTimeMillis { // 시간이 얼마나 걸리는지
//                Log.d(TAG, "onCreate: 1. 코루틴 실행")
//                var result1 = example1()
//                var result2 = example2()
//                Log.d(TAG, "onCreate: $result1")
//                Log.d(TAG, "onCreate: $result2")
//            }
//
//            Log.d(TAG, "onCreate: 2. 실행시간: $time")
//        }

        Log.d(TAG, "OnCreate: 3. 코루틴 블럭 탈출")
    }
}
package com.example.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // 리사이클러 뷰 영역에 adapter를 연결.
        val adapter = TodoAdapter( TodoList.getTodoList() )
        binding.reTodolist.adapter = adapter
        binding.reTodolist.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false )
    }
}
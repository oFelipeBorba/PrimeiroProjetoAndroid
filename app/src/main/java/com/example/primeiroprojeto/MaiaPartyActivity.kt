package com.example.primeiroprojeto

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class MaiaPartyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maia_party)
        Log.i(TAG, "$CHAMADA onCreate")
    }
    companion object {
        private const val TAG = "tagInfo"
        private const val CHAMADA = "MaiaPartyActivity ::"
    }
}
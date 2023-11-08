package com.example.android_native_spike

import android.content.Context
import android.os.Bundle
import io.flutter.embedding.android.FlutterActivity
import androidx.fragment.app.FragmentActivity
import io.flutter.embedding.android.FlutterFragment
import androidx.fragment.app.FragmentManager
import android.content.Intent
import androidx.annotation.NonNull
import android.widget.TextView
import android.widget.Button


class MainActivityMix : FragmentActivity() {
    companion object {
        private const val TAG_FLUTTER_FRAGMENT = "CARD_LIST"
    }
    private var flutterFragment: FlutterFragment? = null

    override fun onNewIntent(@NonNull intent: Intent) {
        super.onNewIntent(intent)
        flutterFragment!!.onNewIntent(intent)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        flutterFragment!!.onRequestPermissionsResult(
            requestCode,
            permissions,
            grantResults
        )
    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        flutterFragment!!.onActivityResult(
            requestCode,
            resultCode,
            data
        )
    }

    override fun onUserLeaveHint() {
        flutterFragment!!.onUserLeaveHint()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        flutterFragment!!.onTrimMemory(level)
    }
    //work
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.my_activity_layout)
        val fragmentManager: FragmentManager = supportFragmentManager
        flutterFragment = fragmentManager
            .findFragmentByTag(TAG_FLUTTER_FRAGMENT) as FlutterFragment?

        if (flutterFragment == null) {
            var newFlutterFragment = FlutterFragment.createDefault()
            flutterFragment = newFlutterFragment
            fragmentManager
                .beginTransaction()
                .add(
                    R.id.fragment_container,
                    newFlutterFragment,
                    TAG_FLUTTER_FRAGMENT
                )
                .commit()
        }

        val greetingText: TextView = findViewById(R.id.greeting_text)
        val button: Button = findViewById(R.id.my_button)
        button.setOnClickListener {
            startFlutterActivity(this@MainActivityMix)
        }
    }
    fun startFlutterActivity(context: Context) {
        context.startActivity(
            FlutterActivity
                .withCachedEngine(MyApplication.FLUTTER_ENGINE_NAME)
                .build(context)
        )
    }

}


package com.butovanton.viewmodelreaserch

import android.app.Activity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelStoreOwner
import com.butovanton.viewmodelreaserch.ui.theme.ViewModelReaserchTheme

class MainActivity : Activity() {

    private var data = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val textView = TextView(this).apply {
            text = lastNonConfigurationInstance as? String
        }
        addContentView(
            LinearLayout(this).apply {
                orientation = LinearLayout.VERTICAL
                addView(textView)
                addView(
                    EditText(context).apply {
                        addTextChangedListener { text ->
                            textView.text = text
                            data = text.toString()
                        }
                    }
                )
            },
            ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
        )
    }

    override fun onRetainNonConfigurationInstance(): Any {
        return data
    }
}
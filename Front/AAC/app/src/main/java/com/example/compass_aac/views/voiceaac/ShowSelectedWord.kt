/** Project : 2023 AAC Compass
 * Program Purpose and Features :
 * - aac 단어들 선택 후 문장으로 보여지는 화면
 * Author : ES.KEE
 * First Write Date : 2023.07.14
 * ==========================================================================
 * Program history
 * ==========================================================================
 * Author            Date            Version        History        code to fix
 **/

package com.example.compass_aac.views.voiceaac

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.compass_aac.R

class ShowSelectedWord : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_selected_word)
    }
}
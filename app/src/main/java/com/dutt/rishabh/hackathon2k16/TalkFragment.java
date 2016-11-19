package com.dutt.rishabh.hackathon2k16;


import android.content.Context;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

import static android.R.attr.name;
import static android.app.Activity.RESULT_OK;


/**
 * A simple {@link Fragment} subclass.
 */
public class TalkFragment extends Fragment {
    //EditText name;
    //TextToSpeech tts;
    //private Context globalContext = null;

    public TalkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_talk, container, false);
      final TextToSpeech  tts =new TextToSpeech(v.getContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                // Toast.makeText(MainActivity.this, "Engine is initialized", Toast.LENGTH_SHORT).show();
            }
        });
       final EditText name=(EditText)v.findViewById(R.id.editText);
      Button  speakbtn=(Button)v.findViewById(R.id.button);
        speakbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=name.getText().toString();
                tts.speak(s1, RESULT_OK, null);
                tts.setLanguage(Locale.UK);
            }
        });
        return v;
    }
}

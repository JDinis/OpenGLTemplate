package com.opengl.jei.opengltemplate;

import android.opengl.GLSurfaceView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private GLSurfaceView myGLView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criação de uma instancia da GLSurfaceView e atribuir
        // ao ContentView desta actividade.
        myGLView = new MyGLSurfaceView(this);
        setContentView(myGLView);
    }
}

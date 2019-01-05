package com.opengl.jei.opengltemplate;

import android.opengl.GLES32;
import android.opengl.GLSurfaceView.Renderer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class MyGLRenderer implements Renderer {

    /**
     * Quando a superficie for criada
     * @param gl - não utilizado
     * @param config - configuração do opengl
     */
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        /**
         * Atribui a cor a frame de background
         * neste caso a cor preta sem opacidade
         */
        GLES32.glClearColor(0.0f,0.0f,0.0f, 1.0f);
    }

    /**
     * Quando a superficie for alterada
     * @param gl - não utilizado
     * @param width - Largura do ViewPort
     * @param height - Altura do ViewPort
     */
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        /**
         * x && y - Coordenadas iniciais do ViewPort
         */
        GLES32.glViewport(0,0,width,height);
    }

    /**
     * Quando uma frame estiver para ser desenhada
     * @param gl - não utilizado
     */
    @Override
    public void onDrawFrame(GL10 gl) {
        /**
         * Redesenha a cor do background
         */
        GLES32.glClear(GLES32.GL_COLOR_BUFFER_BIT);
    }
}

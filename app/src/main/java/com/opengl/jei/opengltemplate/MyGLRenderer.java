package com.opengl.jei.opengltemplate;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView.Renderer;
import android.opengl.GLU;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

class MyGLRenderer implements Renderer {

    Piramide piramide;
    private Context context;
    private static float anguloPiramide = 0; // Ângulo de rotação

    public MyGLRenderer(Context context){
        this.context = context;

        piramide = new Piramide();
    }

    /**
     * Quando a superficie for criada
     * @param config - configuração do opengl
     */
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {
        /**
         * Atribui a cor a frame de background
         * neste caso a cor preta sem opacidade
         */
        GLES20.glClearColor(0.0f,0.0f,0.0f, 1.0f);
        GLES20.glClearDepthf(1.0f); // Definir profundidade para limpar
        gl.glClearDepthf(1.0f); // Definir profundidade para limpar
        gl.glEnable(GL10.GL_DEPTH_TEST); // Permite profundidade do buffer e remove a superfície
        gl.glDepthFunc(GL10.GL_LEQUAL); // Teste de profundidade a fazer
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_NICEST); // Boa perspetiva de visualização
        gl.glShadeModel(GL10.GL_SMOOTH); // Ativar sombreamento suave de cor
        gl.glDisable(GL10.GL_DITHER); //Desativar composição das cores para melhorar a performance
    }

    /**
     * Quando a superficie for alterada
     * @param width - Largura do ViewPort
     * @param height - Altura do ViewPort
     */
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
        if (height == 0)
            height = 1; // Previnir a divisão por 0
        float aspect = (float) width / height;

        // Definir a viewport (área de exibição) para cobrir toda a janela
        gl.glViewport(0,0,width,height);

        // Configurar projeção perspectiva, com a relação de aspecto correspondente ao viewport
        gl.glMatrixMode(GL10.GL_PROJECTION); // Selecionar projeção matriz
        gl.glLoadIdentity(); // Reset projeção matriz

        GLU.gluPerspective(gl, 45, aspect, 0.1f, 100.f); // Usar Projeção perspetiva

        // Selecionar matriz model-view
        gl.glMatrixMode(GL10.GL_MODELVIEW);
        gl.glLoadIdentity(); // Reset
    }

    /**
     * Quando uma frame estiver para ser desenhada
     */
    @Override
    public void onDrawFrame(GL10 gl) {
        /**
         * Redesenha a cor do background
         */
        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

        // -- Renderizar a Piramide --
        gl.glLoadIdentity(); // Reiniciar a matriz model-view
        gl.glTranslatef(0f, -0.9f, -6f); // Tanslação para a esquerda, para baixo e no ecrã
        gl.glRotatef(anguloPiramide++, 0f, 1.0f, 0f); //Rotação em relação ao eixo dos y
        gl.glScalef(0.5f,0.5f,0.5f); // Encolhe a piramide
        piramide.draw(gl); // Desenhar a piramide
    }
}

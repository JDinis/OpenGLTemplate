package com.opengl.jei.opengltemplate;

import android.content.Context;
import android.opengl.GLSurfaceView;

public class MyGLSurfaceView extends GLSurfaceView {

    private final MyGLRenderer myRenderer;

    /**
     * Surface que servira de canvas para se desenhar
     * @param context - Contexto da applicação
     */
    public MyGLSurfaceView(Context context) {
        super(context);

        /**
        * Cria um contexto para o OpenGL ES 3.2
        **/
        setEGLContextClientVersion(3);

        /**
         * Foi Escolhida uma configuração com uma cor RGBA8, 16 bits de depth sem estencile
         * suportando OpenGL ES 3.2 e retro-compatiblidade.
         */
        setEGLConfigChooser(8, 8, 8, 0, 16, 0);

        myRenderer = new MyGLRenderer();

        /**
         * Indica qual o Renderer a usar que ira desenhar na GLSurfaceView
         */
        setRenderer(myRenderer);

        /**
         * Indica o Modo de Renderização
         * RENDERMODE_WHEN_DIRTY - Renderização apenas feita quando se altera a GLSurfaceView
         * RENDERMODE_CONTINUOUSLY - Renderização de forma continua
         * (actualizando a surface de x em x frames) a GLSurfaceView
         */
        setRenderMode(GLSurfaceView.RENDERMODE_CONTINUOUSLY);
    }
}
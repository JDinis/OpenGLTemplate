package com.opengl.jei.opengltemplate;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Piramide {
    private FloatBuffer vertexBuffer;  // Buffer para vertex-array
    private FloatBuffer colorBuffer;   // Buffer para color-array
    private ByteBuffer indexBuffer;    // Buffer para index-array

    private float[] vertices = { // 5 vertices da piramide em (x,y,z)
            -1.0f, -1.0f, -1.0f,  // 0. inferior, esquerda, atrás
            1.0f, -1.0f, -1.0f,  // 1. inferior, direita, atrás
            1.0f, -1.0f,  1.0f,  // 2. inferior, direita, frente
            -1.0f, -1.0f,  1.0f,  // 3. inferior, esquerda, frente
            0.0f,  1.0f,  0.0f   // 4. topo
    };

    private float[] colors = {  // Cores para os 5 vertices em RGBA
            0.0f, 0.0f, 1.0f, 1.0f,  // 0. azul
            0.0f, 1.0f, 0.0f, 1.0f,  // 1. verde
            0.0f, 0.0f, 1.0f, 1.0f,  // 2. azul
            0.0f, 1.0f, 0.0f, 1.0f,  // 3. verde
            1.0f, 0.0f, 0.0f, 1.0f   // 4. vermelho
    };

    private byte[] indices = { // Indices dos vértices dos 6 triângulos
            2, 4, 3,   // face da frente (CCW)
            1, 4, 2,   // face da direita
            0, 4, 1,   // face de trás
            4, 0, 3,   // face da esquerda
            1, 2, 0,   // Base (triangulo)
            0, 2, 3	  // Base (triangulo)
    };

    // Construtor - Configura os buffers
    public Piramide() {
        // Configuração do buffer vertex-array. Vertices em float. Um float tem 4 bytes
        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        vertexBuffer = vbb.asFloatBuffer(); // Converte de byte para float
        vertexBuffer.put(vertices);         // Copia os dados para o buffer
        vertexBuffer.position(0);           // Rewind (Posição inicial)

        // Configuração do buffer color-array. Cores em float. Um float tem 4 bytes
        ByteBuffer cbb = ByteBuffer.allocateDirect(colors.length * 4);
        cbb.order(ByteOrder.nativeOrder());
        colorBuffer = cbb.asFloatBuffer();
        colorBuffer.put(colors);
        colorBuffer.position(0);

        // Configuração do buffer index-array. Indices em byte
        indexBuffer = ByteBuffer.allocateDirect(indices.length);
        indexBuffer.put(indices);
        indexBuffer.position(0);
    }

    // Desenha a pirâmide
    public void draw(GL10 gl) {
    }
}

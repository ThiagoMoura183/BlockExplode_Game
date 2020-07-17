package com.example.blocksexplode;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class GameElement {

    protected CannonView view; // View que contém o GameElement
    protected Paint paint = new Paint(); // Desenha esse GameElement
    protected Rect shape; // Define os limites retangulares desse GameElement
    private float velocityY; // A velocidade VERTICAL desse GameElement
    private int soundId; // O som associado com esse GameElement

    public GameElement(CannonView view, int color, int soundId, int x, int y, int width, int length, float velocityY) {
        this.view = view;
        paint.setColor(color);

        // Definir os limites
        shape = new Rect(x, y,x+width,y+length);
        this.soundId = soundId;
        this.velocityY = velocityY;
    }

    //Atualizar a posição do GameElement e verificar colisões de borda
    public void update (double interval) { // Interval é o tempo que demora para se deslocar
        // Atualiza posição vertical
        shape.offset(0, (int) (velocityY*interval));

        // Caso o GameElement colida com a borda, inverter a direção
        if (shape.top < 0 && velocityY < 0 || shape.bottom > view.getScreenHeight() && velocityY > 0)
            velocityY *= -1; //Inverter a velocidade do GameElement
    }

    // Desenha o GameElement no objeto Canvas dado
    public void draw(Canvas canvas) {
        canvas.drawRect(shape, paint);
    } // O canvas é como a tela do paint

    // Reproduz o som correspondente a esse tipo de GameElement
    public void playSound() {
        view.playSound(soundId);
    }

}






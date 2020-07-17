package com.example.blocksexplode;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;

public class Cannon {
    private int baseRadius; // Raio da base do canhão
    private int barrelLength; // Comprimento do cano -- É a linha
    private Point barrelEnd = new Point(); // Ponto extremo do cano
    private double barrelAngle; // Ângulo do cano
    private Cannonball cannonball; // A bala do canhão
    private Paint paint = new Paint(); // Objeto Paint usado para desenhar o canhão
    private CannonView view; // View que tem o canhão

    public Cannon(CannonView view, int baseRadius, int barrelLength, int barrelWidth) {
        this.view = view;
        this.baseRadius = baseRadius;
        this.barrelLength = barrelLength;
        paint.setStrokeWidth(barrelWidth); // Configura a largura do cano
        paint.setColor(Color.BLACK); // Cor do canhão (Preto)
        align(Math.PI/2); // Cano do canhão voltado para a direita
    }

    // Alinha o cano do canhão com o ângulo dado
    public void align(double barrelAngle) {
        this.barrelAngle = barrelAngle;
        barrelEnd.x = (int) (barrelLength * Math.sin(barrelAngle));
        barrelEnd.y = (int) (-barrelLength * Math.cos(barrelAngle)) + view.getScreenHeight() / 2;
    }

    // Cria e dispara a bala na direção apontada pelo canhão
    public void fireCannonball() {
        // Calcula o componente x da velocidade da bala
        int velocityX = (int) (CannonView.CANNONBALL_SPEED_PERCENT * view.getScreenWidth() * Math.sin(barrelAngle));

        // Calcula o componente Y da velocidade da bala
        int velocityY = (int) (CannonView.CANNONBALL_SPEED_PERCENT * view.getScreenWidth() * -Math.cos(barrelAngle));

        // Calcula o raio da bala
        int radius = (int) (view.getScreenHeight() * CannonView.CANNONBALL_RADIUS_PERCENT);

        // Constrói a bala e posiciona no canhão
        cannonball = new Cannonball(view,Color.BLACK, CannonView.CANNON_SOUND_ID, -radius,view.getScreenHeight() /2 - radius, radius, velocityX, velocityY);
    }

    // Desenha o canhão no objeto Canvas
    public void draw(Canvas canvas) {
        // Desenha o cano do canhão
        canvas.drawLine(0, view.getScreenHeight() / 2, barrelEnd.x, barrelEnd.y, paint);

        // Desenha a base do canhão
        canvas.drawCircle(0, (int) view.getScreenHeight() / 2, (int) baseRadius, paint);
    }

    // Retorna a bala disparada pelo canhão
    public Cannonball getCannonball() {
        return cannonball;
    }

    // Remove a bala do jogo
    public void removeCannonball() {
        cannonball = null;
    }
}

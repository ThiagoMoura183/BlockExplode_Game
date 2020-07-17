package com.example.blocksexplode;

public class Target extends GameElement {
    private int hitReward; // A recompensa por acertar o alvo

    public Target(CannonView view, int color, int hitReward, int x, int y, int width, int length, float velocityY) {
        super(view, color, CannonView.TARGET_SOUND_ID, x, y, width, length, velocityY);
        this.hitReward = hitReward;
    }

    // Retorna a recompensa pelo acerto
    public int getHitReward() {
        return hitReward;
    }
}

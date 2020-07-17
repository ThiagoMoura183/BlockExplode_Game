package com.example.blocksexplode;

public class Blocker extends GameElement {
    private int missPenalty; // A penalidade por acertar a barreira

    public Blocker(CannonView view, int color , int missPenalty, int x, int y, int width, int length, float velocityY) {
        super(view, color, CannonView.BLOCKER_SOUND_ID, x, y, width, length, velocityY);
        this.missPenalty = missPenalty;
    }

    // Retornar o valor da penalidade por erro
    public int getMissPenalty() {
        return missPenalty;
    }
}

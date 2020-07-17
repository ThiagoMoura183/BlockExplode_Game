package com.example.blocksexplode;

import android.media.AudioManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class MainActivityFragment extends Fragment {
    // View que mostra o jogo
    private CannonView cannonView;

    // Chamado quando a view do fragment precisa ser criada
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //Infla o layout fragment_main.xml
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        //Obtém a referência para o componente CannonView
        cannonView = (CannonView) view.findViewById(R.id.cannonView);
        return view;
    }

    @Override
    // Configura o controle do volume quando a atividade é criada
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Permite que os botões de volume do aparelho configura o volume do jogo
        getActivity().setVolumeControlStream(AudioManager.STREAM_MUSIC);
    }

    @Override
    // Quando Main é pausado, termina o game
    public void onPause() {
        super.onPause();
        cannonView.stopGame(); // Termina o jogo
    }

    @Override
    // Quando Main é pausado, o MainActivityFragment libera os recursos
    public void onDestroy() {
        super.onDestroy();
        cannonView.releaseResources();
    }
}
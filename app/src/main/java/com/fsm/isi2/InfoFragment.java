package com.fsm.isi2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class InfoFragment extends Fragment {
TextView numero,prenom,nom,formation;
    View view;
    public interface InfoFragmentEventListener {
        public void precedantClicked();
        public void suivantClicked();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        // Defines the xml file for the fragment
        Bundle params = getArguments();
         view = inflater.inflate(R.layout.fragment_info,
                parent, false);


        numero = view.findViewById(R.id.num_id);
        prenom = view.findViewById(R.id.prenom_id);
        nom = view.findViewById(R.id.nom_id);
        formation = view.findViewById(R.id.formation_id);

        numero.setText(params.getString("i"));
        prenom.setText(params.getString("prenom"));
        nom.setText(params.getString("nom"));
        formation.setText(params.getString("formation"));

        InfoFragmentEventListener infoFragmentEventListener = (InfoFragmentEventListener)getActivity();


        //return inflater.inflate(R.layout.fragment_info, parent, false);
        Button btnprec = view.findViewById(R.id.prec_btn);
        Button btnsuiv = view.findViewById(R.id.suiv_btn);

        btnprec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoFragmentEventListener.precedantClicked();
            }
        });
        btnsuiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                infoFragmentEventListener.suivantClicked();
            }
        });



        return view;
    }


    public void afficherEtudiant  (String  _nom,  String  _prenom,  String  _formation,String _numero){
        numero.setText(_numero+"");
        nom.setText(_nom+"");
        prenom.setText(_prenom+"");
        formation.setText(_formation+"");

    }


}

package com.fsm.isi2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class infoActivity extends AppCompatActivity implements InfoFragment.InfoFragmentEventListener{
    ArrayList listEtudiants;
    InfoFragment fragment;
    Vector  v1,v2,v3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        listEtudiants = new ArrayList();
         v1 = new Vector();
         v2 = new Vector();
         v3 = new Vector();
        v1.add("ali");
        v1.add("mouhamed");
        v1.add("lsi3");
        v2.add("amine");
        v2.add("mabrouk");
        v2.add("mpisi 1");
        v3.add("omar");
        v3.add("belhaj");
        v3.add("mpisi 2");

        listEtudiants.add(v1);
        listEtudiants.add(v2);
        listEtudiants.add(v3);



         fragment = new InfoFragment();
        Bundle params = new Bundle();
        Vector itemVector = (Vector) listEtudiants.get(2);

        params.putString( "i","3/"+listEtudiants.size());
        params.putString( "prenom",itemVector.get(0).toString());
        params.putString( "nom",itemVector.get(1).toString());
        params.putString( "formation",itemVector.get(2).toString());
        fragment.setArguments(params);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.llInfoContainer, fragment);
        ft.commit();

    }

    @Override
    public void precedantClicked() {

        String index = fragment.numero.getText().toString().split("/")[0];
        int i = Integer.parseInt(index)-1;
        if (i==0){
            i=listEtudiants.size()-1;
        }
        else {
            i=i-1;
        }
        Vector itemVector = (Vector) listEtudiants.get(i);
        String indice = i+1+"/"+listEtudiants.size();
        fragment.afficherEtudiant(itemVector.get(0).toString(),itemVector.get(1).toString(),itemVector.get(2).toString(),indice);

    }

    @Override
    public void suivantClicked() {

        String index = fragment.numero.getText().toString().split("/")[0];
        int i = Integer.parseInt(index)-1;
        if (i==listEtudiants.size()-1){
            i=0;
        }
        else {
            i=i+1;
        }
        Vector itemVector = (Vector) listEtudiants.get(i);
        String indice = i+1+"/"+listEtudiants.size();
        fragment.afficherEtudiant(itemVector.get(0).toString(),itemVector.get(1).toString(),itemVector.get(2).toString(),indice);

    }


    }



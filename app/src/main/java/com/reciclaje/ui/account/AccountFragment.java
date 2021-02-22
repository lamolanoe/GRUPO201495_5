package com.reciclaje.ui.account;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.reciclaje.MainActivity;
import com.reciclaje.Editar;
import com.reciclaje.Mostrar;
import com.reciclaje.R;

public class AccountFragment extends Fragment {

    private AccountViewModel accountViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        accountViewModel =
                new ViewModelProvider(this).get(AccountViewModel.class);
        View root = inflater.inflate(R.layout.fragment_account, container, false);

        Button btn1 = (Button) root.findViewById(R.id.btnEditar);
        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), Editar.class);
                ((MainActivity) getActivity()).startActivity(intent);

            }
        });

        Button btn2 = (Button) root.findViewById(R.id.btnEliminar);
        btn2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), Editar.class);
                ((MainActivity) getActivity()).startActivity(intent);

            }
        });

        Button btn3 = (Button) root.findViewById(R.id.btnMostrar);
        btn3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent intent = new Intent(getActivity(), Mostrar.class);
                ((MainActivity) getActivity()).startActivity(intent);

            }
        });

        return root;
    }
}
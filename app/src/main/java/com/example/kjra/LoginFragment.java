package com.example.kjra;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class LoginFragment extends Fragment
{
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.login_inicio, container, false);
        final TextInputLayout passwordTextInput = view.findViewById(R.id.password_text_imput);
        final TextInputEditText passwordTextEditText = view.findViewById(R.id.password_edit_text);
        MaterialButton nextButton = view.findViewById(R.id.galeria_button);

        nextButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view){
                if(!isPasswordValid(passwordTextEditText.getText())){
                    passwordTextInput.setError(getString(R.string.error_password));
                }else{
                    passwordTextInput.setError(null);
                    Intent intent = new Intent(getActivity(), MenuActivity.class);
                    startActivity(intent);
                }
            }
        });


        passwordTextEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int i, KeyEvent event) {
                if (isPasswordValid(passwordTextEditText.getText())){
                    passwordTextInput.setError(null);
                }
                return false;
            }
        });

        return view;
    }
    private boolean isPasswordValid(@Nullable Editable Text){
        return Text != null && Text.length() >= 6;
    }

}

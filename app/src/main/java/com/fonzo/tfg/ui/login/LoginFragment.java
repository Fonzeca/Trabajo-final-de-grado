package com.fonzo.tfg.ui.login;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.fonzo.tfg.Home;
import com.fonzo.tfg.R;
import com.fonzo.tfg.data.LoginRepository;
import com.fonzo.tfg.data.model.UsuarioView;
import com.fonzo.tfg.rest.ServidorTesis;
import com.fonzo.tfg.rest.TesisRetrofit;
import com.fonzo.tfg.ui.TesisViewModelFactory;
import com.fonzo.tfg.ui.login.viewmodel.LoginEstadoCampos;
import com.fonzo.tfg.ui.login.viewmodel.LoginResult;
import com.fonzo.tfg.ui.login.viewmodel.LoginViewModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginFragment extends Fragment {
    //TODO: Theme app para todo, buscar guias en internet

    private LoginViewModel loginViewModel;
    private EditText usernameEditText;
    private EditText passwordEditText;
    private Button loginButton;
    private ProgressBar loadingProgressBar;

    /**
     * Se crea la vista
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return vista ya construida
     */
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //TODO: Registrarse
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginViewModel = new ViewModelProvider(requireActivity(), new TesisViewModelFactory(getContext())).get(LoginViewModel.class);

        usernameEditText = view.findViewById(R.id.username);
        passwordEditText = view.findViewById(R.id.password);
        loginButton = view.findViewById(R.id.login);
        loadingProgressBar = view.findViewById(R.id.loading);


        loginViewModel.getLoginEstadoCampos().observe(getViewLifecycleOwner(), new Observer<LoginEstadoCampos>() {
            @Override
            public void onChanged(@Nullable LoginEstadoCampos loginEstadoCampos) {
                if (loginEstadoCampos == null) {
                    return;
                }
                loginButton.setEnabled(loginEstadoCampos.isValido());
                if (loginEstadoCampos.getUsuarioError() != null) {
                    usernameEditText.setError(getString(loginEstadoCampos.getUsuarioError()));
                }
                if (loginEstadoCampos.getClaveError() != null) {
                    passwordEditText.setError(getString(loginEstadoCampos.getClaveError()));
                }
            }
        });

        loginViewModel.getLoginResult().observe(getViewLifecycleOwner(), new Observer<LoginResult>() {
            @Override
            public void onChanged(@Nullable LoginResult loginResult) {
                if (loginResult == null) {
                    return;
                }
                loadingProgressBar.setVisibility(View.GONE);
                if (loginResult.getError() != null) {
                    showLoginFailed(loginResult.getError());
                }
                if (loginResult.getSuccess() != null) {
                    loginSucces();
                }
            }
        });

        TextWatcher afterTextChangedListener = new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }
            public void afterTextChanged(Editable s) {
                loginViewModel.loginDataChanged(usernameEditText.getText().toString(), passwordEditText.getText().toString());
            }
        };

        usernameEditText.addTextChangedListener(afterTextChangedListener);
        passwordEditText.addTextChangedListener(afterTextChangedListener);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                loadingProgressBar.setVisibility(View.VISIBLE);
                loginViewModel.login(usernameEditText.getText().toString(), passwordEditText.getText().toString());
            }
        });

        loadingProgressBar.setVisibility(View.VISIBLE);
        loginViewModel.verificarToken();
    }

    private void loginSucces() {
        Intent intent = new Intent(getActivity(), Home.class);
        startActivity(intent);
        getActivity().finish();
    }

    private void showLoginFailed(Exception exception) {
        if (getContext() != null && getContext().getApplicationContext() != null) {
            Toast.makeText(
                    getContext().getApplicationContext(),
                    exception.getMessage(),
                    Toast.LENGTH_LONG).show();
        }
    }
}
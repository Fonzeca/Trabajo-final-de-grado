package com.fonzo.tfg.ui;

import android.content.Context;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.NonNull;

import com.fonzo.tfg.data.LoginRepository;
import com.fonzo.tfg.ui.carrito.viewmodel.CarritoViewModel;
import com.fonzo.tfg.ui.comercios.viewmodel.ComerciosViewModel;
import com.fonzo.tfg.ui.login.viewmodel.LoginViewModel;
import com.fonzo.tfg.ui.producto.viewmodel.ProductosViewModel;

public class TesisViewModelFactory implements ViewModelProvider.Factory {
    private Context context;

    public TesisViewModelFactory(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    @SuppressWarnings("unchecked")
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(LoginViewModel.class)) {
            return (T) new LoginViewModel(LoginRepository.getInstance(context));
        }else if (modelClass.isAssignableFrom(ComerciosViewModel.class)) {
            return (T) new ComerciosViewModel(context);
        }else if (modelClass.isAssignableFrom(ProductosViewModel.class)){
            return (T) new ProductosViewModel(context);
        }else if (modelClass.isAssignableFrom(CarritoViewModel.class)){
            return (T) new CarritoViewModel(context);
        } else {
            throw new IllegalArgumentException("Unknown ViewModel class");
        }
    }
}
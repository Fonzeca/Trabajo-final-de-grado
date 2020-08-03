package com.fonzo.tfg.ui.comercios.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fonzo.tfg.data.LoginRepository;
import com.fonzo.tfg.data.model.ComercioView;
import com.fonzo.tfg.rest.ServidorTesis;
import com.fonzo.tfg.rest.TesisRetrofit;
import com.fonzo.tfg.rest.pojo.ComercioRs;
import com.fonzo.tfg.rest.pojo.ListaComerciosRs;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComerciosViewModel extends ViewModel {
    private MutableLiveData<List<ComercioView>> listMutableLiveData = new MutableLiveData<>();
    private Context context;

    public ComerciosViewModel(Context context) {
        this.context = context;
    }

    public void initComercios(){
        ServidorTesis servidor = TesisRetrofit.obtenerConexion();
        LoginRepository loginRepository = LoginRepository.getInstance(context);
        String token = loginRepository.obtenerToken();

        if(token != null && !token.isEmpty()){
            Call<ListaComerciosRs> loginCall = servidor.obtenerComercios(token,1);
            loginCall.enqueue(new Callback<ListaComerciosRs>() {
                @Override
                public void onResponse(Call<ListaComerciosRs> call, Response<ListaComerciosRs> response) {
                    List<ComercioView> listaView = new ArrayList<>();

                    if(response.isSuccessful()){
                        List<ComercioRs> listaComerciosRs = response.body().comercios;

                        listaComerciosRs.forEach(x -> listaView.add(new ComercioView(x)));
                    }else {

                    }
                    listMutableLiveData.postValue(listaView);
                }
                @Override
                public void onFailure(Call<ListaComerciosRs> call, Throwable t) {

                }
            });
        }

    }

    public MutableLiveData<List<ComercioView>> getListMutableLiveData() {
        return listMutableLiveData;
    }
}

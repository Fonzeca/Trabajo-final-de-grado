package com.fonzo.tfg.ui.producto.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fonzo.tfg.data.LoginRepository;
import com.fonzo.tfg.data.model.ComercioView;
import com.fonzo.tfg.data.model.ProductoView;
import com.fonzo.tfg.rest.ServidorTesis;
import com.fonzo.tfg.rest.TesisRetrofit;
import com.fonzo.tfg.rest.pojo.ComercioRs;
import com.fonzo.tfg.rest.pojo.ItemListaProductoRs;
import com.fonzo.tfg.rest.pojo.ListaComerciosRs;
import com.fonzo.tfg.rest.pojo.ListaProductoRs;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductosViewModel extends ViewModel {
    private MutableLiveData<List<ProductoView>> listMutableLiveData = new MutableLiveData<>();
    private Context context;

    public ProductosViewModel(Context context) {
        this.context = context;
    }

    public void initProductos(int comercioId){
        ServidorTesis servidor = TesisRetrofit.obtenerConexion();
        LoginRepository loginRepository = LoginRepository.getInstance(context);
        String token = loginRepository.obtenerToken();

        if(token != null && !token.isEmpty()){
            Call<ListaProductoRs> loginCall = servidor.obtenerProductos(token,comercioId);
            loginCall.enqueue(new Callback<ListaProductoRs>() {
                public void onResponse(Call<ListaProductoRs> call, Response<ListaProductoRs> response) {
                    List<ProductoView> listaViews = new ArrayList<>();
                    if(response.isSuccessful()){
                        List<ItemListaProductoRs> listaProductoRs = response.body().getProductos();
                        listaProductoRs.forEach(x -> listaViews.add(new ProductoView(x)));

                    }else{
                        //No OK
                    }
                    listMutableLiveData.postValue(listaViews);
                }
                public void onFailure(Call<ListaProductoRs> call, Throwable t) {

                }
            });
        }
    }

    public MutableLiveData<List<ProductoView>> getListMutableLiveData() {
        return listMutableLiveData;
    }
}

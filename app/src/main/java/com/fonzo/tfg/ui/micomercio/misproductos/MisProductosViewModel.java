package com.fonzo.tfg.ui.micomercio.misproductos;

import android.annotation.SuppressLint;
import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fonzo.tfg.data.LoginRepository;
import com.fonzo.tfg.data.model.ProductoView;
import com.fonzo.tfg.rest.ServidorTesis;
import com.fonzo.tfg.rest.TesisRetrofit;
import com.fonzo.tfg.rest.pojo.ItemListaProductoRs;
import com.fonzo.tfg.rest.pojo.ListaProductoRs;
import com.fonzo.tfg.rest.pojo.UsuarioRs;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MisProductosViewModel extends ViewModel {
	private MutableLiveData<List<ProductoView>> listaProductos = new MutableLiveData<>();

	private Context context;

	public MisProductosViewModel(Context context) {
		this.context = context;
	}

	public void init(){
		ServidorTesis servidor = TesisRetrofit.obtenerConexion();

		LoginRepository loginRepository = LoginRepository.getInstance(context);
		String token = loginRepository.obtenerToken();

		Integer comercioIdObj = loginRepository.getUser().comercioId;
		if(comercioIdObj == null){
			//TODO: notificar error
			return;
		}
		int comercioId = comercioIdObj;


		if(token != null && !token.isEmpty()) {
			Call<ListaProductoRs> loginCall = servidor.obtenerProductos(token, comercioId);
			loginCall.enqueue(new Callback<ListaProductoRs>() {
				public void onResponse(Call<ListaProductoRs> call, Response<ListaProductoRs> response) {
					List<ProductoView> listaViews = new ArrayList<>();
					if(response.isSuccessful()){
						List<ItemListaProductoRs> listaProductoRs = response.body().getProductos();
						listaProductoRs.forEach(x -> listaViews.add(new ProductoView(x)));

					}else{
						//No OK
					}
					listaProductos.postValue(listaViews);
				}

				public void onFailure(Call<ListaProductoRs> call, Throwable t) {
				}
			});
		}
	}

	public MutableLiveData<List<ProductoView>> getListaProductos() {
		return listaProductos;
	}
}

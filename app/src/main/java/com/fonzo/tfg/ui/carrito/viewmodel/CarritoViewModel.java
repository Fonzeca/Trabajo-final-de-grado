package com.fonzo.tfg.ui.carrito.viewmodel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.fonzo.tfg.data.LoginRepository;
import com.fonzo.tfg.data.model.CarritoView;
import com.fonzo.tfg.data.model.ProductoCarritoView;
import com.fonzo.tfg.data.model.ProductoView;
import com.fonzo.tfg.rest.ServidorTesis;
import com.fonzo.tfg.rest.TesisRetrofit;
import com.fonzo.tfg.rest.pojo.CarritoRs;
import com.fonzo.tfg.rest.pojo.ItemListaProductoRs;
import com.fonzo.tfg.rest.pojo.ItemProductosxCarrito;
import com.fonzo.tfg.rest.pojo.ListaProductoRs;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarritoViewModel extends ViewModel {

	private MutableLiveData<CarritoView> carritoViewMutableLiveData = new MutableLiveData<>();
	private MutableLiveData<List<ProductoCarritoView>> listMutableLiveData = new MutableLiveData<List<ProductoCarritoView>>();

	private Context context;

	public CarritoViewModel(Context context) {
		this.context = context;
	}

	public void initProuctos(){
		ServidorTesis servidor = TesisRetrofit.obtenerConexion();
		LoginRepository loginRepository = LoginRepository.getInstance(context);
		String token = loginRepository.obtenerToken();

		if(token != null && !token.isEmpty()){
			Call<CarritoRs> carritoCall = servidor.obtenerCarritoActivo(token);
			carritoCall.enqueue(new Callback<CarritoRs>() {
				public void onResponse(Call<CarritoRs> call, Response<CarritoRs> response) {
					List<ProductoCarritoView> listaViews = new ArrayList<>();
					CarritoView carritoView = new CarritoView();

					if(response.isSuccessful()){
						List<ItemProductosxCarrito> listaProductoCarritoRs = response.body().getProductosxCarrito();
						listaProductoCarritoRs.forEach(x -> listaViews.add(new ProductoCarritoView(x)));

						carritoView = new CarritoView(response.body());
					}else{
						//No OK
					}
					listMutableLiveData.postValue(listaViews);
					carritoViewMutableLiveData.postValue(carritoView);
				}
				public void onFailure(Call<CarritoRs> call, Throwable t) {

				}
			});
		}


	}


	public MutableLiveData<CarritoView> getCarritoViewMutableLiveData() {
		return carritoViewMutableLiveData;
	}

	public MutableLiveData<List<ProductoCarritoView>> getListMutableLiveData() {
		return listMutableLiveData;
	}
}

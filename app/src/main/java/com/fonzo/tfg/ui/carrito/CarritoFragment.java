package com.fonzo.tfg.ui.carrito;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.fonzo.tfg.R;
import com.fonzo.tfg.data.model.ProductoCarritoView;
import com.fonzo.tfg.ui.TesisViewModelFactory;
import com.fonzo.tfg.ui.carrito.viewmodel.CarritoViewModel;
import com.fonzo.tfg.ui.producto.ProductoRecyclerViewAdapter;
import com.fonzo.tfg.ui.producto.viewmodel.ProductosViewModel;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.util.List;

public class CarritoFragment extends Fragment {

	private CarritoViewModel viewModel;

	private RecyclerView recyclerView;
	private TextView total;
	private CheckBox isDelivery;
	private TextInputEditText direccion;
	private MaterialButton btnEfectivo, btnPagoOnline;

	public CarritoFragment() {

	}


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_carrito, container, false);
	}

	@Override
	public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		viewModel = new ViewModelProvider(requireActivity(), new TesisViewModelFactory(getContext())).get(CarritoViewModel.class);

		recyclerView = view.findViewById(R.id.lista_productos_carrito_recycler_view);

		recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
		recyclerView.setAdapter(new ProductoCarritoRecyclerViewAdapter(null));

		viewModel.getListMutableLiveData().observe(getViewLifecycleOwner(), new Observer<List<ProductoCarritoView>>() {
			public void onChanged(List<ProductoCarritoView> productoCarritoViews) {
				recyclerView.setAdapter(new ProductoCarritoRecyclerViewAdapter(productoCarritoViews));
			}
		});

		//Llama al servidor para que busque el carrito
		viewModel.initProuctos();

	}
}
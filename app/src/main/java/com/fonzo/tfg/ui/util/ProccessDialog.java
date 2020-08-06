package com.fonzo.tfg.ui.util;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.fonzo.tfg.R;

public class ProccessDialog extends Dialog {

	private static ProccessDialog instance;

	public static ProccessDialog show(Context context, CharSequence title,
										CharSequence message) {
		return show(context, title, message, false);
	}

	public static ProccessDialog show(Context context, CharSequence title,
										CharSequence message, boolean indeterminate) {
		return show(context, title, message, indeterminate, false, null);
	}

	public static ProccessDialog show(Context context, CharSequence title,
										CharSequence message, boolean indeterminate, boolean cancelable) {
		return show(context, title, message, indeterminate, cancelable, null);
	}

	public static ProccessDialog show(Context context, CharSequence title,
										CharSequence message, boolean indeterminate,
										boolean cancelable, OnCancelListener cancelListener) {
		if(instance != null){
			return instance;
		}
		instance = new ProccessDialog(context);
		instance.setTitle(title);
		instance.setCancelable(cancelable);
		instance.setOnCancelListener(cancelListener);
		/* The next line will add the ProgressBar to the dialog. */
		instance.addContentView(new ProgressBar(context), new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
		instance.show();

		return instance;
	}

	public static void cerrar(){
		if(instance != null){
			instance.dismiss();
		}
		instance = null;
	}

	private ProccessDialog(Context context) {
		super(context, R.style.NewDialog);
	}
}

package com.shopapp.RestElement;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.shopapp.R;

public class Rest_element {
    Context context;
    public Rest_element(Context context) {
        this.context = context;
    }



    public void toast_makeAlert( String titleTextOfToast,String textOfToast){
        Toast toast = new Toast(context.getApplicationContext());
        View view = LayoutInflater.from(context).inflate(R.layout.custom_layout_toast, null);
        TextView titleTextViewOfToast = view.findViewById(R.id.titleTextOfToastId);
        titleTextViewOfToast.setText(titleTextOfToast);

        TextView textViewOfToast = view.findViewById(R.id.textOfToastId);
        textViewOfToast.setText(textOfToast);

        ImageView iconOfToast = view.findViewById(R.id.imageOfToastCustomId);
        iconOfToast.setImageResource(R.drawable.ic_home);

        toast.setView(view);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.BOTTOM, 0, 20);

        toast.show();
    }
}

package com.example.clothingapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clothingapp.R;
import com.example.clothingapp.model.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductListActivityAdapter extends ArrayAdapter<Product> {
    private final Context mContext;
    private final int mResource;

    public ProductListActivityAdapter(Context context, int resource, List<Product> notes) {
        super(context, resource, notes);
        mContext = context;
        mResource = resource;
    }

    // View holder class to hold the views of the list view item
    private static class ViewHolder {
        TextView txtViewName;
        TextView txtViewPrice;
        ImageView imageView;
    }

    // Get the view of the list view item
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.txtViewName = convertView.findViewById(R.id.nameTxtView);
            viewHolder.txtViewPrice = convertView.findViewById(R.id.priceTxtView);
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Product product = getItem(position);

        if (product != null) {
            // Populate the data into the template view using the data object
            viewHolder.txtViewName.setText(product.getName());
            viewHolder.txtViewPrice.setText("Rs. " + (product.getPrice()));

            // load image using Picasso
            Picasso.get().load(product.getImage()).into(viewHolder.imageView);
        }

        return convertView;
    }
}

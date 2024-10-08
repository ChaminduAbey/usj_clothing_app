package com.example.clothingapp.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.clothingapp.MainActivity;
import com.example.clothingapp.ProductListActivity;
import com.example.clothingapp.R;
import com.example.clothingapp.SubCategoryListActivity;
import com.example.clothingapp.model.ProductSubCategory;

import java.util.List;

// Adapter for the sub category list activity list view
public class SubCategoryListActivityAdapter extends ArrayAdapter<ProductSubCategory> {
    private Context mContext;
    private int mResource;

    public SubCategoryListActivityAdapter(Context context, int resource, List<ProductSubCategory> notes) {
        super(context, resource, notes);
        mContext = context;
        mResource = resource;
    }

    // View holder class to hold the views of the list view item
    private static class ViewHolder {
        TextView txtViewName;
        ImageView imageView;
        Button button;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);

            viewHolder = new ViewHolder();
            viewHolder.txtViewName = convertView.findViewById(R.id.textView);
            viewHolder.imageView = convertView.findViewById(R.id.imageView);
            viewHolder.button = convertView.findViewById(R.id.button);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        ProductSubCategory subCategory = getItem(position);

        if (subCategory != null) {
            // Populate the data into the template view using the data object
            viewHolder.txtViewName.setText(subCategory.getName());
            viewHolder.imageView.setImageResource(mContext.getResources().getIdentifier(subCategory.getImage(), "drawable", mContext.getPackageName()));

            // Set the button click listener
            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, ProductListActivity.class);
                    intent.putExtra("id", subCategory.getId());
                    mContext.startActivity(intent);
                }
            });
        }

        return convertView;
    }
}
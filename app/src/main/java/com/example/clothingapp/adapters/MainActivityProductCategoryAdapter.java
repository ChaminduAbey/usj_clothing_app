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
import com.example.clothingapp.R;
import com.example.clothingapp.SubCategoryListActivity;
import com.example.clothingapp.model.ProductCategory;

import java.util.List;

public class MainActivityProductCategoryAdapter extends ArrayAdapter<ProductCategory> {
    private Context mContext;
    private int mResource;

    public MainActivityProductCategoryAdapter(Context context, int resource, List<ProductCategory> notes) {
        super(context, resource, notes);
        mContext = context;
        mResource = resource;
    }

    private static class ViewHolder {
        TextView txtViewName;
        ImageView imageView;
        Button button;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
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

        ProductCategory category = getItem(position);

        if (category != null) {
            viewHolder.txtViewName.setText(category.getName());
            viewHolder.imageView.setImageResource(mContext.getResources().getIdentifier(category.getImage(), "drawable", mContext.getPackageName()));

            viewHolder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, SubCategoryListActivity.class);
                    intent.putExtra("id", category.getId());
                    mContext.startActivity(intent);
                }
            });
        }

        return convertView;
    }
}
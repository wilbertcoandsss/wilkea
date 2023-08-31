package com.example.androidproject_lc077.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidproject_lc077.R;
import com.example.androidproject_lc077.database.Database;
import com.example.androidproject_lc077.model.Product;

import java.util.Vector;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private Context context;
    private Vector<Product> listProducts;

    private Database database;
    public ProductsAdapter(Context context, Vector<Product> listProducts) {
        this.context = context;
        this.listProducts = listProducts;
        this.database = Database.getInstance(this.context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_products, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product product = listProducts.get(position);

        holder.ivCover.setImageResource(product.getImage());
        holder.tvTitle.setText(product.getTitle());
        holder.tvPrice.setText(String.valueOf(product.getPrice()));
        holder.tvType.setText(product.getType());
        holder.btnDelete.setOnClickListener(e->{
                database.deleteProduct(product.getId());
                listProducts.remove(product);
            Toast.makeText(context, "Product Deleted Successfully!", Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
        });

    }

    @Override
    public int getItemCount() {
        return listProducts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        private ImageView ivCover;
        private TextView tvTitle, tvPrice, tvType;
        private Button btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivCover = itemView.findViewById(R.id.productLvCover);
            tvTitle = itemView.findViewById(R.id.itemTvTitle);
            tvPrice = itemView.findViewById(R.id.itemTvPrice);
            btnDelete = itemView.findViewById(R.id.itemBtnDelete);
            tvType = itemView.findViewById(R.id.itemTvType);
        }
    }
}

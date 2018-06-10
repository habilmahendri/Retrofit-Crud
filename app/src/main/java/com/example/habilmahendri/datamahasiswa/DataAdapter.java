package com.example.habilmahendri.datamahasiswa;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.habilmahendri.datamahasiswa.activity.BiodataActivity;
import com.example.habilmahendri.datamahasiswa.activity.MainActivity;
import com.example.habilmahendri.datamahasiswa.activity.Update_Activity;
import com.example.habilmahendri.datamahasiswa.fragment.PostFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private List<Data>item;

    Context context;

    public DataAdapter(Context context, List<Data>item){
        this.item = item;
        this.context = context;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Log.d("123", "onCreateViewHolder");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position){
        holder.name.setText(item.get(position).getName());
        holder.kelas.setText(item.get(position).getKelas());
        holder.npm.setText(item.get(position).getNpm());
        Picasso.get()
                .load(item.get(position).getGambar())
                .into(holder.imageView);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "OnClickListener", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, BiodataActivity.class);
                intent.putExtra("name",item.get(position).getName());
                intent.putExtra("kelas",item.get(position).getKelas());
                intent.putExtra("npm",item.get(position).getNpm());
                intent.putExtra("gambar",item.get(position).getGambar());
                context.startActivity(intent);
            }
        });

        holder.parentLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                //Toast.makeText(context, "OnClickListener", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(context, Update_Activity.class);
                intent.putExtra("name",item.get(position).getName());
                intent.putExtra("kelas",item.get(position).getKelas());
                intent.putExtra("npm",item.get(position).getNpm());
                intent.putExtra("gambar",item.get(position).getGambar());
                intent.putExtra("id",item.get(position).getId());
                context.startActivity(intent);

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        //Log.d("123", "getItemCount");
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView name,kelas,npm,alamat,id;
        public ImageView imageView;
        public LinearLayout parentLayout;


        public ViewHolder(View itemView){
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.name);
            kelas = (TextView)itemView.findViewById(R.id.kelas);
            npm = (TextView)itemView.findViewById(R.id.npm);
            imageView = (ImageView)itemView.findViewById(R.id.profile_image);
            parentLayout = (LinearLayout)itemView.findViewById(R.id.parent_layout);



        }

    }
}

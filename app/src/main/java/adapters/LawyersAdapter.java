package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lawyerrecommender.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import models.Lawyer;

public class LawyersAdapter extends RecyclerView.Adapter<LawyersAdapter.MyViewHolder> {
    private LayoutInflater layoutInflater;
    private ArrayList<Lawyer>dataModelArrayList;
    private Context context;

    public LawyersAdapter(Context context, ArrayList<Lawyer> dataModelArrayList) {
        layoutInflater=LayoutInflater.from(context);
        this.dataModelArrayList = dataModelArrayList;
    }

    @NonNull
    @Override
    public LawyersAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=layoutInflater.from(parent.getContext()).inflate(R.layout.lawyer_item,parent,false);
        MyViewHolder holder=new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LawyersAdapter.MyViewHolder holder, int position) {
        Picasso.get().load(dataModelArrayList.get(position).getProfileImg()).into(holder.profile_img);
        holder.name.setText(dataModelArrayList.get(position).getName());
        holder.contact.setText(dataModelArrayList.get(position).getPhone());
        holder.specialization.setText(dataModelArrayList.get(position).getSpecialization());
        holder.working_days.setText(dataModelArrayList.get(position).getWorkingDays());
        holder.location.setText(dataModelArrayList.get(position).getLocation());
    }

//    @Override
//    public LawyersAdapter.MyViewHolder ()

    @Override
    public int getItemCount() {
        return dataModelArrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name,contact,location,working_days ,specialization;
        ImageView profile_img;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name);
            contact=itemView.findViewById(R.id.contact);
            location=itemView.findViewById(R.id.location);
            working_days=itemView.findViewById(R.id.working_days);
            specialization=itemView.findViewById(R.id.specialization);
        }
    }
}

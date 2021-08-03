package com.example.vms2_final;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.internal.$Gson$Preconditions;

import java.util.List;

public class VisitorsAdapter extends RecyclerView.Adapter<VisitorsAdapter.VisitorsViewHolder> {

    private Context mCtx;
    public List<Visitors_class> Visitorslist;


    public VisitorsAdapter(Context mCtx, List<Visitors_class> Visitorslist){
        this.mCtx = mCtx;
        this.Visitorslist = Visitorslist;
    }

    @NonNull
    @Override
    public VisitorsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VisitorsViewHolder(
                LayoutInflater.from(mCtx).inflate(R.layout.layout_visitors, parent,false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull VisitorsViewHolder holder, int position) {
        Visitors_class Visitors = Visitorslist.get(position);
        holder.t1.setText(Visitors.getName());
        holder.t2.setText(Visitors.getVehical());
        holder.t3.setText(Visitors.getPurpose());
        holder.t4.setText(Visitors.getEmail());
        holder.t5.setText(Visitors.getNo_of_vistiors());
        holder.t6.setText(Visitors.getTimestamp().toString());
     }

    @Override
    public int getItemCount() {
        return Visitorslist.size();
    }

    public class VisitorsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView t1,t2,t3,t4,t5,t6;
        public VisitorsViewHolder(@NonNull View itemView) {
            super(itemView);
            t1 = itemView.findViewById(R.id.t1);
            t2 = itemView.findViewById(R.id.t2);
            t3 = itemView.findViewById(R.id.t3);
            t4 = itemView.findViewById(R.id.t4);
            t5 = itemView.findViewById(R.id.t5);
            t6 = itemView.findViewById(R.id.t6);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Visitors_class Visitors = Visitorslist.get(getAdapterPosition());
            Intent intent = new Intent(mCtx,Update_Visitors.class);
            intent.putExtra("Visitors",Visitors);
             mCtx.startActivity(intent);
        }
    }
}

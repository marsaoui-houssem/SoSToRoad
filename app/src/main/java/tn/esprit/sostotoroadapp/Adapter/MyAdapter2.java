package tn.esprit.sostotoroadapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import tn.esprit.sostotoroadapp.DetailsActivity;
import tn.esprit.sostotoroadapp.DetailsMissionActivity;
import tn.esprit.sostotoroadapp.R;
import tn.esprit.sostotoroadapp.model.User;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.ViewHolder> {
    private List<User> users;
    private Context mcontext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(mcontext).inflate(R.layout.item2,parent,false);

        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.nameitm.setText(user.getName());
        holder.phoneitm.setText(user.getPhone());
        holder.btnv.setOnClickListener(view -> {
            Intent intent = new Intent(mcontext, DetailsMissionActivity.class);
            intent.putExtra("id",user.getId());
            intent.putExtra("nameA",user.getName());
            intent.putExtra("phoneA",user.getPhone());
            intent.putExtra("emailA",user.getEmail());
            mcontext.startActivity(intent);
        });

    }

    @Override
    public int getItemCount() {
        return users.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nameitm ;
        private TextView phoneitm ;
        private Button btnv ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameitm = itemView.findViewById(R.id.nomv);
            phoneitm = itemView.findViewById(R.id.numv);
            btnv= itemView.findViewById(R.id.btnv);

        }
    }
    public MyAdapter2(Context context, List<User> users){

        this.mcontext=context;
        this.users=users;

    }
}

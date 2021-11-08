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
import tn.esprit.sostotoroadapp.model.User;
import tn.esprit.sostotoroadapp.R;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<User> users;
    private Context mcontext;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(mcontext).inflate(R.layout.item,parent,false);

        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User user = users.get(position);
        holder.nameitm.setText(user.getName());
        holder.phoneitm.setText(user.getPhone());
        holder.detailsuser.setOnClickListener(view -> {
            Intent intent = new Intent(mcontext, DetailsActivity.class);
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
        private Button detailsuser ;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nameitm = itemView.findViewById(R.id.nameitm);
            phoneitm = itemView.findViewById(R.id.phoneitm);
            detailsuser= itemView.findViewById(R.id.details);

        }
    }
    public MyAdapter(Context context, List<User> users){

        this.mcontext=context;
        this.users=users;

    }
}

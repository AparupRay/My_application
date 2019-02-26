package com.example.happy_birthday;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MyAdpater extends RecyclerView.Adapter<MyAdpater.ViewHolder> {

    private List<ListItem> listItems;
    private Context context;

    public MyAdpater(List<ListItem> listItems, Context context) {

        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        ListItem listItem = listItems.get(i);

        viewHolder.birthday_user.setText(listItem.getBirthday_user());
        viewHolder.make_wish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }
        });

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder

    {

        public ImageView profile_avatar;
        public TextView  birthday_user;
        public Button  make_wish;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            profile_avatar = (ImageView) itemView.findViewById(R.id.profile_avatar);
            birthday_user = (TextView) itemView.findViewById(R.id.birthday_user);
            make_wish = (Button) itemView.findViewById(R.id.make_wish);
        }
    }


}

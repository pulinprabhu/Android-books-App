package com.example.pulinprabhu.book.propya;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulinprabhu.book.R;
import com.example.pulinprabhu.book.Word;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Map;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {

    Context c ;
    ArrayList<CategoriesBluePrint> categories;


    public CategoriesAdapter(Context c , ArrayList<CategoriesBluePrint> categories){
        this.c = c;
        this.categories = categories;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View v = LayoutInflater.from(c).inflate(R.layout.each_category,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.root.setTag(categories.get(i).getName());
        viewHolder.bookName.setText(categories.get(i).getName());

            try {
                Picasso.get().load(categories.get(i).getUrl()).into(viewHolder.bookCover);


            }catch (Exception e){
                Log.i("image error",e.getLocalizedMessage());
            }



    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        ImageView bookCover;
        TextView bookName;
        CardView root;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            bookCover = (ImageView)itemView.findViewById(R.id.imageBook);
            bookName = (TextView) itemView.findViewById(R.id.bookNameAdapter);
            root = (CardView) itemView.findViewById(R.id.cardViewRoot);
            root.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(c, "Tag "+String.valueOf(view.getTag()), Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(c,BooksDisplay.class);
                    i.putExtra("category",String.valueOf(view.getTag()));
                    c.startActivity(i);
                }
            });
        }
    }
}

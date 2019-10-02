package com.example.pulinprabhu.book;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.DataSnapshot;

import java.util.ArrayList;

public class Word implements Parcelable{
    DataSnapshot data;
    /** Default translation for the word */
    String mBookName;

    /** Miwok translation for the word */
    String mBookPrice;

    String selfKey ;
    ArrayList<String> pricesConverted;
    ArrayList<String> comments;

    private String lowestProvider;


    public Word(String bookName, String bookPrice) {
        mBookName = bookName;
        mBookPrice = bookPrice;
    }


    public Word(){



    }


    protected Word(Parcel in) {
        mBookName = in.readString();
        mBookPrice = in.readString();
        selfKey = in.readString();
        pricesConverted = in.createStringArrayList();
        comments = in.createStringArrayList();
        lowestProvider = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mBookName);
        dest.writeString(mBookPrice);
        dest.writeString(selfKey);
        dest.writeStringList(pricesConverted);
        dest.writeStringList(comments);
        dest.writeString(lowestProvider);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Word> CREATOR = new Creator<Word>() {
        @Override
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        @Override
        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

    public String getBookName() {
        return mBookName;
    }

    public String getBookPrice() {
        return mBookPrice;
    }



    public void setData(DataSnapshot data) {
        pricesConverted = new ArrayList<>();
        int lowest = Integer.MAX_VALUE;
        for(DataSnapshot prices : data.child("prices").getChildren()){
            int price = prices.getValue(Integer.class);
            if(price<lowest){
                lowest = price;
                lowestProvider = prices.getKey();
            }
            pricesConverted.add(prices.getKey()+" : "+Integer.toString(price));

        }

        if(data.hasChild("comments")){
            comments = new ArrayList<>();
            for(DataSnapshot eachComment : data.child("comments").getChildren()){
                String email = eachComment.child("email").getValue(String.class);
                String message = eachComment.child("message").getValue(String.class);
                comments.add("\t"+email+"\n"+message);


            }



        }


    }

    public ArrayList<String> getComments() {
        if(comments == null)
        {return null;}
        return comments;
    }

    public String getmBookName() {
        return mBookName;
    }

    public void setmBookName(String mBookName) {
        this.mBookName = mBookName;
    }

    public String getmBookPrice() {
        return mBookPrice;
    }

    public void setmBookPrice(String mBookPrice) {
        this.mBookPrice = mBookPrice;
    }

    public ArrayList<String> getPricesConverted() {
        return pricesConverted;
    }

    public void setPricesConverted(ArrayList<String> pricesConverted) {
        this.pricesConverted = pricesConverted;
    }

    public String getLowestProvider() {
        return lowestProvider;
    }

    public void addComment(String message){
        if(comments == null){
            comments = new ArrayList<>();
        }
        comments.add(message);

    }

    public String getSelfKey() {
        return selfKey;
    }

    public void setSelfKey(String selfKey) {
        this.selfKey = selfKey;
    }
}

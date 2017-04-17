package com.example.moreapp;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by android on 4/16/2017.
 */

public class Items implements Parcelable{

    public float id;
    public String name;
    public String link;
    public String imageId;



    public Items(float id , String name , String link , String imageId){
        this.id = id;
        this.name = name;
        this.link = link;
        this.imageId = imageId;
    }


    public Items(){}

    protected Items(Parcel in) {
        id = in.readFloat();
        name = in.readString();
        link = in.readString();
        imageId = in.readString();
    }

    public static final Creator<Items> CREATOR = new Creator<Items>() {
        @Override
        public Items createFromParcel(Parcel in) {
            return new Items(in);
        }

        @Override
        public Items[] newArray(int size) {
            return new Items[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getLink() {
        return link;
    }

    public float getId() {
        return id;
    }

    public String getImageId() {
        return imageId;
    }


    public void setLink(String link) {
        this.link = link;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeFloat(id);
        dest.writeString(name);
        dest.writeString(link);
        dest.writeString(imageId);
    }


}


package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Category implements Parcelable
{

    @SerializedName("attributes")
    @Expose
    private Attributes______ attributes;
    public final static Parcelable.Creator<Category> CREATOR = new Creator<Category>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Category createFromParcel(Parcel in) {
            return new Category(in);
        }

        public Category[] newArray(int size) {
            return (new Category[size]);
        }

    }
    ;

    protected Category(Parcel in) {
        this.attributes = ((Attributes______) in.readValue((Attributes______.class.getClassLoader())));
    }

    public Category() {
    }

    public Attributes______ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes______ attributes) {
        this.attributes = attributes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(attributes);
    }

    public int describeContents() {
        return  0;
    }

}

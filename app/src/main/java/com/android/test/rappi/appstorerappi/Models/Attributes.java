
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes implements Parcelable
{

    @SerializedName("height")
    @Expose
    private String height;
    public final static Parcelable.Creator<Attributes> CREATOR = new Creator<Attributes>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Attributes createFromParcel(Parcel in) {
            return new Attributes(in);
        }

        public Attributes[] newArray(int size) {
            return (new Attributes[size]);
        }

    }
    ;

    protected Attributes(Parcel in) {
        this.height = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Attributes() {
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(height);
    }

    public int describeContents() {
        return  0;
    }

}

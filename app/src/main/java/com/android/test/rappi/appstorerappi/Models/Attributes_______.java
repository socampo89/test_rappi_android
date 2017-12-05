
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes_______ implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    public final static Parcelable.Creator<Attributes_______> CREATOR = new Creator<Attributes_______>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Attributes_______ createFromParcel(Parcel in) {
            return new Attributes_______(in);
        }

        public Attributes_______[] newArray(int size) {
            return (new Attributes_______[size]);
        }

    }
    ;

    protected Attributes_______(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Attributes_______() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(label);
    }

    public int describeContents() {
        return  0;
    }

}


package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Summary implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    public final static Parcelable.Creator<Summary> CREATOR = new Creator<Summary>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Summary createFromParcel(Parcel in) {
            return new Summary(in);
        }

        public Summary[] newArray(int size) {
            return (new Summary[size]);
        }

    }
    ;

    protected Summary(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Summary() {
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

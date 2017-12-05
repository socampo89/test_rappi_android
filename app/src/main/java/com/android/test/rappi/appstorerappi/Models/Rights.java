
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rights implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    public final static Parcelable.Creator<Rights> CREATOR = new Creator<Rights>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Rights createFromParcel(Parcel in) {
            return new Rights(in);
        }

        public Rights[] newArray(int size) {
            return (new Rights[size]);
        }

    }
    ;

    protected Rights(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Rights() {
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


package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Updated implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    public final static Parcelable.Creator<Updated> CREATOR = new Creator<Updated>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Updated createFromParcel(Parcel in) {
            return new Updated(in);
        }

        public Updated[] newArray(int size) {
            return (new Updated[size]);
        }

    }
    ;

    protected Updated(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Updated() {
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


package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Uri implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    public final static Parcelable.Creator<Uri> CREATOR = new Creator<Uri>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Uri createFromParcel(Parcel in) {
            return new Uri(in);
        }

        public Uri[] newArray(int size) {
            return (new Uri[size]);
        }

    }
    ;

    protected Uri(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Uri() {
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

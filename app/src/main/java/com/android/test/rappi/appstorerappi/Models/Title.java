
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Title implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    public final static Parcelable.Creator<Title> CREATOR = new Creator<Title>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Title createFromParcel(Parcel in) {
            return new Title(in);
        }

        public Title[] newArray(int size) {
            return (new Title[size]);
        }

    }
    ;

    protected Title(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Title() {
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

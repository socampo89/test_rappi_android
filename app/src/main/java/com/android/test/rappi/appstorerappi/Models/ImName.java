
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImName implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    public final static Parcelable.Creator<ImName> CREATOR = new Creator<ImName>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ImName createFromParcel(Parcel in) {
            return new ImName(in);
        }

        public ImName[] newArray(int size) {
            return (new ImName[size]);
        }

    }
    ;

    protected ImName(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ImName() {
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

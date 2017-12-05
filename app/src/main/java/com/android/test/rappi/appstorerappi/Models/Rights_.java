
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rights_ implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    public final static Parcelable.Creator<Rights_> CREATOR = new Creator<Rights_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Rights_ createFromParcel(Parcel in) {
            return new Rights_(in);
        }

        public Rights_[] newArray(int size) {
            return (new Rights_[size]);
        }

    }
    ;

    protected Rights_(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Rights_() {
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

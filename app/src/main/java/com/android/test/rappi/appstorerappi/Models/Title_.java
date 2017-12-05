
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Title_ implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    public final static Parcelable.Creator<Title_> CREATOR = new Creator<Title_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Title_ createFromParcel(Parcel in) {
            return new Title_(in);
        }

        public Title_[] newArray(int size) {
            return (new Title_[size]);
        }

    }
    ;

    protected Title_(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Title_() {
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

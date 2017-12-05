
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Id_ implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    public final static Parcelable.Creator<Id_> CREATOR = new Creator<Id_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Id_ createFromParcel(Parcel in) {
            return new Id_(in);
        }

        public Id_[] newArray(int size) {
            return (new Id_[size]);
        }

    }
    ;

    protected Id_(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Id_() {
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


package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Name implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    public final static Parcelable.Creator<Name> CREATOR = new Creator<Name>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Name createFromParcel(Parcel in) {
            return new Name(in);
        }

        public Name[] newArray(int size) {
            return (new Name[size]);
        }

    }
    ;

    protected Name(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Name() {
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

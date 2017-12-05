
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImContentType implements Parcelable
{

    @SerializedName("attributes")
    @Expose
    private Attributes__ attributes;
    public final static Parcelable.Creator<ImContentType> CREATOR = new Creator<ImContentType>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ImContentType createFromParcel(Parcel in) {
            return new ImContentType(in);
        }

        public ImContentType[] newArray(int size) {
            return (new ImContentType[size]);
        }

    }
    ;

    protected ImContentType(Parcel in) {
        this.attributes = ((Attributes__) in.readValue((Attributes__.class.getClassLoader())));
    }

    public ImContentType() {
    }

    public Attributes__ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes__ attributes) {
        this.attributes = attributes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(attributes);
    }

    public int describeContents() {
        return  0;
    }

}

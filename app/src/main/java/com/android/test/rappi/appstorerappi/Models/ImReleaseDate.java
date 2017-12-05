
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImReleaseDate implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("attributes")
    @Expose
    private Attributes_______ attributes;
    public final static Parcelable.Creator<ImReleaseDate> CREATOR = new Creator<ImReleaseDate>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ImReleaseDate createFromParcel(Parcel in) {
            return new ImReleaseDate(in);
        }

        public ImReleaseDate[] newArray(int size) {
            return (new ImReleaseDate[size]);
        }

    }
    ;

    protected ImReleaseDate(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
        this.attributes = ((Attributes_______) in.readValue((Attributes_______.class.getClassLoader())));
    }

    public ImReleaseDate() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes_______ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes_______ attributes) {
        this.attributes = attributes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(label);
        dest.writeValue(attributes);
    }

    public int describeContents() {
        return  0;
    }

}

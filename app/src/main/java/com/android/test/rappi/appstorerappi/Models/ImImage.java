
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImImage implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("attributes")
    @Expose
    private Attributes attributes;
    public final static Parcelable.Creator<ImImage> CREATOR = new Creator<ImImage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ImImage createFromParcel(Parcel in) {
            return new ImImage(in);
        }

        public ImImage[] newArray(int size) {
            return (new ImImage[size]);
        }

    }
    ;

    protected ImImage(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
        this.attributes = ((Attributes) in.readValue((Attributes.class.getClassLoader())));
    }

    public ImImage() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
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

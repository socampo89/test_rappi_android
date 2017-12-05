
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImArtist implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("attributes")
    @Expose
    private Attributes_____ attributes;
    public final static Parcelable.Creator<ImArtist> CREATOR = new Creator<ImArtist>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ImArtist createFromParcel(Parcel in) {
            return new ImArtist(in);
        }

        public ImArtist[] newArray(int size) {
            return (new ImArtist[size]);
        }

    }
    ;

    protected ImArtist(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
        this.attributes = ((Attributes_____) in.readValue((Attributes_____.class.getClassLoader())));
    }

    public ImArtist() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes_____ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes_____ attributes) {
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

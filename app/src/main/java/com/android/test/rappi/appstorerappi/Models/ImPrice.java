
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImPrice implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("attributes")
    @Expose
    private Attributes_ attributes;
    public final static Parcelable.Creator<ImPrice> CREATOR = new Creator<ImPrice>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ImPrice createFromParcel(Parcel in) {
            return new ImPrice(in);
        }

        public ImPrice[] newArray(int size) {
            return (new ImPrice[size]);
        }

    }
    ;

    protected ImPrice(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
        this.attributes = ((Attributes_) in.readValue((Attributes_.class.getClassLoader())));
    }

    public ImPrice() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes_ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes_ attributes) {
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

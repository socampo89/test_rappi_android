
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Id implements Parcelable
{

    @SerializedName("label")
    @Expose
    private String label;
    @SerializedName("attributes")
    @Expose
    private Attributes____ attributes;
    public final static Parcelable.Creator<Id> CREATOR = new Creator<Id>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Id createFromParcel(Parcel in) {
            return new Id(in);
        }

        public Id[] newArray(int size) {
            return (new Id[size]);
        }

    }
    ;

    protected Id(Parcel in) {
        this.label = ((String) in.readValue((String.class.getClassLoader())));
        this.attributes = ((Attributes____) in.readValue((Attributes____.class.getClassLoader())));
    }

    public Id() {
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Attributes____ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes____ attributes) {
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

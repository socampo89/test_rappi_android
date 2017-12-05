
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link implements Parcelable
{

    @SerializedName("attributes")
    @Expose
    private Attributes___ attributes;
    public final static Parcelable.Creator<Link> CREATOR = new Creator<Link>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Link createFromParcel(Parcel in) {
            return new Link(in);
        }

        public Link[] newArray(int size) {
            return (new Link[size]);
        }

    }
    ;

    protected Link(Parcel in) {
        this.attributes = ((Attributes___) in.readValue((Attributes___.class.getClassLoader())));
    }

    public Link() {
    }

    public Attributes___ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes___ attributes) {
        this.attributes = attributes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(attributes);
    }

    public int describeContents() {
        return  0;
    }

}


package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Link_ implements Parcelable
{

    @SerializedName("attributes")
    @Expose
    private Attributes________ attributes;
    public final static Parcelable.Creator<Link_> CREATOR = new Creator<Link_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Link_ createFromParcel(Parcel in) {
            return new Link_(in);
        }

        public Link_[] newArray(int size) {
            return (new Link_[size]);
        }

    }
    ;

    protected Link_(Parcel in) {
        this.attributes = ((Attributes________) in.readValue((Attributes________.class.getClassLoader())));
    }

    public Link_() {
    }

    public Attributes________ getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes________ attributes) {
        this.attributes = attributes;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(attributes);
    }

    public int describeContents() {
        return  0;
    }

}

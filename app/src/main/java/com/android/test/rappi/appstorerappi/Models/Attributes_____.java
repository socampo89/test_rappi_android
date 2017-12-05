
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes_____ implements Parcelable
{

    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Attributes_____> CREATOR = new Creator<Attributes_____>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Attributes_____ createFromParcel(Parcel in) {
            return new Attributes_____(in);
        }

        public Attributes_____[] newArray(int size) {
            return (new Attributes_____[size]);
        }

    }
    ;

    protected Attributes_____(Parcel in) {
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Attributes_____() {
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}

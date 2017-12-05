
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes____ implements Parcelable
{

    @SerializedName("im:id")
    @Expose
    private String imId;
    @SerializedName("im:bundleId")
    @Expose
    private String imBundleId;
    public final static Parcelable.Creator<Attributes____> CREATOR = new Creator<Attributes____>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Attributes____ createFromParcel(Parcel in) {
            return new Attributes____(in);
        }

        public Attributes____[] newArray(int size) {
            return (new Attributes____[size]);
        }

    }
    ;

    protected Attributes____(Parcel in) {
        this.imId = ((String) in.readValue((String.class.getClassLoader())));
        this.imBundleId = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Attributes____() {
    }

    public String getImId() {
        return imId;
    }

    public void setImId(String imId) {
        this.imId = imId;
    }

    public String getImBundleId() {
        return imBundleId;
    }

    public void setImBundleId(String imBundleId) {
        this.imBundleId = imBundleId;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(imId);
        dest.writeValue(imBundleId);
    }

    public int describeContents() {
        return  0;
    }

}


package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes________ implements Parcelable
{

    @SerializedName("rel")
    @Expose
    private String rel;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("href")
    @Expose
    private String href;
    public final static Parcelable.Creator<Attributes________> CREATOR = new Creator<Attributes________>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Attributes________ createFromParcel(Parcel in) {
            return new Attributes________(in);
        }

        public Attributes________[] newArray(int size) {
            return (new Attributes________[size]);
        }

    }
    ;

    protected Attributes________(Parcel in) {
        this.rel = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Attributes________() {
    }

    public String getRel() {
        return rel;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(rel);
        dest.writeValue(type);
        dest.writeValue(href);
    }

    public int describeContents() {
        return  0;
    }

}

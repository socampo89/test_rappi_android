
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes___ implements Parcelable
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
    public final static Parcelable.Creator<Attributes___> CREATOR = new Creator<Attributes___>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Attributes___ createFromParcel(Parcel in) {
            return new Attributes___(in);
        }

        public Attributes___[] newArray(int size) {
            return (new Attributes___[size]);
        }

    }
    ;

    protected Attributes___(Parcel in) {
        this.rel = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.href = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Attributes___() {
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

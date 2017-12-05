
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes______ implements Parcelable
{

    @SerializedName("im:id")
    @Expose
    private String imId;
    @SerializedName("term")
    @Expose
    private String term;
    @SerializedName("scheme")
    @Expose
    private String scheme;
    @SerializedName("label")
    @Expose
    private String label;
    public final static Parcelable.Creator<Attributes______> CREATOR = new Creator<Attributes______>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Attributes______ createFromParcel(Parcel in) {
            return new Attributes______(in);
        }

        public Attributes______[] newArray(int size) {
            return (new Attributes______[size]);
        }

    }
    ;

    protected Attributes______(Parcel in) {
        this.imId = ((String) in.readValue((String.class.getClassLoader())));
        this.term = ((String) in.readValue((String.class.getClassLoader())));
        this.scheme = ((String) in.readValue((String.class.getClassLoader())));
        this.label = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Attributes______() {
    }

    public String getImId() {
        return imId;
    }

    public void setImId(String imId) {
        this.imId = imId;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getScheme() {
        return scheme;
    }

    public void setScheme(String scheme) {
        this.scheme = scheme;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(imId);
        dest.writeValue(term);
        dest.writeValue(scheme);
        dest.writeValue(label);
    }

    public int describeContents() {
        return  0;
    }

}

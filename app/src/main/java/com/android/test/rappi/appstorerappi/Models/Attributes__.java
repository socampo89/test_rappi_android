
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes__ implements Parcelable
{

    @SerializedName("term")
    @Expose
    private String term;
    @SerializedName("label")
    @Expose
    private String label;
    public final static Parcelable.Creator<Attributes__> CREATOR = new Creator<Attributes__>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Attributes__ createFromParcel(Parcel in) {
            return new Attributes__(in);
        }

        public Attributes__[] newArray(int size) {
            return (new Attributes__[size]);
        }

    }
    ;

    protected Attributes__(Parcel in) {
        this.term = ((String) in.readValue((String.class.getClassLoader())));
        this.label = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Attributes__() {
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(term);
        dest.writeValue(label);
    }

    public int describeContents() {
        return  0;
    }

}

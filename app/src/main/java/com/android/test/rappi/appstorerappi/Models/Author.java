
package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Author implements Parcelable
{

    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("uri")
    @Expose
    private Uri uri;
    public final static Parcelable.Creator<Author> CREATOR = new Creator<Author>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Author createFromParcel(Parcel in) {
            return new Author(in);
        }

        public Author[] newArray(int size) {
            return (new Author[size]);
        }

    }
    ;

    protected Author(Parcel in) {
        this.name = ((Name) in.readValue((Name.class.getClassLoader())));
        this.uri = ((Uri) in.readValue((Uri.class.getClassLoader())));
    }

    public Author() {
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(name);
        dest.writeValue(uri);
    }

    public int describeContents() {
        return  0;
    }

}


package com.android.test.rappi.appstorerappi.Models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes_ implements Parcelable
{

    @SerializedName("amount")
    @Expose
    private String amount;
    @SerializedName("currency")
    @Expose
    private String currency;
    public final static Parcelable.Creator<Attributes_> CREATOR = new Creator<Attributes_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Attributes_ createFromParcel(Parcel in) {
            return new Attributes_(in);
        }

        public Attributes_[] newArray(int size) {
            return (new Attributes_[size]);
        }

    }
    ;

    protected Attributes_(Parcel in) {
        this.amount = ((String) in.readValue((String.class.getClassLoader())));
        this.currency = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Attributes_() {
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(amount);
        dest.writeValue(currency);
    }

    public int describeContents() {
        return  0;
    }

}

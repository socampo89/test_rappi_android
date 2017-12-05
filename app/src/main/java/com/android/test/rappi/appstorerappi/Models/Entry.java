
package com.android.test.rappi.appstorerappi.Models;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Entry implements Parcelable
{

    @SerializedName("im:name")
    @Expose
    private ImName imName;
    @SerializedName("im:image")
    @Expose
    private List<ImImage> imImage = new ArrayList();
    @SerializedName("summary")
    @Expose
    private Summary summary;
    @SerializedName("im:price")
    @Expose
    private ImPrice imPrice;
    @SerializedName("im:contentType")
    @Expose
    private ImContentType imContentType;
    @SerializedName("rights")
    @Expose
    private Rights rights;
    @SerializedName("title")
    @Expose
    private Title title;
    @SerializedName("link")
    @Expose
    private Link link;
    @SerializedName("id")
    @Expose
    private Id id;
    @SerializedName("im:artist")
    @Expose
    private ImArtist imArtist;
    @SerializedName("category")
    @Expose
    private Category category;
    @SerializedName("im:releaseDate")
    @Expose
    private ImReleaseDate imReleaseDate;
    public final static Parcelable.Creator<Entry> CREATOR = new Creator<Entry>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Entry createFromParcel(Parcel in) {
            return new Entry(in);
        }

        public Entry[] newArray(int size) {
            return (new Entry[size]);
        }

    }
    ;

    protected Entry(Parcel in) {
        this.imName = ((ImName) in.readValue((ImName.class.getClassLoader())));
        in.readList(this.imImage, (com.android.test.rappi.appstorerappi.Models.ImImage.class.getClassLoader()));
        this.summary = ((Summary) in.readValue((Summary.class.getClassLoader())));
        this.imPrice = ((ImPrice) in.readValue((ImPrice.class.getClassLoader())));
        this.imContentType = ((ImContentType) in.readValue((ImContentType.class.getClassLoader())));
        this.rights = ((Rights) in.readValue((Rights.class.getClassLoader())));
        this.title = ((Title) in.readValue((Title.class.getClassLoader())));
        this.link = ((Link) in.readValue((Link.class.getClassLoader())));
        this.id = ((Id) in.readValue((Id.class.getClassLoader())));
        this.imArtist = ((ImArtist) in.readValue((ImArtist.class.getClassLoader())));
        this.category = ((Category) in.readValue((Category.class.getClassLoader())));
        this.imReleaseDate = ((ImReleaseDate) in.readValue((ImReleaseDate.class.getClassLoader())));
    }

    public Entry() {
    }

    public ImName getImName() {
        return imName;
    }

    public void setImName(ImName imName) {
        this.imName = imName;
    }

    public List<ImImage> getImImage() {
        return imImage;
    }

    public void setImImage(List<ImImage> imImage) {
        this.imImage = imImage;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public ImPrice getImPrice() {
        return imPrice;
    }

    public void setImPrice(ImPrice imPrice) {
        this.imPrice = imPrice;
    }

    public ImContentType getImContentType() {
        return imContentType;
    }

    public void setImContentType(ImContentType imContentType) {
        this.imContentType = imContentType;
    }

    public Rights getRights() {
        return rights;
    }

    public void setRights(Rights rights) {
        this.rights = rights;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }

    public Id getId() {
        return id;
    }

    public void setId(Id id) {
        this.id = id;
    }

    public ImArtist getImArtist() {
        return imArtist;
    }

    public void setImArtist(ImArtist imArtist) {
        this.imArtist = imArtist;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public ImReleaseDate getImReleaseDate() {
        return imReleaseDate;
    }

    public void setImReleaseDate(ImReleaseDate imReleaseDate) {
        this.imReleaseDate = imReleaseDate;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(imName);
        dest.writeList(imImage);
        dest.writeValue(summary);
        dest.writeValue(imPrice);
        dest.writeValue(imContentType);
        dest.writeValue(rights);
        dest.writeValue(title);
        dest.writeValue(link);
        dest.writeValue(id);
        dest.writeValue(imArtist);
        dest.writeValue(category);
        dest.writeValue(imReleaseDate);
    }

    public int describeContents() {
        return  0;
    }

}

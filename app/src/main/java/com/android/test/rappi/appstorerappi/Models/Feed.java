
package com.android.test.rappi.appstorerappi.Models;

import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Feed implements Parcelable
{

    @SerializedName("author")
    @Expose
    private Author author;
    @SerializedName("entry")
    @Expose
    private List<Entry> entry = new ArrayList<>();
    @SerializedName("updated")
    @Expose
    private Updated updated;
    @SerializedName("rights")
    @Expose
    private Rights_ rights;
    @SerializedName("title")
    @Expose
    private Title_ title;
    @SerializedName("icon")
    @Expose
    private Icon icon;
    @SerializedName("link")
    @Expose
    private List<Link_> link = new ArrayList<>();
    @SerializedName("id")
    @Expose
    private Id_ id;
    public final static Parcelable.Creator<Feed> CREATOR = new Creator<Feed>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Feed createFromParcel(Parcel in) {
            return new Feed(in);
        }

        public Feed[] newArray(int size) {
            return (new Feed[size]);
        }

    }
    ;

    protected Feed(Parcel in) {
        this.author = ((Author) in.readValue((Author.class.getClassLoader())));
        in.readList(this.entry, (com.android.test.rappi.appstorerappi.Models.Entry.class.getClassLoader()));
        this.updated = ((Updated) in.readValue((Updated.class.getClassLoader())));
        this.rights = ((Rights_) in.readValue((Rights_.class.getClassLoader())));
        this.title = ((Title_) in.readValue((Title_.class.getClassLoader())));
        this.icon = ((Icon) in.readValue((Icon.class.getClassLoader())));
        in.readList(this.link, (com.android.test.rappi.appstorerappi.Models.Link_.class.getClassLoader()));
        this.id = ((Id_) in.readValue((Id_.class.getClassLoader())));
    }

    public Feed() {
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public List<Entry> getEntry() {
        return entry;
    }

    public void setEntry(List<Entry> entry) {
        this.entry = entry;
    }

    public Updated getUpdated() {
        return updated;
    }

    public void setUpdated(Updated updated) {
        this.updated = updated;
    }

    public Rights_ getRights() {
        return rights;
    }

    public void setRights(Rights_ rights) {
        this.rights = rights;
    }

    public Title_ getTitle() {
        return title;
    }

    public void setTitle(Title_ title) {
        this.title = title;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }

    public List<Link_> getLink() {
        return link;
    }

    public void setLink(List<Link_> link) {
        this.link = link;
    }

    public Id_ getId() {
        return id;
    }

    public void setId(Id_ id) {
        this.id = id;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(author);
        dest.writeList(entry);
        dest.writeValue(updated);
        dest.writeValue(rights);
        dest.writeValue(title);
        dest.writeValue(icon);
        dest.writeList(link);
        dest.writeValue(id);
    }

    public int describeContents() {
        return  0;
    }

}

package com.education.githubclient.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;
import com.squareup.picasso.Picasso;

public class User extends BaseObservable implements Parcelable {
    private String email;
    private String displayName;
    private String password;
    private String token;
    private String avatar;
    private String url;
    private String followers;
    private String following;

    @Bindable
    public String getEmail(){
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
        notifyChange();
    }

    @Bindable
    public String getDisplayName(){
        return displayName;
    }

    public void setDisplayName(String displayName){
        this.displayName = displayName;
        notifyChange();
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyChange();
    }

    @Bindable
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
        notifyChange();
    }

    @Bindable
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
        notifyChange();
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyChange();
    }

    @Bindable
    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
        notifyChange();
    }

    @Bindable
    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
        notifyChange();
    }

    public User(){
        email = "";
        displayName ="";
        password = "";
        token = "";
        avatar = "";
        url = "";
        followers = "";
        following = "";
    }

    protected User(Parcel in) {
        email = in.readString();
        displayName = in.readString();
        password = in.readString();
        token = in.readString();
        avatar = in.readString();
        url = in.readString();
        followers = in.readString();
        following = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(email);
        parcel.writeString(displayName);
        parcel.writeString(password);
        parcel.writeString(token);
        parcel.writeString(avatar);
        parcel.writeString(url);
        parcel.writeString(followers);
        parcel.writeString(following);
    }

    @BindingAdapter("app:avatar")
    public static void loadImage(ImageView view, String url){
        Picasso.get().load(url).into(view);
    }
}

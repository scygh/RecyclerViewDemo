package com.scy.recyclerviewdemo.link;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/29 14:15
 */
public class CityCinema implements Parcelable {
    private String name;
    private String titleName;
    private String tag;
    private boolean isTitle;
    private String imgsrc;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public boolean isTitle() {
        return isTitle;
    }

    public void setTitle(boolean title) {
        isTitle = title;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }

    public CityCinema(String name) {
        this.name = name;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.titleName);
        dest.writeString(this.tag);
        dest.writeByte(this.isTitle ? (byte) 1 : (byte) 0);
        dest.writeString(this.imgsrc);
    }

    protected CityCinema(Parcel in) {
        this.name = in.readString();
        this.titleName = in.readString();
        this.tag = in.readString();
        this.isTitle = in.readByte() != 0;
        this.imgsrc = in.readString();
    }

    public static final Parcelable.Creator<CityCinema> CREATOR = new Parcelable.Creator<CityCinema>() {
        @Override
        public CityCinema createFromParcel(Parcel source) {
            return new CityCinema(source);
        }

        @Override
        public CityCinema[] newArray(int size) {
            return new CityCinema[size];
        }
    };
}

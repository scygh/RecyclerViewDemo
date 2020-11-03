package com.scy.recyclerviewdemo.link;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * description ：
 * author : scy
 * email : 1797484636@qq.com
 * date : 2020/10/29 13:53
 */
public class CityArea implements Parcelable {
    private String name;
    private String tag;
    private boolean isTitle;
    private String imgsrc;
    private String titleName;
    private ArrayList<CategoryOneArrayBean> categoryOneArray;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public ArrayList<CategoryOneArrayBean> getCategoryOneArray() {
        return categoryOneArray;
    }

    public void setCategoryOneArray(ArrayList<CategoryOneArrayBean> categoryOneArray) {
        this.categoryOneArray = categoryOneArray;
    }


    public static class CategoryOneArrayBean implements Parcelable {
        private String name;
        private String imgsrc;
        private String cacode;
        private List<CategoryTwoArrayBean> categoryTwoArray;


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getImgsrc() {
            return imgsrc;
        }

        public void setImgsrc(String imgsrc) {
            this.imgsrc = imgsrc;
        }

        public String getCacode() {
            return cacode;
        }

        public void setCacode(String cacode) {
            this.cacode = cacode;
        }

        public List<CategoryTwoArrayBean> getCategoryTwoArray() {
            return categoryTwoArray;
        }

        public void setCategoryTwoArray(List<CategoryTwoArrayBean> categoryTwoArray) {
            this.categoryTwoArray = categoryTwoArray;
        }

        public static class CategoryTwoArrayBean implements Parcelable {
            private String name;
            private String imgsrc;
            private String cacode;


            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getImgsrc() {
                return imgsrc;
            }

            public void setImgsrc(String imgsrc) {
                this.imgsrc = imgsrc;
            }

            public String getCacode() {
                return cacode;
            }

            public void setCacode(String cacode) {
                this.cacode = cacode;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.name);
                dest.writeString(this.imgsrc);
                dest.writeString(this.cacode);
            }

            public CategoryTwoArrayBean() {
            }

            protected CategoryTwoArrayBean(Parcel in) {
                this.name = in.readString();
                this.imgsrc = in.readString();
                this.cacode = in.readString();
            }

            public static final Parcelable.Creator<CategoryTwoArrayBean> CREATOR = new Parcelable.Creator<CategoryTwoArrayBean>() {
                @Override
                public CategoryTwoArrayBean createFromParcel(Parcel source) {
                    return new CategoryTwoArrayBean(source);
                }

                @Override
                public CategoryTwoArrayBean[] newArray(int size) {
                    return new CategoryTwoArrayBean[size];
                }
            };
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.name);
            dest.writeString(this.imgsrc);
            dest.writeString(this.cacode);
            dest.writeTypedList(this.categoryTwoArray);
        }

        public CategoryOneArrayBean() {
        }

        protected CategoryOneArrayBean(Parcel in) {
            this.name = in.readString();
            this.imgsrc = in.readString();
            this.cacode = in.readString();
            this.categoryTwoArray = in.createTypedArrayList(CategoryTwoArrayBean.CREATOR);
        }

        public static final Creator<CategoryOneArrayBean> CREATOR = new Creator<CategoryOneArrayBean>() {
            @Override
            public CategoryOneArrayBean createFromParcel(Parcel source) {
                return new CategoryOneArrayBean(source);
            }

            @Override
            public CategoryOneArrayBean[] newArray(int size) {
                return new CategoryOneArrayBean[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.tag);
        dest.writeByte(this.isTitle ? (byte) 1 : (byte) 0);
        dest.writeString(this.imgsrc);
        dest.writeString(this.titleName);
        dest.writeTypedList(this.categoryOneArray);
    }

    public CityArea() {
    }

    protected CityArea(Parcel in) {
        this.name = in.readString();
        this.tag = in.readString();
        this.isTitle = in.readByte() != 0;
        this.imgsrc = in.readString();
        this.titleName = in.readString();
        this.categoryOneArray = in.createTypedArrayList(CategoryOneArrayBean.CREATOR);
    }

    public static final Parcelable.Creator<CityArea> CREATOR = new Parcelable.Creator<CityArea>() {
        @Override
        public CityArea createFromParcel(Parcel source) {
            return new CityArea(source);
        }

        @Override
        public CityArea[] newArray(int size) {
            return new CityArea[size];
        }
    };

}

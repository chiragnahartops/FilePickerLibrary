package com.tops.filepicker.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;

import com.tops.filepicker.R;


/**
 * Created by chirag on 01/10/19.
 */
public class FileType implements Parcelable {
    public String title;

    @DrawableRes
    private int drawable;

    public String[] extensions;

    public FileType(String title, String[] extensions, int drawable) {
        this.title = title;
        this.extensions = extensions;
        this.drawable = drawable;
    }

    protected FileType(Parcel in) {
        title = in.readString();
        drawable = in.readInt();
        extensions = in.createStringArray();
    }

    public static final Creator<FileType> CREATOR = new Creator<FileType>() {
        @Override
        public FileType createFromParcel(Parcel in) {
            return new FileType(in);
        }

        @Override
        public FileType[] newArray(int size) {
            return new FileType[size];
        }
    };

    public int getDrawable() {
        if (drawable == 0)
            return R.drawable.icon_file_unknown;
        return drawable;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(title);
        parcel.writeInt(drawable);
        parcel.writeStringArray(extensions);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FileType fileType = (FileType) o;

        return title != null ? title.equals(fileType.title) : fileType.title == null;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }
}

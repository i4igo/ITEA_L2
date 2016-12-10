package com.itea.android.itea_l2;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ev on 08.12.2016.
 */

public class POJO implements Parcelable {

    private String ivImage;
    private String etName;
    private String etLName;
    private String etPNumber;
    private String etCountry;
    private String etCity;
    private String etEmail;
    private String etNotes;


    public POJO(String ivImage, String etName, String etLName, String etPNumber, String etCountry, String etCity, String etEmail, String etNotes) {
        this.ivImage = ivImage;
        this.etName = etName;
        this.etLName = etLName;
        this.etPNumber = etPNumber;
        this.etCountry = etCountry;
        this.etCity = etCity;
        this.etEmail = etEmail;
        this.etNotes = etNotes;
    }

    public String getsImage() {
        return ivImage;
    }

    public void setsImage(String sImage) {
        this.ivImage = sImage;
    }

    public String getEtName() {
        return etName;
    }

    public void setEtName(String etName) {
        this.etName = etName;
    }

    public String getEtLName() {
        return etLName;
    }

    public void setEtLName(String etLName) {
        this.etLName = etLName;
    }

    public String getEtPNumber() {
        return etPNumber;
    }

    public void setEtPNumber(String etPNumber) {
        this.etPNumber = etPNumber;
    }

    public String getEtCountry() {
        return etCountry;
    }

    public void setEtCountry(String etCountry) {
        this.etCountry = etCountry;
    }

    public String getEtCity() {
        return etCity;
    }

    public void setEtCity(String etCity) {
        this.etCity = etCity;
    }

    public String getEtEmail() {
        return etEmail;
    }

    public void setEtEmail(String etEmail) {
        this.etEmail = etEmail;
    }

    public String getEtNotes() {
        return etNotes;
    }

    public void setEtNotes(String etNotes) {
        this.etNotes = etNotes;
    }

    protected POJO(Parcel in) {
        etName = in.readString();
        etLName = in.readString();
        etPNumber = in.readString();
        etCountry = in.readString();
        etCity = in.readString();
        etEmail = in.readString();
        etNotes = in.readString();
    }

    public static final Creator<POJO> CREATOR = new Creator<POJO>() {
        @Override
        public POJO createFromParcel(Parcel in) {
            return new POJO(in);
        }

        @Override
        public POJO[] newArray(int size) {
            return new POJO[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeString(etName);
        parcel.writeString(etLName);
        parcel.writeString(etPNumber);
        parcel.writeString(etCountry);
        parcel.writeString(etCity);
        parcel.writeString(etEmail);
        parcel.writeString(etNotes);
    }
}

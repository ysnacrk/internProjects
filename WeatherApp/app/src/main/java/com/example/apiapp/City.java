package com.example.apiapp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class City {

        @SerializedName("id")
        @Expose
        private Integer id;

        @SerializedName("name")
        @Expose
        private String name;

        @SerializedName("country")
        @Expose
        private String country;

        @SerializedName("timezone")
        @Expose
        private Integer timezone;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Integer getTimezone() {
            return timezone;
        }

        public void setTimezone(Integer timezone) {
            this.timezone = timezone;
        }

    }

package shapiro.presidents;


import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class President implements Serializable {
    private int number;
    private String president;
    @SerializedName("birth_year") private int birthYear;
    @SerializedName("death_year") private Integer deathYear;
    @SerializedName("took_office") private String tookOffice;
    @SerializedName("left_office") private String leftOffice;
    private String party;

    public int getNumber() {
        return number;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public String getTookOffice() {
        return tookOffice;
    }

    public String getLeftOffice() {
        return leftOffice;
    }

    public String getParty() {
        return party;
    }

    public String getPresident() {
        return president;
    }
}

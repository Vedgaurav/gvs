package com.voice.common.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Getter
@Setter
public class YatraRegEmail {
    private String devoteeId;
    private String name;
    private String dateOfBirth;
    private String gender;
    private String contact;
    private String facilitator;
    private String chantingRounds;
    private String registeredBy;
    private String contactRegisteredBy;
    private String registeredByEmail;
    private String paidByEmail;
    private String currentCity;

    //FOR ONLY TMP ID'S
    private String accomEmail;
    private String accomName;
    private String accomPhone;
    private String sendTMPIdEmailTo;
    @Getter(AccessLevel.NONE)
    private int calculatedAge;

    public YatraRegEmail() {
    }
    public int getCalculatedAge(){
        if(calculatedAge!=0) return calculatedAge;
        if(!dateOfBirth.isEmpty()){
            String dob = dateOfBirth;
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            LocalDate birthDate = LocalDate.parse(dob, formatter);
            LocalDate currentDate = LocalDate.now();
            Period period = Period.between(birthDate, currentDate);
            calculatedAge = period.getYears();
            return calculatedAge;
        }
        return -1;
    }
}
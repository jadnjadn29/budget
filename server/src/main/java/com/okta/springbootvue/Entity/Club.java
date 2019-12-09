package com.okta.springbootvue.Entity;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import java.util.Collection;

@Entity
@Data
@Table(name="Club")
@Getter 
@Setter

@NoArgsConstructor
public class Club {
    @Id
    @SequenceGenerator(name="club_seq",sequenceName="club_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="club_seq")
    @Column(name="clubId",unique = true, nullable = false)
    private Long clubId;

    @NotNull 
    private String clubName;
    

    public Long getClubId() {
        return clubId;
    }
    

    public void setClubId(Long clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String  clubName) {
        this.clubName =  clubName;
    }
   
    


}
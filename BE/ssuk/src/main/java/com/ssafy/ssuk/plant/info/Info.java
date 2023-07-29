package com.ssafy.ssuk.plant.info;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ssafy.ssuk.plant.info.dto.InfoRegisterRequestDto;
import com.ssafy.ssuk.plant.info.dto.InfoUpdateRequestDto;
import com.ssafy.ssuk.plant.plant.Plant;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.ibatis.annotations.One;

import javax.persistence.*;

import static javax.persistence.FetchType.*;

@Entity
@Table(name = "plant_info")
@IdClass(InfoId.class)
@NoArgsConstructor
@Getter
public class Info {

    @Id
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "plant_id")
    @JsonIgnore
    private Plant plant;
    @Id
    private Integer level;
    @Column(name = "plant_guide")
    private String guide;
    @Column(name = "water_term")
    private Integer waterTerm;
    @Column(name = "water_amount")
    private Integer waterAmount;
    @Column(name = "character_name")
    private String characterName;
    @Column(name = "character_comment")
    private String characterComment;
    @Column(name = "character_image")
    private String characterImage;

    public Info(InfoRegisterRequestDto infoRegisterRequestDto, Plant plant) {
        this.plant = plant;
        this.level = infoRegisterRequestDto.getLevel();
        this.guide = infoRegisterRequestDto.getPlantGuide();
        this.waterTerm = infoRegisterRequestDto.getWaterTerm();
        this.waterAmount = infoRegisterRequestDto.getWaterAmount();
        this.characterName = infoRegisterRequestDto.getCharacterName();
        this.characterComment = infoRegisterRequestDto.getCharacterComment();
        this.characterImage = infoRegisterRequestDto.getCharacterImage();
    }

    public void modifyInfo(InfoUpdateRequestDto infoUpdateRequestDto) {
        this.guide = infoUpdateRequestDto.getPlantGuide();
        this.waterTerm = infoUpdateRequestDto.getWaterTerm();
        this.waterAmount = infoUpdateRequestDto.getWaterAmount();
        this.characterName = infoUpdateRequestDto.getCharacterName();
        this.characterComment = infoUpdateRequestDto.getCharacterComment();
        this.characterImage = infoUpdateRequestDto.getCharacterImage();
    }
}

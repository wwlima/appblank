package br.com.w2lima.appblank.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.w2lima.appblank.model.enums.UserStatusEum;
import br.com.w2lima.appblank.model.enums.converter.UserStatusConverter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_USER")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserModel {

	@Id
	@Column(name = "ID_USER", length = 36)
    private UUID id;

	@Column(name = "NM_USER")
    private String name;

	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDate born;
	
	@Convert(converter = UserStatusConverter.class)	
	private UserStatusEum status;

}

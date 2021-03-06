package com.padillatomas.mundo_disney.disney.dto;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MovieFiltersDTO {

	private String title;
	private Set<Long> genre;
	private String order;
	
	public boolean isASC() {
		return this.order.compareToIgnoreCase("ASC") == 0;
	}
	
	public boolean isDESC() {
		return this.order.compareToIgnoreCase("DESC") == 0;
	}
}

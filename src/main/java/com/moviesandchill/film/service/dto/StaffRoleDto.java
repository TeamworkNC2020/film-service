package com.moviesandchill.film.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StaffRoleDto {

    private Long id_staff_role;

    private String roleTitle;
}

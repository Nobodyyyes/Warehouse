package com.example.warehouse.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class WarehouseLocationModel {

    private Long id;
    private String section;
    private String shelf;
    private String description;
    private List<WeaponModel> weapons;
    private List<WeaponHistoryModel> issueHistories;
}

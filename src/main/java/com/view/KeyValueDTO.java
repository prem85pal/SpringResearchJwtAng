package com.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class KeyValueDTO {

    private String key;
    private String value;

    public KeyValueDTO(String key, String value) {
        this.key = key;
        this.value = value;
    }

}

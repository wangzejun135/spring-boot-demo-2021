package study2021.map;

import lombok.Data;

import java.io.Serializable;

@Data
public class CodeListPO implements Serializable {
    /**
     * 名称
     */
    private String name;

    /**
     * code码
     */
    private String code;
}

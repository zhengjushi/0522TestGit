package com.juju.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author juju
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {


	private Long id;
    private String serial;
}

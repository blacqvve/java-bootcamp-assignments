package com.hrms.hrms.core.utilities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BasicTuple<TOne,TTwo> {
    
    private TOne item1;

    private TTwo item2;


}

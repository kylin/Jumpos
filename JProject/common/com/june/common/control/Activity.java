package com.june.common.control;

import com.june.common.api.WorkObject;

public interface Activity {
    String getName();
    void setOwner(WorkObject wo);
//    void perform();
}

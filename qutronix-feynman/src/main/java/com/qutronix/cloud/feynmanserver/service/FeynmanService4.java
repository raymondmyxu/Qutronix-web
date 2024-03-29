package com.qutronix.cloud.feynmanserver.service;

import com.mathworks.toolbox.javabuilder.MWException;
import com.qutronix.cloud.feynmanserver.dto.BS_dataForm;
import com.qutronix.cloud.feynmanserver.dto.MPQW_dataForm;
import com.qutronix.cloud.feynmanserver.dto.MPResultDTO;

public interface FeynmanService4 {

    void feynmanTest() throws MWException;
    MPResultDTO plot1(MPQW_dataForm mpqw_dataForm) throws MWException;
}

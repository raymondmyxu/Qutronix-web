package com.qutronix.cloud.feynmanserver.service.impl;

import com.mathworks.toolbox.javabuilder.MWException;
import com.qutronix.cloud.feynman.JQws;
import com.qutronix.cloud.feynmanserver.config.FeynmanConfig;
import com.qutronix.cloud.feynmanserver.dto.MPQW_dataForm;
import com.qutronix.cloud.feynmanserver.dto.MPResultDTO;
import com.qutronix.cloud.feynmanserver.service.FeynmanService4;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("feynmanService4")
@Slf4j
public class FeynmanServiceImpl4 implements FeynmanService4 {

    @Autowired
    private FeynmanConfig feynmanConfig;

    @Override
    public void feynmanTest() throws MWException {
    }

    @Override
    public MPResultDTO plot1(MPQW_dataForm mpdataForm) throws MWException {
        String fEnumerate = mpdataForm.getUuid() + "_fEnumerate";
        String fTwoD = mpdataForm.getUuid() + "_fTwoD";
        String fOneOptic = mpdataForm.getUuid() + "_fOneOptic";
        String fRhoZ = mpdataForm.getUuid() + "_fRhoZ";

        String fEnumerateFile = feynmanConfig.filePath + fEnumerate + feynmanConfig.fileSuffix;
        String fTwoDFile = feynmanConfig.filePath + fTwoD + feynmanConfig.fileSuffix;
        String fOneOpticFile = feynmanConfig.filePath + fOneOptic + feynmanConfig.fileSuffix;
        String fRhoZFile = feynmanConfig.filePath + fRhoZ + feynmanConfig.fileSuffix;

        JQws jQws = new JQws();
        jQws.j_mp(mpdataForm.getDistance(), mpdataForm.getIniState(), mpdataForm.getProbStates()
                , mpdataForm.getStatMethod(), mpdataForm.getPerspectives(), mpdataForm.getPhotonNumber(),
                "colorbar_" + mpdataForm.getColorbar(), fEnumerateFile, fTwoDFile, fOneOpticFile, fRhoZFile);

        MPResultDTO build = MPResultDTO.builder().fEnumerate(fEnumerate)
                .fOneOptic(fOneOptic)
                .fRhoZ(fRhoZ)
                .fTwoD(fTwoD).build();
        return build;
    }
}

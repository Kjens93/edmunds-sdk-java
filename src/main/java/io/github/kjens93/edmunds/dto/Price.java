package io.github.kjens93.edmunds.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

import java.io.Serializable;

/**
 * Created by kjensen on 11/20/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price implements Serializable {

    private double baseMSRP;
    private double baseInvoice;
    private double deliveryCharges;
    private double usedTmvRetail;
    private double usedPrivateParty;
    private double usedTradeIn;
    private boolean estimateTmv;

}

package io.github.kjens93.edmunds.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Value;

/**
 * Created by kjensen on 11/20/16.
 */
@Value
@JsonIgnoreProperties(ignoreUnknown = true)
public class Price {

    private double baseMSRP;
    private double baseInvoice;
    private double deliveryCharges;
    private double usedTmvRetail;
    private double usedPrivateParty;
    private double usedTradeIn;
    private boolean estimateTmv;

}

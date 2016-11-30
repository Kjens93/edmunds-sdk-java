package io.github.kjens93.edmunds;

import io.github.kjens93.edmunds.enums.State;
import io.github.kjens93.edmunds.dtos.Model;
import io.github.kjens93.edmunds.services.ModelService;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kjensen on 11/20/16.
 */
public class EdmundsModelService_IT {

    private static final ModelService edmunds = new Edmunds(System.getenv("EDMUNDS_API_KEY"));

    @Test
    public void test_findModel_get() {
        assertThat(edmunds.findModel("honda", "accord").state(State.NEW).year(2014).get())
                .isEqualTo(new Model("Honda_Accord", "Accord", "accord"));
    }

}

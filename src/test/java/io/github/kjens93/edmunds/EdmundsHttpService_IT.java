package io.github.kjens93.edmunds;

import io.github.kjens93.edmunds.dtos.Makes;
import org.junit.Test;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by kjensen on 11/20/16.
 */
public class EdmundsHttpService_IT {

    @Test
    public void test() {
        EdmundsHttpService httpService = new EdmundsHttpService(System.getenv("EDMUNDS_API_KEY"));
        Makes vc = httpService.getOne(Makes.class, "/api/vehicle/v2/makes/count", new HashMap<String, Object>(){{
            put("view", "full");
        }});
        assertThat(vc.getMakesCount()).isBetween(10, 100);
    }

}
